package com.didi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didi.model.EOrdersExample;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.service.OrdersService;
import com.didi.service.SlaveService;
import com.didi.service.UserService;
import com.didi.service.WalletService;

@Controller
@RequestMapping("/resource-service/slave")
public class SlaveController {

	@Resource
	UserService userService;

	@Resource
	WalletService walletService;

	@Resource
	SlaveService slaveService;

	@Resource
	OrdersService orderService;

	@RequestMapping(value = "/addSlave", method = RequestMethod.GET)
	public Map<String, Object> addSlave(String userId, String slaveId,String deviceName) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {
			// 第一步 权限检查
			EUser user = userService.get(userId);
			EUser slave = userService.get(slaveId);

			if (user.getRole() != EUser.CORPORATE_MANAGER && slave.getRole() != EUser.NORMAL) {
				res.put("message", "权限不足");
				res.put("status", 210);
				return res;
			}

			// 第二步  订单数大于员工数的时候才可以继续添加
			EOrdersExample example = new EOrdersExample();
			EOrdersExample.Criteria criteria = example.createCriteria();
			criteria.andDeviceNameEqualTo(deviceName);
			criteria.andOwnerEqualTo(userId);
			criteria.andUserIdIsNull();
			
			int orderCount=(int) orderService.list(example, 0, 0).get("total");
            
			List<EUser> salveList= slaveService.salvelist(user);
			
			if(salveList!=null && salveList.size()>0){
				if(orderCount<=salveList.size()){
					res.put("message", "已满员，请续费后重试！");
					res.put("status", 210);
					return res;
				}
			}
			
			// 第二步 添加
			slave.setWalletId(user.getWalletId());
			slave.setRole(EUser.CORPORATE);
			userService.edit(slave);

			res.put("status", 200);
			res.put("message", "添加成功!");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "添加失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	@RequestMapping(value = "/deleteSlave", method = RequestMethod.GET)
	public Map<String, Object> deleteSlave(String userId, String slaveId) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			EUser user = userService.get(userId);
			EUser slave = userService.get(slaveId);
			// 第一步 权限检查
			if (user.getRole() != EUser.CORPORATE_MANAGER || slave.getRole() != EUser.CORPORATE
					|| !user.getWalletId().equals(slave.getWalletId())) {
				res.put("message", "权限不足");
				res.put("status", 210);
				return res;
			}
			// 第二步 解除绑定
			slave.setRole(EUser.NORMAL);
			EWallet wallet = walletService.getWalletByUser(slaveId);
			slave.setWalletId(wallet.getId());
			userService.edit(slave);
			res.put("message", "删除成功了");
			res.put("status", 200);

			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "添加失败!错误原因：" + e.getMessage());
			return res;

		}

	}

	@RequestMapping(value = "/slaveList", method = RequestMethod.GET)
	public Map<String, Object> slaveList(String userId) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {
			// 第一步 检查参数
			EUser user = userService.get(userId);
			if (user.getRole() != EUser.CORPORATE_MANAGER) {
				res.put("message", "权限不足");
				res.put("status", 210);
				return res;
			}

			res.put("list", slaveService.salvelist(user));
			res.put("message", "查找成功了");
			res.put("status", 200);

			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "添加失败!错误原因：" + e.getMessage());
			return res;

		}

	}

}
