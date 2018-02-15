package com.didi.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.DevicePo;
import com.didi.model.EChat;
import com.didi.model.EDdb;
import com.didi.model.EDevice;
import com.didi.model.EDeviceExample;
import com.didi.model.EOrders;
import com.didi.model.EOrdersExample;
import com.didi.model.EScaneLog;
import com.didi.model.EScaneLogExample;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.model.EWalletLog;
import com.didi.model.EWalletLogExample;
import com.didi.service.ChatService;
import com.didi.service.DdbService;
import com.didi.service.DeviceService;
import com.didi.service.OrdersService;
import com.didi.service.ScaneLogService;
import com.didi.service.UserService;
import com.didi.service.WalletLogService;
import com.didi.service.WalletService;
import com.didi.unti.TextUtils;

@Controller
@RequestMapping("/resource-service/device")
public class DeviceController {

	@Resource
	DeviceService deviceService;

	@Resource
	WalletLogService walletLogService;

	@Resource
	WalletService walletService;
	
	@Resource
	ChatService chatService;

	@Resource
	UserService userService;

	@Resource
	OrdersService orderService;

	@Resource
	ScaneLogService scaneLogService;

	@Resource
	DdbService ddbService;

	// 获取我的设备列表
	@RequestMapping(value = "/getMyDeviceList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMyDeviceList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam(required = true) String userId) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {

			EUser user = userService.get(userId);
			Map<String, Object> map = deviceService.MydeviceList(userId, 0, 0);

			List<EDevice> listtemp = (List<EDevice>) map.get("data");

			List<DevicePo> list = new ArrayList<DevicePo>();

			for (EDevice eDevice : listtemp) {

				EOrdersExample orderExample = new EOrdersExample();
				EOrdersExample.Criteria orderCriteria = orderExample.createCriteria();
				orderCriteria.andUserIdEqualTo(userId);
				orderCriteria.andDeviceIdEqualTo(eDevice.getId());
				orderExample.setOrderByClause("end_date desc");

				List<EOrders> orderList = (List<EOrders>) orderService.list(orderExample, 0, 0).get("data");
				DevicePo po = new DevicePo();
				po.setDeviceNo(eDevice.getDeviceNo());
				po.setImgUrl(eDevice.getImgUrl());
				po.setName(eDevice.getName());
				po.setId(eDevice.getId());
				po.setState(eDevice.getState());

				if (orderList == null || orderList.size() == 0) {
					po.setUpdateTime(eDevice.getUpdateTime());
					po.setTimeInfo("");
				} else {
					po.setUpdateTime(orderList.get(0).getStartDate());

					System.out.println(getTimeInfo(orderList.get(0).getEndDate()));

					po.setTimeInfo(getTimeInfo(orderList.get(0).getEndDate()));
				}

				list.add(po);
			}

			if (null != user.getRole() && user.getRole() == EUser.CHARGEMAN) {

				res.put("isChargeMan", "yes");
			} else {
				res.put("isChargeMan", "no");
			}

			res.put("result", list);
			res.put("status", 200);
			res.put("message", "查找成功!");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	@RequestMapping(value = "/getInvestList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getInvestList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam(required = true) String userId) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Map<String, Object> map = deviceService.MyInvestList(userId, 0, 0);

			List<EDevice> list = (List<EDevice>) map.get("data");

			res.put("result", list);
			res.put("status", 200);
			res.put("message", "查找成功!");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	/**
	 * 充电侠和管理员扫码的区别仅在于 库管在扫码后要设置owner,根据需要变更设备状态。
	 * 
	 */
	@RequestMapping(value = "/ReciveDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ReciveDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {

			// 第一步 用户参数校验
			EDevice device = deviceService.get(deviceId);
			EUser user = userService.get(userId);

			if (device == null) {
				res.put("message", "设备编号错误");
				res.put("status", 210);
				return res;
			}

			if (null == user) {
				res.put("status", 210);
				res.put("message", "查找失败，用户错误");
				return res;
			}

			boolean flag = true;

			// 第三步 判断有否有上一用户
			if (device.getUserId() != null && !device.getUserId().equals("")) {

				EUser lastuser = userService.get(device.getUserId());
				if (lastuser.getRole() == EUser.MANAGER || lastuser.getRole() == EUser.CHARGEMAN) {
					flag = false;
				}

				deviceService.endUse(device);

			}

			// 第二步 领回设备
			device.setUserId(userId);
			device.setManager(userId);
			deviceService.edit(device);

			// 第三步 插入扫码日志
			EScaneLog scaneLog = new EScaneLog();
			scaneLog.setId(TextUtils.getIdByUUID());
			scaneLog.setStartDate(new Date());
			scaneLog.setUserId(userId);
			scaneLog.setDeviceId(device.getId());
			scaneLog.setOpration(EScaneLog.RECIVE_DEVICE);
			scaneLog.setManager(device.getManager());
			scaneLogService.insert(scaneLog);

			res.put("status", 200);
			res.put("message", "领取成功");

			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败：原因： " + e.getMessage());
			return res;

		}

	}

	// 租用设备
	@RequestMapping(value = "/RentDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> RentDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId, @RequestParam(defaultValue = "1") int count) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {

			// 第一步 拉取设备信息
			EDevice device = deviceService.get(deviceId);
			EWallet wallet = walletService.getWalletByUser(userId);
			EUser user = userService.get(userId);

			if (device.getState() == EDevice.DEVICE_BAD || device.getState() == EDevice.DEVICE_REPAIR) {
				res.put("status", 210);
				res.put("message", "设备故障");
				return res;
			}

			if (null != user.getRole() && user.getRole() == EUser.CHARGEMAN) {

				res.put("isChargeMan", "yes");
				res.put("status", 200);
				res.put("message", "查找成功");
				return res;
			}

			res.put("device", device);

			// 第二步 判断重复领取
			if (null != device.getUserId() && userId.equals(device.getUserId())) {
				System.out.println();
				res.put("message", "您已绑定该设备，无须重复");
				res.put("status", 210);
				return res;
			}

			// 第二步判断押金
			if (null != wallet.getRole() && user.getRole() == EWallet.NORMAL) {
				System.out.println("开始判断押金");

				List<EDevice> deviceList = new ArrayList<EDevice>();
				deviceList.add(device);
				
				for (EDevice eDevice : deviceList) {
					System.out.println(eDevice.getName()+ " "+ eDevice.getDeviceNo());
				}

				EDeviceExample example = new EDeviceExample();
				EDeviceExample.Criteria criteria = example.createCriteria();
				criteria.andUserIdEqualTo(userId);

				deviceList.addAll((List<EDevice>) deviceService.list(example, 0, 0).get("data"));
				double totalShareMoney = 0;

				for (EDevice eDevice : deviceList) {
					totalShareMoney += eDevice.getShareMoney().doubleValue();
					System.out.println(eDevice.getName()+ " "+ eDevice.getDeviceNo());
				}
				
				System.out.println("totalShareMoney:" + totalShareMoney);

				System.out.println("myshareMoney: " + wallet.getShareAmount().doubleValue());

				if (wallet.getShareAmount().doubleValue() < totalShareMoney) {
					res.put("money", TextUtils.formatDouble((totalShareMoney - wallet.getShareAmount().doubleValue())));
					res.put("reminShare", wallet.getShareAmount().doubleValue()
							- (totalShareMoney - device.getShareMoney().doubleValue()));
					res.put("status", 213);
					res.put("message", "共享金额不足，请充值共享金");
					return res;
				}

			}

			// 第三步 判断余额
			if (null != wallet.getRole() && wallet.getRole() != EUser.CHARGEMAN) {

				int minCoast = 0;
				if (device.getRentalType() == EDevice.RENTAL_BY_HOUR)
					minCoast = device.getRentalH();
				if (device.getRentalType() == EDevice.RENTAL_BY_DAY)
					minCoast = device.getRental();
				if (device.getRentalType() == EDevice.RENTAL_BY_MONTH)
					minCoast = device.getRentalM();

				if (user.getRole() != EUser.CHARGEMAN && wallet.getAmount() < minCoast) {
					res.put("status", 211);

					res.put("pages", "rental");
					res.put("message", "您的余额少于设备的，最小租金。请在我的——>我的钱包,充值后使用");
					return res;
				}
			}

			// 第三步 判断有否有上一用户
			if (device.getUserId() == null || device.getUserId().equals("")) {
				deviceService.RentalDevice(device, userId, count);
				res.put("status", 200);
				res.put("message", "领取成功");
				return res;
			}

			// 第三步 更新老用户设备日志 这里生成的日志没有钱包编号，要到支付阶段才会生成
			deviceService.endUse(device);

			// 第四步 成功返回
			deviceService.RentalDevice(device, userId, count);

			// 函数结束成功返回
			res.put("status", 200);
			res.put("message", "绑定成功");
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;
		}
	}

