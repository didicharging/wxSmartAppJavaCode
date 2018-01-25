package com.didi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.didi.unti.ServerUtils;
import com.didi.unti.TextUtils;

/**
 * Created by wangh09 on 2017/5/12.
 */
@RestController
@RequestMapping("/resource-service/image")
public class ImageController {

	OSSClient ossClient = new OSSClient(ServerUtils.OSS_endpoint,
			ServerUtils.OSS_accessKeyId, ServerUtils.OSS_accessKeySecret);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> handleFileUpload(
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		System.out.println("成功进入函数");
		  
		Map<String, Object> res = new HashMap<String, Object>();
		if (!file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				System.out.println("fileName: "+fileName);
				
				String prefix = fileName.substring(fileName.lastIndexOf("."))
						.toLowerCase();
				
				if (!(prefix.equals(".jpg") || prefix.equals(".png"))) {
					res.put("status", 210);
					res.put("message", "上传失败，目前仅支持.jpg和.png！");
					return res;
				}
				
				
				String key = TextUtils.getIdByUUID() + prefix;
				
				System.out.println("key: "+key);
				
				ossClient.putObject(ServerUtils.OSS_bucketName, key,
						file.getInputStream());

				res.put("status", 200);
				res.put("message", "上传成功！");
				Map<String, Object> result = new HashMap<String, Object>();
				
				result.put("key", key);
				res.put("result", result);
				
				return res;

			}
			catch (OSSException oe) {
			    System.out.println("Caught an OSSException, which means your request made it to OSS, "
			            + "but was rejected with an error response for some reason.");
			    System.out.println("Error Message: " + oe.getErrorCode());
			    System.out.println("Error Code:       " + oe.getErrorCode());
			    System.out.println("Request ID:      " + oe.getRequestId());
			    System.out.println("Host ID:           " + oe.getHostId());
			    res.put("status", 210);
				
				return res;
			} catch (ClientException ce) {
			    System.out.println("Caught an ClientException, which means the client encountered "
			            + "a serious internal problem while trying to communicate with OSS, "
			            + "such as not being able to access the network.");
			    System.out.println("Error Message: " + ce.getMessage());
			    res.put("status", 210);
				
				return res;
			} 
			

			
			
             catch (IOException | RuntimeException e) {
				e.printStackTrace();
				res.put("status", 210);
				res.put("message",
						TextUtils.underline2Camel(e.getCause().getMessage()));
				return res;
			}
		} else {
			res.put("status", 200);
			res.put("message", "上传失败，找不到文件！");
			return res;
		}
	}

	

}
