package com.didi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.DApiMapper;
import com.didi.model.DApi;
import com.didi.model.DApiExample;

/**
 * Created by wangh09 on 2017/4/30.
 */
@Service
public class APIService implements BaseCRUDService {
    @Resource
    DApiMapper mapper;
    
    @Override
    public int edit(Object object) {
        return 0;
    }

    @Override
    public int insert(Object object) {
        DApi api = (DApi)object;
        api.setIsPublic(false);
        api.setCreateTime(new Date());
        return mapper.insert(api);
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public Map<String, Object> list(Object object, int page, int perPage) {
        DApi api = (DApi)object;
        DApiExample example = new DApiExample();
        if(page >0 && perPage > 0) {
            example.setLimit(perPage);
            example.setOffset((page - 1) * perPage);
        }

        DApiExample.Criteria criteria = example.createCriteria();
        if(api.getService() != null)
            criteria.andServiceEqualTo(api.getService());
        
        if(api.getApi() != null)
            criteria.andApiEqualTo(api.getApi());
        example.setOrderByClause("api");
        Map<String,Object> result = new HashMap<String,Object>();

        List<DApi> res = mapper.selectByExample(example);

        result.put("data",res);
        result.put("total",mapper.countByExample(example));
        return result;
    }

    @Override
    public Object get(String id) {
        return null;
    }
}
