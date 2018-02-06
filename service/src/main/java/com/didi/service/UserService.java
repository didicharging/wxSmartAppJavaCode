package com.didi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.aliyun.oss.OSSClient;
import com.didi.mapper.EUserMapper;
import com.didi.mapper.EWalletMapper;
import com.didi.model.EDdb;
import com.didi.model.EUser;
import com.didi.model.EUserExample;
import com.didi.model.EWallet;
import com.didi.unti.ServerUtils;
import com.didi.unti.TextUtils;

import net.sf.json.JSONObject;

/**
 * Created by wangh09 on 2017/4/30.
 */
@Service
public class UserService implements BaseCRUDService {
	@Resource
	EUserMapper mapper;
	
	@Resource
	EWalletMapper wallerMapper;
	
	@Resource
	DdbService ddbService;

	public static OSSClient   ossClient = new OSSClient(ServerUtils.OSS_endpoint, ServerUtils.OSS_accessKeyId,
			ServerUtils.OSS_accessKeySecret);

	@Override
	public int edit(Object object) {
		EUser user = (EUser) object;
		mapper.updateByPrimaryKey(user);
		
		return 0;
	}

	@Override
	public int insert(Object object) {

		EUser user = (EUser) object;

		// 判断邀请者
		if (!user.getInvideUser().equalsIgnoreCase("")) {

			user.setInvideUser(user.getInvideUser());
			mapper.addInvideAmount(user.getInvideUser());
			mapper.addOrdersAndElectric(user.getInvideUser());
			
			ddbService.insert(user.getInvideUser(),500,EDdb.NEW_USER);

		}
		
		//插入钱包表
		EWallet wallet = new EWallet();
		wallet.setAmount(0);
		wallet.setId(TextUtils.getIdByUUID());
		wallet.setShareAmount(new BigDecimal(0));
		wallet.setUserId(user.getId());
		wallet.setRole(EWallet.NORMAL);
		wallerMapper.insert(wallet);
		
		int result = mapper.insert(user);

		return result;
	}

	public String getQrImgUrl(String invideCode) {
		// TODO Auto-generated method stub
		String token = ClientGet("https://api.weixin.qq.com/cgi-bin/token",
				"AppID=wxb578ca87ab1f91c7&secret=978e0091c58bf5e9606df66103137e77&grant_type=client_credential");
		String qrImgUrl = "";
		try {
			qrImgUrl = ClientPost(token, invideCode);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

		return qrImgUrl;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public Map<String, Object> list(Object object, int page, int perPage) {
		if (object == null)
			return null;
		EUser user = (EUser) object;

		EUserExample example = new EUserExample();
		EUserExample.Criteria criteria = example.createCriteria();

		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
		if(user.getRole()!=null)
			criteria.andRoleEqualTo(user.getRole());

		if (user.getWechatId() != null)
			criteria.andWechatIdEqualTo(user.getWechatId());

		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("create_time");

		if (null != user.getProfileImage()) {
		    mapper.updateImageBug(user);
		}

		List<EUser> list = mapper.selectByExample(example);
         
		
		
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}
	
	public EUser get(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Map<String, Object> getUserInfoById(String id) {

		Map<String, Object> map = mapper.getUserInfoById(id);

		String qrImg = (String) map.get("qrImg");

		if (null == qrImg || qrImg.equalsIgnoreCase("")) {
			String qrImgUrl = getQrImgUrl(id);
			EUser user = new EUser();
			user.setId(id);
			user.setQrImg(qrImgUrl);
		
		   mapper.updateByPrimaryKeySelective(user);
			
		}

		return mapper.getUserInfoById(id);
	}

	public Map<String, Object> getRankingList(String userId) {

		Map<String, Object> res = new HashMap<String, Object>();
		List<Map<String, Object>> list = mapper.getRankingList();
		Map<String, Object> myRank = mapper.getMyRank(userId);

		res.put("list", list);
		res.put("myRank", myRank);
		return res;
	}

	private static  String ClientPost(String token, String invideCode) throws ParseException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建httppost
		HttpPost httppost = new HttpPost("https://api.weixin.qq.com/wxa/getwxacode?access_token=" + token);

		httppost.addHeader("Content-Type", "application/json");

		JSONObject obj = new JSONObject();
		obj.put("scene", invideCode);
		obj.put("path", "pages/login/login?invideCode=" + invideCode);
		obj.put("width", "430");
		String s = obj.toString();

		StringEntity stringEntity = new StringEntity(s, "UTF-8");
		stringEntity.setContentEncoding("UTF-8");

		httppost.setEntity(stringEntity);

		CloseableHttpResponse response = httpclient.execute(httppost);
		String key = "";
		if (response != null) {
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				InputStream instreams = resEntity.getContent();
		
				key = TextUtils.getIdByUUID() + ".jpeg";
				ossClient.putObject(ServerUtils.OSS_bucketName, key, instreams);

			}
		}
		return "http://img.didicharging.com/" + key;

	}

	private static  String ClientGet(String url, String param) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		String urlNameString = url + "?" + param;

		String token = "";

		try {

			// 用get方法发送http请求
			HttpGet get = new HttpGet(urlNameString);
		
			CloseableHttpResponse httpResponse = null;

			// 发送get请求
			httpResponse = httpClient.execute(get);
			HttpEntity entity = httpResponse.getEntity();

			if (null != entity) {

				JSONObject obj = JSONObject.fromObject(EntityUtils.toString(entity));
				Map<String, Object> map = (Map) obj;

				token = (String) map.get("access_token");
			}

			httpClient.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return token;

	}
		
	 public static int saveToImgByInputStream(InputStream instreams,String imgPath,String imgName){
	        int stateInt = 1;
	        if(instreams != null){
	            try {
	                File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等
	                FileOutputStream fos=new FileOutputStream(file);
	                byte[] b = new byte[1024];
	                int nRead = 0;
	                while ((nRead = instreams.read(b)) != -1) {
	                    fos.write(b, 0, nRead);
	                }
	                fos.flush();
	                fos.close();                
	            } catch (Exception e) {
	                stateInt = 0;
	                e.printStackTrace();
	            } finally {
	            }
	        }
	        return stateInt;
	    }

}