	/**
	 * 到目前为止，不管是集团用户还是个人用户想换电都是自己掏腰包
	 */
	@RequestMapping(value = "/changeDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> changeDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);
        EUser user=userService.get(userId);
		
		
		// 第二步 判断重复领取
		if (null != device.getUserId() && userId.equals(device.getUserId())) {
			System.out.println();
			res.put("message", "您已绑定该设备，无须重复");
			res.put("status", 210);
			return res;
		}

		if (device.getState() == EDevice.DEVICE_BAD || device.getState() == EDevice.DEVICE_REPAIR) {

			res.put("status", 210);
			res.put("message", "设备故障");
			return res;

		}

		EWallet wallet = walletService.getWalletByUser(userId);

		// 第一步 判断余额
		if (wallet.getAmount() < device.getChangeDdb()) {
			res.put("message", "余额不足一次换电费用");
			res.put("device", device);
			res.put("pages", "change");
			res.put("status", 211);
			return res;
		} else {
			wallet.setAmount(wallet.getAmount() - device.getChangeDdb());
			walletService.edit(wallet);
		}

		
		// 第二步 找到对应的订单
		EOrders order = new EOrders();
		order.setDeviceName(device.getName());
		order.setUserId(userId);
		List<EOrders> orderList = orderService.getChangeList(order);

		if (orderList == null || orderList.size() == 0) {
			res.put("message", "您没有换电订单");
			res.put("status", 210);
			return res;
		}

		EOrders orders = orderList.get(0);
		orders.setDeviceId(deviceId);
		orderService.edit(orders);

		// 绑定新设备
		device.setUserId(userId);
		device.setUpdateTime(new Date());
		deviceService.edit(device);

		// 开启新日志
		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setId(TextUtils.getIdByUUID());
		scaneLog.setStartDate(new Date());

		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.CHANGE_DEVICE);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);
				
		// 第五步 计算分红
		int ownerGet = BigDecimal.valueOf(device.getChangeDdb() * device.getkW()).setScale(0, BigDecimal.ROUND_HALF_UP)
				.intValue();

		System.out.println("ownerGet: " + ownerGet);

		int managerGet = BigDecimal.valueOf(device.getChangeDdb() * device.getkM())
				.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		System.out.println("managerGet: " + managerGet);

		int ddGet = BigDecimal.valueOf(device.getChangeDdb() * device.getkD()).setScale(0, BigDecimal.ROUND_HALF_UP)
				.intValue();
		System.out.println("ddGet: " + ddGet);

		String owner = device.getOwner();

		EWallet walletOwner = walletService.get(owner);
		walletOwner.setAmount(walletOwner.getAmount() + ownerGet);

		ddbService.insert(owner, ownerGet, EDdb.OWNER);
		walletService.edit(walletOwner);

		String manager = device.getManager();

		EWallet walletManager = walletService.get(manager);
		walletManager.setAmount(walletManager.getAmount() + managerGet);

		ddbService.insert(manager, managerGet, EDdb.MANAGER);
		walletService.edit(walletManager);

		String dd = "ca2a1737154a4821a713a2cb431afd11";
		EWallet walletDD = walletService.get(dd);
		
		walletDD.setAmount(walletDD.getAmount() + ddGet);
		ddbService.insert(dd, ddGet, EDdb.DD);
		walletService.edit(walletDD);
		
		
		
		EChat chat = new EChat();
		chat.setChatDate(new Date());

		chat.setContent(user.getName()+"/"+user.getNickName()+"换电成功了");
		chat.setFromUser("7d248e45aafb4628aac7c39f56be6b6c");
		chat.setToUser(device.getManager());
		
		chat.setId(TextUtils.getIdByUUID());
		chat.setIsDelete(0);
		chat.setIsRead(0);		    

		chatService.insert(chat);
		

		res.put("message", "换电成功了");
		res.put("status", 200);

		return res;
	}

	// 获取设备详情
	@RequestMapping(value = "/getDeviceDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDeviceDetail(@RequestParam(required = true) String deviceId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {

			EDevice device = deviceService.get(deviceId);

			List<Map<String, Object>> pastUserList = deviceService.getPastUserList(deviceId);

			if (device == null) {
				res.put("status", 210);
				res.put("message", "设备不存在");
			} else {

				res.put("device", device);
				res.put("pastUserList", pastUserList);
				res.put("status", 200);
				res.put("message", "查找成功");

			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	/***
	 * 1.扫码后拉取用户类型 2.拉取设备操作 3.返回设备描述 4.返回钱包
	 * 
	 **/
	@RequestMapping(value = "/scaneCode", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> scaneCode(@RequestParam(required = true) String deviceNo,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {

			// 第一步检查参数
			EUser user = userService.get(userId);
			if (null == user) {
				res.put("status", 210);
				res.put("message", "查找失败，用户错误");
				return res;
			}

			EDevice device = deviceService.getByDeviceNo(deviceNo);

			if (device == null) {
				res.put("message", "设备编号错误");
				res.put("status", 210);
				return res;
			}
			res.put("device", device);

			// 第三步 充电侠识别
			if (null != user.getRole() && user.getRole() == EUser.CHARGEMAN) {

				res.put("isChargeMan", "yes");
				res.put("status", 200);
				res.put("message", "查找成功");
				return res;
			}

			if (device.getState() == EDevice.DEVICE_BAD) {
				res.put("message", "设备故障");
				res.put("status", 210);
				return res;
			}

			EWallet wallet = walletService.getWalletByUser(userId);
			res.put("wallet", wallet);

			res.put("isChargeMan", "no");

			res.put("status", 200);
			res.put("message", "查找成功");

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	@RequestMapping(value = "/chargeDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> chargeDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {

		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);
		EUser user = userService.get(userId);

		if (device == null) {
			res.put("message", "设备编号错误");
			res.put("status", 210);
			return res;
		}

		if (device.getState() == device.ELECTRIC_ENOUGH) {
			res.put("message", "设备有电");
			res.put("status", 210);
			return res;
		}

		if (user.getRole() != EUser.CHARGEMAN) {
			res.put("message", "您不是充电侠，不能给设备充电");
			res.put("status", 210);
			return res;
		}

		System.out.println("设备类型为：" + device.getType());

		if (device.getType() != 4 && device.getType() != 5 && device.getType() != 6) {
			res.put("message", "设备无须充电");
			res.put("status", 210);
			return res;
		}

		// 变更电池状态
		device.setState(EDevice.ELECTRIC_ENOUGH);
		deviceService.edit(device);

		// 记录日志
		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setId(TextUtils.getIdByUUID());
		scaneLog.setStartDate(new Date());
		scaneLog.setEndDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.CHARGE_DEVICE);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);

		res.put("message", "开始充电了");
		res.put("status", 200);
		return res;

	}

	/**
	 * 设备报修
	 */
	@RequestMapping(value = "/repairDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> repairDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);
		EUser user = userService.get(userId);

		try {
			device.setState(EDevice.DEVICE_REPAIR);
			EScaneLog scaneLog = new EScaneLog();
			scaneLog.setId(TextUtils.getIdByUUID());
			scaneLog.setStartDate(new Date());
			scaneLog.setEndDate(new Date());
			scaneLog.setUserId(userId);
			scaneLog.setDeviceId(device.getId());
			scaneLog.setOpration(EScaneLog.REPAIR_DEVICE);
			scaneLog.setManager(device.getManager());
			scaneLogService.insert(scaneLog);

			res.put("message", "报修成功了，已通知管理员");
			res.put("status", 200);
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	/**
	 * 设备报修
	 */
	@RequestMapping(value = "/startService", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> startService(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		// 第一步 参数校验
		EDevice device = deviceService.get(deviceId);

		if (device == null) {
			res.put("message", "设备编号错误");
			res.put("status", 210);
			return res;
		}

		if (device.getState() == EDevice.DEVICE_BAD) {
			res.put("message", "设备故障");
			res.put("status", 210);
			return res;
		}

		EUser user = userService.get(userId);
		if (null == user) {
			res.put("status", 210);
			res.put("message", "查找失败，用户错误");
			return res;
		}

		EWallet wallet = walletService.getWalletByUser(userId);

		// 第二步 判断余额
		if (wallet.getAmount() < device.getChangeDdb()) {
			res.put("message", "余额不足");
			res.put("device", device);
			res.put("status", 211);
			return res;
		} else {
			wallet.setAmount(wallet.getAmount() - device.getChangeDdb());
			walletService.edit(wallet);
		}

		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setStartDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.START_SERVICE);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);

		res.put("status", 200);
		res.put("message", "搭电付费成功了");

		return res;
	}

	/**
	 * 库管将电池报废
	 */
	@RequestMapping(value = "/destroyDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> destroyDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {

		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);

		EUser user = userService.get(userId);

		if (user.getRole() != EUser.CHARGEMAN) {
			res.put("message", "权限不足");
			res.put("status", 210);
			return res;
		}

		if (device == null) {
			res.put("message", "设备编号错误");
			res.put("status", 210);
			return res;
		}

		device.setState(EDevice.DEVICE_BAD);
		deviceService.edit(device);

		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setId(TextUtils.getIdByUUID());
		scaneLog.setStartDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.DESTROY_DEVICE);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);

		// 作废订单
		device.setUserId(null);
		device.setManager(null);
		device.setOwner(null);
		deviceService.edit(device);

		res.put("status", 200);
		res.put("message", "报废成功了");

		return res;
	}

	private String getTimeInfo(Date date) {

		DateFormat df = new SimpleDateFormat("MM月dd日");
		long d = 24 * 60; // 天
		long h = 60; // 小时

		long diff = (date.getTime() - new Date().getTime()) / 1000 / 60; // 得到时间差 单位分钟

		System.out.println(diff);

		String prx = "";
		if (diff < 0) {
			prx = "超期";
		} else {
			prx = "剩余";
		}

		if (diff < h)
			return prx + diff + "分钟";
		if (diff < d)
			return prx + diff / h + "小时";

		return prx + diff / d + "天";

	}

}
