package com.didi.pay.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class HttpclientUtil {

	public static String postWithXML(String url, String xml)
			throws IOException, KeyStoreException, NoSuchAlgorithmException,
			CertificateException, KeyManagementException,
			UnrecoverableKeyException {
		StringBuffer result = new StringBuffer();
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		Resource resource = new ClassPathResource("apiclient_cert.p12");
		
		
		try {
			keyStore.load(resource.getInputStream(),
					Constant.MCHID.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SSLContext sslcontext = SSLContexts.custom()
				.loadKeyMaterial(keyStore, Constant.MCHID.toCharArray())
				.build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		try {
			HttpPost httppost = new HttpPost(url);
			StringEntity myEntity = new StringEntity(xml, "UTF-8");
			httppost.addHeader("Content-Type", "text/xml");
			httppost.setEntity(myEntity);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity resEntity = response.getEntity();
			InputStreamReader reader = new InputStreamReader(
					resEntity.getContent(), "UTF-8");
			char[] buff = new char[1024];
			int length = 0;
			while ((length = reader.read(buff)) != -1) {
				result.append(new String(buff, 0, length));
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			httpclient.close();
		}
	}

}
