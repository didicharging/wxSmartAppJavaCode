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

				if (orderList == null || orderList.size() == 0) {
					po.setUpdateTime(eDevice.getUpdateTime());
					po.setTimeInfo("");
				} else {
					po.setUpdateTime(orderList.get(0).getStartDate());
					po.setTimeInfo(getTimeInfo(orderList.get(0).getEndDate()));
				}

				list.add(po);

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

	/**
	 * 功能：扫码后功能判断 1.充电侠直接扫码取回 2.有换电资格直接换电 3.普通用户 只能租就直接租 否则接功能列表 返回值： 200领取成功了
	 * 201拉取功能列表 210错误 211余额不足 213押金不足
	 */
	// @RequestMapping(value = "/getDeviceState", method = RequestMethod.GET)
	// public Map<String, Object> getDeviceState(@RequestParam(required = true)
	// String deviceNo,
	// @RequestParam(required = true) String userId) {
	//
	// Map<String, Object> res = new HashMap<String, Object>();
	//
	// // 第一步检查参数
	// EDevice device = deviceService.getByDeviceNo(deviceNo);
	// if (device == null) {
	// res.put("message", "设备编号错误");
	// res.put("status", 210);
	// return res;
	// }
	//
	// EUser user = userService.get(userId);
	// if (null == user) {
	// res.put("status", 210);
	// res.put("message", "查找失败，用户错误");
	// return res;
	// }
	//
	// EWallet wallet = walletService.getWalletByUser(userId);
	//
	// if (wallet == null) {
	// wallet = new EWallet();
	// wallet.setAmount(500);
	// wallet.setId(TextUtils.getIdByUUID());
	// wallet.setShareAmount(new BigDecimal(0));
	// wallet.setUserId(userId);
	// wallet.setRole(EWallet.NORMAL);
	// walletService.insert(wallet);
	// }
	//
	// System.out.println("参数正常");
	//
	// // 第二步 判断有无欠费
	// EWalletLogExample walletLogExample = new EWalletLogExample();
	// EWalletLogExample.Criteria walletLogcriteria =
	// walletLogExample.createCriteria();
	// walletLogcriteria.andUserIdEqualTo(userId);
	// walletLogcriteria.andLogTypeEqualTo(EWalletLog.BILL_DEBT);
	// walletLogcriteria.andTransactionIdIsNull();
	//
	// Map<String, Object> map = walletLogService.list(walletLogExample, 0, 0);
	//
	// if ((int) map.get("total") != 0) {
	// List<EWalletLog> list = (List<EWalletLog>) map.get("data");
	//
	// double total = 0;
	// for (EWalletLog eWalletLog : list) {
	//
	// total += eWalletLog.getMoney().doubleValue();
	//
	// }
	// res.put("message", "由于您上次未及时归还设备，欠费" + total + "元，请支付后重试");
	// res.put("money", total);
	// res.put("status", 212);
	// return res;
	//
	// }
	//
	// // 第二步 判断重复领取
	// if (null != device.getUserId() && userId.equals(device.getUserId())) {
	// System.out.println();
	// res.put("message", "您已绑定该设备，无须重复");
	// res.put("status", 210);
	// return res;
	// }
	// System.out.println("没有重复领取");
	//
	// // 第二步检查用用户身份
	// if (null != wallet.getRole() && wallet.getRole() == EUser.CHARGEMAN) {
	//
	// System.out.println("我是充电侠");
	//
	// // 这里直接调回收函数
	// RentDevice(device.getId(), userId);
	// res.put("device", device);
	// res.put("status", 200);
	// res.put("message", "取回成功");
	// return res;
	// }
	//
	// System.out.println("我是普通用户");
	//
	// // 第三步判断押金
	// if (null != wallet.getRole() && wallet.getRole() == EWallet.NORMAL) {
	//
	// List<EDevice> deviceList = new ArrayList<EDevice>();
	// deviceList.add(device);
	//
	// EDeviceExample example = new EDeviceExample();
	// EDeviceExample.Criteria criteria = example.createCriteria();
	// criteria.andUserIdEqualTo(userId);
	//
	// deviceList.addAll((List<EDevice>) deviceService.list(example, 0,
	// 0).get("data"));
	// double totalShareMoney = 0;
	//
	// for (EDevice eDevice : deviceList) {
	// totalShareMoney += eDevice.getShareMoney().doubleValue();
	// }
	//
	// if (wallet.getShareAmount().compareTo(new BigDecimal(totalShareMoney)) ==
	// -1) {
	// res.put("money", TextUtils.formatDouble((totalShareMoney -
	// wallet.getShareAmount().doubleValue())));
	// res.put("status", 213);
	// res.put("device", device);
	// res.put("message", "共享金额不足，请充值共享金");
	// return res;
	// }
	//
	// }
	//
	// // 第三步检查有无可换电的订单
	//
	// EOrders order = new EOrders();
	// order.setDeviceName(device.getName());
	// order.setUserId(userId);
	// List<EOrders> orderList = orderService.getChangeList(order);
	//
	// if (null != orderList && orderList.size() > 0) {
	// System.out.println("我有换电资格");
	// return changeDevice(device.getId(), userId);
	// }
	//
	// System.out.println("我没有的换电资格");
	//
	// // 检查设备类型
	// String sourceStr = device.getFunction();
	// String[] functionList = sourceStr.split(",");
	//
	// for (String string : functionList) {
	// System.out.println("功能列表： " + string);
	// }
	//
	// System.out.println("列表长度: " + functionList.length);
	//
	// if (functionList.length == 1 &&
	// functionList[0].equals(EScaneLog.RECIVE_DEVICE.toString())) {
	// // 调用领取逻辑
	// System.out.println("这个设备只能租所以省事了");
	// res.put("message", "领取成功了");
	// return RentDevice(device.getId(), userId);
	// }
	//
	// System.out.println("拉取功能列表");
	// res.put("function", functionList);
	// res.put("device", device);
	// res.put("status", 201);
	// res.put("message", "拉取功能列表");
	// return res;
	// }

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

			if (device == null) {
				res.put("message", "设备编号错误");
				res.put("status", 210);
				return res;
			}

			EUser user = userService.get(userId);
			if (null == user) {
				res.put("status", 210);
				res.put("message", "查找失败，用户错误");
				return res;
			}

			if (null != user.getRole() && user.getRole() != EUser.CHARGEMAN && user.getRole() != EUser.MANAGER) {
				res.put("status", 210);
				res.put("message", "权限不足");
				return res;
			}

			if (device.getState() == EDevice.DEVICE_NULL && user.getRole() == EUser.CHARGEMAN) {
				res.put("status", 210);
				res.put("message", "设备未入库");
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

			if (flag)
				device.setState(EDevice.ELECTRIC_LESS);

			if (device.getState() == EDevice.DEVICE_NULL && user.getRole() == EUser.MANAGER) {
				device.setState(EDevice.ELECTRIC_LESS);

			}
			// 第二步 领回设备

			device.setUserId(userId);
			device.setManager(userId);

			if (device.getOwner() == null && user.getRole() == EUser.MANAGER) {
				device.setOwner(userId);

			}

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
			@RequestParam(required = true) String userId) {
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

			if (device.getState() == EDevice.DEVICE_NULL) {
				res.put("status", 210);
				res.put("message", "设备未入库");
				return res;
			}

			// if(device.getState()==EDevice.ELECTRIC_LESS){
			// res.put("status", 210);
			// res.put("message", "设备电量不足");
			// return res;
			// }
			// if(device.getState()==EDevice.IN_CHARGEING){
			// res.put("status", 210);
			// res.put("message", "设备充电中");
			// return res;
			// }

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
					res.put("device", device);
					res.put("pages", "rental");
					res.put("message", "您的余额少于设备的，最小租金。请在我的——>我的钱包,充值后使用");
					return res;
				}
			}

			// 第三步 判断有否有上一用户
			if (device.getUserId() == null || device.getUserId().equals("")) {
				deviceService.RentalDevice(device, userId);
				res.put("status", 200);
				res.put("device", device);
				res.put("message", "领取成功");
				return res;
			}

			// 第三步 更新老用户设备日志 这里生成的日志没有钱包编号，要到支付阶段才会生成
			deviceService.endUse(device);

			// 第四步 成功返回
			deviceService.RentalDevice(device, userId);

			// 函数结束成功返回
			res.put("status", 200);
			res.put("device", device);
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

		if (device.getState() == EDevice.DEVICE_BAD || device.getState() == EDevice.DEVICE_REPAIR) {
			res.put("status", 210);
			res.put("message", "设备故障");
			return res;
		}

		if (device.getState() == EDevice.DEVICE_NULL) {
			res.put("status", 210);
			res.put("message", "设备未入库");
			return res;
		}

		if (device.getState() == EDevice.IN_CHARGEING) {
			res.put("status", 210);
			res.put("message", "设备充电中");
			return res;
		}

		if (device.getState() == EDevice.ELECTRIC_LESS) {
			res.put("status", 210);
			res.put("message", "设备电量不足");
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

	@RequestMapping(value = "/scaneCode", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> scaneCode(@RequestParam(required = true) String deviceNo,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {

			// 第一步检查参数

			EDevice device = deviceService.getByDeviceNo(deviceNo);
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

			if (wallet == null) {
				wallet = new EWallet();
				wallet.setAmount(500);
				wallet.setId(TextUtils.getIdByUUID());
				wallet.setShareAmount(new BigDecimal(0));
				wallet.setUserId(userId);
				wallet.setRole(EWallet.NORMAL);
				walletService.insert(wallet);
			}

			res.put("device", device);
			res.put("wallet", wallet);

			System.out.println("参数正常");

			// 第二步 判断重复绑定
			if (null != device.getUserId() && userId.equals(device.getUserId())
					&& device.getState() != EDevice.DEVICE_NULL) {

				// 库管二次扫码
				if (user.getRole() == EUser.MANAGER) {
					res.put("message", "是否报废设备？");
					res.put("status", 209);
					return res;
				}

				// 充电侠二次扫码

				// if(user.getRole()==EUser.CHARGEMAN){
				//
				// if(device.getState()==EDevice.ELECTRIC_LESS){
				// res.put("message", "给设备充电？");
				// res.put("status", 220);
				// return res;
				// }
				//
				// if(device.getState()==EDevice.IN_CHARGEING){
				// res.put("message", "充电完成了？");
				// res.put("status", 221);
				// return res;
				// }
				//
				// }

				res.put("message", "您已领取设备");
				res.put("status", 206);
				return res;

			}

			// 第三步 充电侠识别
			if (null != user.getRole() && user.getRole() == EUser.CHARGEMAN) {

				res.put("status", 203);
				res.put("message", "取回设备");
				return res;
			}

			// 第四步 库管识别
			if (null != user.getRole() && user.getRole() == EUser.MANAGER) {

				res.put("status", 203);
				res.put("message", "设备入库");
				return res;
			}

			// 第五步 集团主管识别
			if (null != user.getRole() && user.getRole() == EUser.CORPORATE_MANAGER) {
				res.put("status", 204);
				res.put("message", "员工管理");
				return res;
			}

			// 第六步 检查用户类型
			if (null != user.getRole() && user.getRole() == EUser.CORPORATE) {
				res.put("status", 202);
				res.put("message", "换电: " + device.getChangeDdb() + "嘀嘀币");
				return res;
			}

			// 第七步 普通用户首先判断押金、再判断欠款、再判断换电资格

			// 判断押金
			if (null == user.getRole() || user.getRole() == EWallet.NORMAL) {

				List<EDevice> deviceList = new ArrayList<EDevice>();

				EDeviceExample example = new EDeviceExample();
				EDeviceExample.Criteria criteria = example.createCriteria();
				criteria.andUserIdEqualTo(userId);

				deviceList.addAll((List<EDevice>) deviceService.list(example, 0, 0).get("data"));

				// 原有不可动押金
				double totalShareMoney = 0;

				for (EDevice eDevice : deviceList) {
					totalShareMoney += eDevice.getShareMoney().doubleValue();
				}

				// 可动押金
				double reminShare = wallet.getShareAmount().doubleValue() - totalShareMoney;

				double money = device.getShareMoney().doubleValue() - reminShare;

				totalShareMoney = 0;
				deviceList.add(device);
				for (EDevice eDevice : deviceList) {
					totalShareMoney += eDevice.getShareMoney().doubleValue();
				}

				if (money > 0) {
					res.put("money", TextUtils.formatDouble((totalShareMoney - wallet.getShareAmount().doubleValue())));
					res.put("reminShare", reminShare);
					res.put("status", 213);
					res.put("device", device);
					res.put("message", "共享金额不足，请充值共享金");
					return res;

				}

			}

			// 判断的换电资格
			EOrders order = new EOrders();
			order.setDeviceName(device.getName());
			order.setUserId(userId);
			List<EOrders> orderList = orderService.getChangeList(order);

			deviceService.checkChange(user, device.getName());

			if (null != orderList && orderList.size() > 0) {
				System.out.println("有换电资格");
				res.put("message", "换电: " + device.getChangeDdb() + "嘀嘀币");
				res.put("status", 202);
				return res;

			} else {

				System.out.println("木有换电资格");

				int rental = 0;
				String rentalType = "";
				if (device.getRentalType() == EDevice.RENTAL_BY_HOUR) {
					rental = device.getRentalH();
					rentalType = "小时";
				}
				if (device.getRentalType() == EDevice.RENTAL_BY_DAY) {
					rental = device.getRental();
					rentalType = "天";
				}
				if (device.getRentalType() == EDevice.RENTAL_BY_MONTH) {
					rental = device.getRentalM();
					rentalType = "月";
				}

				res.put("message", "租电: " + rental + "嘀嘀币/" + rentalType);
				res.put("status", 201);
				return res;
			}

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
			@RequestParam(required = true) String adaptCode, @RequestParam(required = true) String userId) {
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

		if (user.getRole() != EUser.CHARGEMAN || user.getRole() == EUser.MANAGER) {
			res.put("message", "权限不足");
			res.put("status", 210);
			return res;
		}

		System.out.println("设备类型为：" + device.getType());

		if (device.getType() != 4 && device.getType() != 5 && device.getType() != 6) {
			res.put("message", "设备无须充电");
			res.put("status", 210);
			return res;
		}

		EDevice adapt = deviceService.getByDeviceNo(adaptCode);
		if (adapt == null) {
			res.put("message", "充电器无效");
			res.put("status", 210);
			return res;
		}

		if (adapt.getType() != (device.getType() + 3)) {
			res.put("message", "充电器不区配");
			res.put("status", 210);
			return res;
		}

		if (adapt.getState() == EDevice.IN_BUSY) {
			res.put("message", "充电器不能同时充两个设备");
			res.put("status", 210);
			return res;
		}

		adapt.setState(EDevice.IN_BUSY);
		deviceService.edit(adapt);

		// 变更电池状态
		device.setState(EDevice.IN_CHARGEING);
		deviceService.edit(device);

		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setId(TextUtils.getIdByUUID());
		scaneLog.setStartDate(new Date());
		scaneLog.setEndDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setCompanion(adapt.getId());
		scaneLog.setOpration(EScaneLog.CHARGE_DEVICE);

		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);

		// ddbService.insert(userId, device.getChargeDdb(), EDdb.CHAREGE);

		res.put("message", "开始充电了");
		res.put("status", 200);
		return res;

	}

	@RequestMapping(value = "/chargeFinish", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> chargeFinish(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);
		EUser user = userService.get(userId);

		if (device == null) {
			res.put("message", "设备编号错误");
			res.put("status", 210);
			return res;
		}

		if (device.getState() != device.IN_CHARGEING) {
			res.put("message", "状态异常");
			res.put("status", 210);
			return res;
		}

		if (user.getRole() != EUser.CHARGEMAN || user.getRole() == EUser.MANAGER) {
			res.put("message", "权限不足");
			res.put("status", 210);
			return res;
		}

		EScaneLogExample scaneLogExample = new EScaneLogExample();
		EScaneLogExample.Criteria scaneLogCriteria = scaneLogExample.createCriteria();
		// scaneLogCriteria.andUserIdEqualTo(userId);
		scaneLogCriteria.andDeviceIdEqualTo(deviceId);
		scaneLogCriteria.andOprationEqualTo(EScaneLog.CHARGE_DEVICE);
		scaneLogExample.setOrderByClause("start_date desc");

		List<EScaneLog> list = (List<EScaneLog>) scaneLogService.list(scaneLogExample, 0, 0).get("data");

		if (list != null && list.size() != 0) {

			EScaneLog scaneLog = list.get(0);
			EDevice adapt = deviceService.get(scaneLog.getCompanion());
			adapt.setState(EDevice.IN_READY);
			deviceService.edit(adapt);
		}

		// 变更电池状态
		device.setState(EDevice.ELECTRIC_ENOUGH);
		deviceService.edit(device);

		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setId(TextUtils.getIdByUUID());
		scaneLog.setStartDate(new Date());
		scaneLog.setEndDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.CHARGING_FINISH);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);

		ddbService.insert(userId, device.getChargeDdb(), EDdb.CHAREGE);

		res.put("message", "充电成功了");
		res.put("status", 200);
		return res;

	}

	/**
	 * 充电侠将电池报修，交由库管确认状态。
	 * 
	 */
	@RequestMapping(value = "/repairDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> repairDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);
		EUser user = userService.get(userId);

		if (user.getRole() != EUser.CHARGEMAN || device.getState() == EDevice.DEVICE_BAD) {
			res.put("message", "权限不足");
			res.put("status", 210);
			return res;
		}

		device.setState(EDevice.DEVICE_REPAIR);
		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setStartDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.REPAIR_DEVICE);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);
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

		if (user.getRole() != EUser.MANAGER) {
			res.put("message", "权限不足");
			res.put("status", 210);
			return res;
		}

		device.setState(EDevice.DEVICE_NULL);

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
		EOrdersExample orderExample = new EOrdersExample();
		EOrdersExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andUserIdEqualTo(userId);
		orderCriteria.andDeviceIdEqualTo(device.getId());
		orderExample.setOrderByClause("end_date desc");

		List<EOrders> orderList = (List<EOrders>) orderService.list(orderExample, 0, 0).get("data");

		for (EOrders eOrders : orderList) {

			orderService.delete(eOrders.getId());
		}

		device.setUserId(null);
		device.setManager(null);
		device.setOwner(null);
		deviceService.edit(device);

		return res;
	}

	/**
	 * 库管确认电池没有问题
	 */
	@RequestMapping(value = "/normalDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> normalDevice(@RequestParam(required = true) String deviceId,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		EDevice device = deviceService.get(deviceId);
		EUser user = userService.get(userId);

		if (user.getRole() != EUser.CHARGEMAN) {
			res.put("message", "权限不足");
			res.put("status", 210);
			return res;
		}

		device.setState(EDevice.ELECTRIC_LESS);
		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setStartDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.NORMAL_DEVICE);
		scaneLog.setManager(device.getManager());
		scaneLogService.insert(scaneLog);
		return res;
	}

	private String getTimeInfo(Date date) {

		DateFormat df = new SimpleDateFormat("MM月dd日");
		long d = 24 * 60; // 天
		long h = 60; // 小时

		long diff = (date.getTime() - new Date().getTime()) / 1000 / 60; // 得到时间差
																			// 单位分钟
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
