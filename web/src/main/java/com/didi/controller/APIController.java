package com.didi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.DApi;
import com.didi.service.APIService;
import com.didi.unti.TextUtils;

/**
 * Created by wangh09 on 2017/4/30.
 */
@Controller
@RequestMapping("/resource-service/api")
public class APIController {
    @Resource
    private APIService apiService;
   
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(@RequestBody DApi api){
        Map<String,Object> res = new HashMap<String,Object>();
        try {
            int status = apiService.insert(api);
            if(status == 1){
                res.put("status",200);
                res.put("message","添加成功!");
            }else {
                res.put("status",210);
                res.put("msg","添加失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status",210);
            res.put("message", TextUtils.underline2Camel(e.getCause().getMessage()));
        }
        return res;
    }

    @RequestMapping(value="/add-batch",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add_batch(@RequestBody Map<String,String> apis){
        Map<String,Object> res = new HashMap<String,Object>();
        try {
            int status = 1;
            int count = 1;
            DApi api = new DApi();
            for (String key: apis.keySet()) {
                api.setApi(key);
                api.setService(apis.get(key));


                Map<String,Object> apiInsert = apiService.list(api,1,1);
                if((Long)apiInsert.get("total")  == 0)
                    status += apiService.insert(api);
                count ++;
            }
            if(status == count){
                res.put("status",200);
                res.put("message","添加成功!");
            }else {
                res.put("status",200);
                res.put("msg","添加完成!存在重复");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status",210);
            res.put("message", TextUtils.underline2Camel(e.getCause().getMessage()));
        }
        return res;
    }


    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage,
            @RequestParam(required = false) String service,
            @RequestParam(required = false) String api

    ){

        Map<String,Object> res = new HashMap<String,Object>();
        try {
            DApi api_ = new DApi();
            api_.setService(service);
            api_.setApi(api);
            res.put("status",200);
            res.put("message","查找成功!");
            res.put("result",apiService.list(api_,page,perPage));
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status",210);
            res.put("message", TextUtils.underline2Camel(e.getCause().getMessage()));
        }
        return res;
    }
}
