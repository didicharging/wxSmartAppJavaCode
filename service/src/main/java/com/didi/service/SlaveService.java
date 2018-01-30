package com.didi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EUserMapper;
import com.didi.model.EUser;
import com.didi.model.EUserExample;

@Service
public class SlaveService {

	@Resource
	EUserMapper userMapper;
	

	public List<EUser> salvelist(EUser user) {
	
        EUserExample example=new EUserExample();
        EUserExample.Criteria userCriteria=example.createCriteria();
        userCriteria.andWalletIdEqualTo(user.getWechatId());
        
        return userMapper.selectByExample(example);
      
	}

	
}
