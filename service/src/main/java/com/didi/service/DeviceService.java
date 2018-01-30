package com.didi.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EDeviceMapper;
import com.didi.mapper.EOrdersMapper;
import com.didi.mapper.EScaneLogMapper;
import com.didi.mapper.EUserMapper;
import com.didi.mapper.EWalletLogMapper;
import com.didi.mapper.EWalletMapper;
import com.didi.model.EDdb;
import com.didi.model.EDevice;
import com.didi.model.EDeviceExample;
import com.didi.model.EOrders;
import com.didi.model.EOrdersExample;
import com.didi.model.EScaneLog;
import com.didi.model.EScaneLogExample;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.unti.TextUtils;

@Service
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class DeviceService {

	@Resource
	EDeviceMapper mapper;

	@Resource
	EScaneLogMapper scaneMapper;

	@Resource
	EOrdersMapper ordersMapper;

	@Resource
	EWalletMapper walletMapper;

	@Resource
	DdbService ddbService;

	@Resource
	EUserMapper userMapper;

	@Resource
	EWalletLogMapper walletLogMapper;

	public int edit(Object object) {
		EDevice device = (EDevice) object;
		return mapper.updateByPrimaryKey(device);
	}

		
	// 批量插入代码
//	@Test
//	public void insertBitch() {
//		long min = 1001;
//		long max = 1200;
//		for (long i = min; i <= max; i++) {
////DiDi7010031001
//			String deviceNo = "DiDi701003" + i;
//			EDevice device = new EDevice();
//			device.setId(TextUtils.getIdByUUID());
//			device.setDeviceNo(deviceNo);
//			device.setSupplier("嘀嘀充电");
//			device.setManager("ca2a1737154a4821a713a2cb431afd11");
//			device.setOwner("ca2a1737154a4821a713a2cb431afd11");
//			device.setName("64V锂电池");
//			device.setType(5);
//			device.setShareMoney(new BigDecimal("1000"));
//			device.setSaveMoney(new BigDecimal(0));
//			device.setCreateTime(new Date());
//			device.setUpdateTime(new Date());
//			device.setRental(700);
//			device.setPrice(new BigDecimal("1000"));
//			device.setRentalType(EDevice.RENTAL_BY_DAY);
//			device.setChargeDdb(200);
//			device.setIsbuy(EDevice.SALE);
//			device.setkD((float) 0.2);
//			device.setkM((float) 0.4);
//			device.setkW((float) 0.4);
//			device.setState(EDevice.IN_READY);
//
//			int count = mapper.insert(device);
//			if (count != 1) {
//				System.out.println(device);
//				break;
//			} else {
//				System.out.println(device.getDeviceNo());
//			}
//		}
//	}
	
	

	public int delete(String id) {
		return 0;
	}

	public Map<String, Object> list(EDeviceExample example, int page, int perPage) {

		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("device_no desc");

		List<EDevice> list = mapper.selectByExample(example);

		result.put("data", list);
		result.put("total", mapper.countByExample(example));

		return result;
	}
 
	public Map<String, Object> MydeviceList(String userId, int page, int perPage) {

		EDeviceExample example = new EDeviceExample();
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		EDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		example.setOrderByClause("id");
		List<EDevice> list = mapper.selectByExample(example);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

	public EDevice get(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<Map<String, Object>> getPastUserList(String deviceId) {
		return mapper.getPastUserList(deviceId);
	}

	public EDevice getByDeviceNo(String deviceNo) {
		// TODO Auto-generated method stub

		return mapper.getByDeviceNo(deviceNo);
	}

	/**
	 *  结束使用流程 
	 *  第一 找到老日志结束日志
	 *  第二 充电侠或者库管直接返回
	 *  第三 一般用户找到对应的订单变更订单状态
	 *  
	 */

	public int endUse(EDevice device) throws Exception {
		// TODO Auto-generated method stub

		// 第一步 找到对应日志 
		EScaneLogExample example = new EScaneLogExample();
		EScaneLogExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceIdEqualTo(device.getId());
		criteria.andUserIdEqualTo(device.getUserId());
		criteria.andEndDateIsNull();
		example.setOrderByClause("start_date desc");
		List<EScaneLog> scanelist = scaneMapper.selectByExample(example);
		EScaneLog scaneLog = scanelist.get(0);
		
		scaneLog.setEndDate(new Date());
		scaneMapper.updateByPrimaryKey(scaneLog); 
		
				
		// 第二步，计算费用
		EUser user=userMapper.selectByPrimaryKey(device.getUserId());
		
		// 如果是管理员、拥有者、或者库管 则直接返回
		if (user.getRole() == EUser.CHARGEMAN || user.getRole() == EUser.MANAGER  || device.getUserId().equals(device.getOwner())) {
			
			return 1;
		}
			
		
		EOrdersExample ordersExample = new EOrdersExample();
		EOrdersExample.Criteria orderCriteria = ordersExample.createCriteria();
		orderCriteria.andUserIdEqualTo(device.getUserId());
		orderCriteria.andDeviceNameEqualTo(device.getName());
		orderCriteria.andStartDateLessThanOrEqualTo(scaneLog.getStartDate());
		ordersExample.setOrderByClause("create_time desc");

		List<EOrders> orderList = ordersMapper.selectByExample(ordersExample);
		EOrders orders = orderList.get(0);

	    orders.setLastBackTime(new Date());
         
		// 未超期直接返回
		if (orders.getEndDate().getTime()< new Date().getTime()) {
			orders.setState(EOrders.PASS);            				
		}else{
			orders.setDeviceId(null);		
		}
		
		device.setUserId(null);
		mapper.updateByPrimaryKey(device);
		ordersMapper.updateByPrimaryKey(orders);		
			
		return 1;
		
	}

	public int RentalDevice(EDevice device, String userId) throws Exception {

		
		EUser user =userMapper.selectByPrimaryKey(userId);
		
		//判断集团用户
		if(user.getRole()==EUser.CORPORATE){

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("walletId", user.getWalletId());
			param.put("deviceName", device.getName());
		  	List<EOrders> list=ordersMapper.getCorporateCanChangeOrdre(param);
		  	if(list!=null && list.size()>0){
		  		EOrders order=list.get(0);
		  		order.setUserId(userId);
		  		ordersMapper.updateByPrimaryKey(order);
		  		return 1;
		  	}
		}
		
				
		// 第一步 绑定新用户
		device.setUserId(userId);
		device.setUpdateTime(new Date());		 
		EWallet wallet = walletMapper.selectByUserId(userId);

		int err = mapper.updateByPrimaryKey(device);
		
		if (err != 1) {
			throw (new Exception("设备绑定失败"));
		}
 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date endTime = calendar.getTime();
        
		// 第二步 扣除基本最少使用费创建订单
		int rental = 0;
		int baseTime = 0;
		
		if (device.getRentalType() == EDevice.RENTAL_BY_HOUR) {
			rental = device.getRentalH();
			calendar.add(Calendar.HOUR, 1);
			endTime = calendar.getTime();
		}

		if (device.getRentalType() == EDevice.RENTAL_BY_DAY) {
			rental = device.getRental();
			calendar.add(Calendar.DATE, 1);
			endTime = calendar.getTime();
		}

		if (device.getRentalType() == EDevice.RENTAL_BY_MONTH) {
			rental = device.getRentalM();
			calendar.add(Calendar.MONTH, 1);
			endTime = calendar.getTime();
		}

		// 第三步 创建新用户订单
		EOrders orders = new EOrders();
		orders.setCreateTime(new Date());
		orders.setDeviceId(device.getId());
		orders.setDeviceName(device.getName());
		orders.setId(TextUtils.getIdByUUID());
		orders.setUserId(userId);
		orders.setStartDate(new Date());
		orders.setEndDate(endTime);
		orders.setRental(rental);
        orders.setRentalType(device.getRentalType());
		ordersMapper.insert(orders);

		// 第三步扣一个月押金
		wallet.setAmount(wallet.getAmount() - rental);
		walletMapper.updateByPrimaryKey(wallet);
		ddbService.insert(device.getUserId(), rental, EDdb.PAY_USE);
		
		// 第四步 生成新用户设备日志
		EScaneLog scaneLog = new EScaneLog();
		scaneLog.setId(TextUtils.getIdByUUID());
		scaneLog.setStartDate(new Date());
		scaneLog.setUserId(userId);
		scaneLog.setDeviceId(device.getId());
		scaneLog.setOpration(EScaneLog.RECIVE_DEVICE);
		scaneLog.setManager(device.getManager());
		scaneMapper.insert(scaneLog);

		return 1;
	}


    
	/**
	 * 换电资格
	 * 
	 * 普通用户：有一块电池归还超过3小时 
	 * 集团用户：集团用户
	 * 
	 * */
	public EOrders checkChange(EUser user, String deviceName) {
		// TODO Auto-generated method stub
	
		EOrders order = new EOrders();
		order.setDeviceName(deviceName);
		order.setUserId(user.getId());
		List<EOrders> orderList = ordersMapper.selectChangeOrders(order);

		if(orderList==null || orderList.size()==0){
			return null;
		}	

		//第一步 普通用户
		if(user.getRole()==EUser.NORMAL){						
			long nh=3600*100*5 ;					
			for (EOrders eOrders : orderList) {
				if((new Date().getTime()-eOrders.getLastBackTime().getTime())>nh){
					return eOrders;
				}
			}			
		}
		
		
		//第二步 集团用户
		if(user.getRole()==EUser.CORPORATE){
		   return orderList.get(0);
		}
						
		return null;
		
	}

	


}
