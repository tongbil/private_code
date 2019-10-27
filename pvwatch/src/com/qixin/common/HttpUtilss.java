package com.qixin.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/** 
 * @author xqq
 * @date 2018年4月23日 下午2:49 
 * HttpClient工具类 
 */  
public class HttpUtilss {  

	private static Logger logger = Logger.getLogger(HttpUtil.class);  

	/** 
	 * get请求 
	 * @return 
	 */  
	public static String doGet(String url) {  
		try {  
			HttpClient client = new DefaultHttpClient();  

			//setConnectionRequestTimeout(1000)  

			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(3000).setSocketTimeout(5000).build();  
			//发送get请求  
			HttpGet request = new HttpGet(url);  
			request.setConfig(requestConfig);
			HttpResponse response = client.execute(request);  

			/**请求发送成功，并得到响应**/  
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
				/**读取服务器返回过来的json字符串数据**/  
				String strResult = EntityUtils.toString(response.getEntity());  

				return strResult;  
			}  
		}   
		catch (IOException e) {  
			e.printStackTrace();  
		}  

		return null;  
	}  
	
	
	
	/** 
	 * get请求 
	 * @return 
	 */  
	public static Map<String,String> doGet2(String url,Map<String, String> header) {  
		
		Map<String,String> result = new HashMap<>();
		try {  
			HttpClient client = new SSLHttpClient();  

			//setConnectionRequestTimeout(1000)  

			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(3000).setSocketTimeout(5000).build();  
			//发送get请求  
			HttpGet request = new HttpGet(url);  
			request.setConfig(requestConfig);
			
			if(header!=null&&!header.isEmpty()){
				Set<Entry<String, String>> entrySet = header.entrySet();
				for (Entry<String, String> entry : entrySet) {
					request.addHeader(entry.getKey(), entry.getValue());
				}
			}
			
			HttpResponse response = client.execute(request);  

			/**请求发送成功，并得到响应**/  
			int statusCode = response.getStatusLine().getStatusCode();
			String strResult = EntityUtils.toString(response.getEntity(),"UTF-8");  
			
			result.put("code",new Integer(statusCode).toString());
			result.put("content", strResult);
		}   
		catch (Exception e) {  
			e.printStackTrace();  
			result.put("code","550");
			result.put("content",e.getMessage());
		}  

		return result;  
	} 

	/** 
	 * post请求(用于key-value格式的参数) 
	 * @param url 
	 * @param params 
	 * @return 
	 */  
	public static String doPost(String url, Map params){  

		BufferedReader in = null;    
		try {    
			// 定义HttpClient    
			HttpClient client = new DefaultHttpClient();    
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(3000).setSocketTimeout(5000).build();  
			// 实例化HTTP方法    
			HttpPost request = new HttpPost();    
			request.setConfig(requestConfig);
			request.setURI(new URI(url));  

			//设置参数  
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();   
			for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {  
				String name = (String) iter.next();  
				String value = String.valueOf(params.get(name));  
				nvps.add(new BasicNameValuePair(name, value));  

				//System.out.println(name +"-"+value);  
			}  
			request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));  

			HttpResponse response = client.execute(request);    
			int code = response.getStatusLine().getStatusCode();  
			if(code == 200){    //请求成功  
				in = new BufferedReader(new InputStreamReader(response.getEntity()    
						.getContent(),"utf-8"));  
				StringBuffer sb = new StringBuffer("");    
				String line = "";    
				String NL = System.getProperty("line.separator");    
				while ((line = in.readLine()) != null) {    
					sb.append(line + NL);    
				}  

				in.close();    

				return sb.toString();  
			}  
			else{   //  
				System.out.println("状态码：" + code);  
				return null;  
			}  
		}  
		catch(Exception e){  
			e.printStackTrace();  

			return null;  
		}  
	}  

	/** 
	 * post请求（用于请求json格式的参数） 
	 * @param url 
	 * @param params 
	 * @return 
	 */  
	public static String doPost(String url, String params) throws Exception {  

		CloseableHttpClient httpclient = HttpClients.createDefault();  

		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(3000).setSocketTimeout(5000).build();  

		HttpPost httpPost = new HttpPost(url);// 创建httpPost   
		httpPost.setConfig(requestConfig);
		httpPost.setHeader("Accept", "application/json");   
		httpPost.setHeader("Content-Type", "application/json");  
		String charSet = "UTF-8";  
		StringEntity entity = new StringEntity(params, charSet);  
		httpPost.setEntity(entity);          
		CloseableHttpResponse response = null;  

		try {  

			response = httpclient.execute(httpPost);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  
			if (state == HttpStatus.SC_OK) {  
				HttpEntity responseEntity = response.getEntity();  
				String jsonString = EntityUtils.toString(responseEntity);  
				return jsonString;  
			}  
			else{  
				System.out.println("请求返回:"+state+"("+url+")");
				logger.error("请求返回:"+state+"("+url+")");  
			}  
		}  
		finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpclient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return null;  
	}  

	public static Map<String,String>  PostFile(String url,Map<String, String> headers,Map<String,String> params,String bodyType) throws ClientProtocolException, IOException{
		Map<String,String> results = new HashMap<String, String>();
		try {
			CloseableHttpClient httpClient = new SSLHttpClient();
			HttpPost httpPost = new HttpPost(url);
			for (String key : headers.keySet()) {
				httpPost.addHeader(key, headers.get(key));
			}
			if("raw".equals(bodyType)){
				String paramStr = JSON.toJSONString(params);
				StringEntity postString = new StringEntity(paramStr);
				httpPost.setEntity(postString);
			}else{
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				for (String key : params.keySet()) {
					nvps.add(new BasicNameValuePair(key, params.get(key)));
				}
				httpPost.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
			}

			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			int code = httpResponse.getStatusLine().getStatusCode();
			System.out.println(code);

			results.put("code",new Integer(code).toString());
			results.put("content", EntityUtils.toString(httpResponse.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
			results.put("code","550");
			results.put("content",e.getMessage());
		}

		return results;
	}
	
	
	
	
	public static String doPost(String url,Map<String,String> headers,Object params,String type) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			if(headers!=null){
				for (String key : headers.keySet()) {
					httpPost.setHeader(key, headers.get(key));
				}
			}
			if(params!=null){
				if(("raw").equals(type)){
					if(params instanceof String){
						String paramsJson=params.toString();
						httpPost.setEntity(new StringEntity(paramsJson,"UTF-8"));
					}
				}else if("multipart/form-Data".equals(type)){
					RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(10000).build();
					httpPost.setConfig(requestConfig);
					MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
					if(params instanceof Map){
						ContentType contentType = ContentType.create("text/plain", "UTF-8");
						Map<String,Object> mapParams = (Map<String, Object>) params;
						for (String key : mapParams.keySet()) {
							if(mapParams.get(key) instanceof File){
								multipartEntityBuilder.addPart(key,new FileBody((File)mapParams.get(key)));
								//multipartEntityBuilder.addBinaryBody(key, (File)mapParams.get(key));
							}else{
								multipartEntityBuilder.addTextBody(key, mapParams.get(key).toString(),contentType);
							}
						}
					}
					HttpEntity httpEntity=multipartEntityBuilder.build();
					httpPost.setEntity(httpEntity);
				}else{
					if(params instanceof Map){
						List<NameValuePair> nvp = new ArrayList<NameValuePair>();
						HashMap<String,Object> paramsMap = (HashMap) params;
						for (String key : paramsMap.keySet()) {
							nvp.add(new BasicNameValuePair(key, paramsMap.get(key).toString()));
						}
						httpPost.setEntity(new UrlEncodedFormEntity(nvp,"UTF-8"));
					}
				}
			}
			
			CloseableHttpResponse response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode()==200){
				result = EntityUtils.toString(response.getEntity());
			}
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}


}  