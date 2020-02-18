package com.google.demoForIdea.common;


import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
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

import java.io.*;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * 
 * @author shusheng
 *
 */
public class HttpClient {
	public static String doGet(String url) {
		try {
			org.apache.http.client.HttpClient client = new DefaultHttpClient();

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
	 * post请求(用于key-value格式的参数)
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map params){

		BufferedReader in = null;
		try {
			// 定义HttpClient
			org.apache.http.client.HttpClient client = new DefaultHttpClient();
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
	public static String doPost(String url,Map<String,String> headers,Object params,String type) {
		//Map<String, Object> params = new HashMap<String, Object>(); 调这个方法
	//	params.put("file", file);
		//String uploadFileResult = HttpUtilss.doPost(url+"/fileManager/uploadFile.htm", null, params,
			//	"multipart/form-Data");
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
	public static String httpFileUpload(String url,File file) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException{
		CloseableHttpClient httpClient = null;
		if(url.startsWith("https")){
			httpClient = new SSLHttpClient();
		}else{
			httpClient =  HttpClients.createDefault();
		}
		HttpPost httpPost = new HttpPost(url);
		FileBody filebody = new FileBody(file);
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(10000).build();
		httpPost.setConfig(requestConfig);
//		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().addBinaryBody("file", file);
//		HttpEntity httpEntity = multipartEntityBuilder.build();
		HttpEntity httpEntity=MultipartEntityBuilder.create().addPart("file",filebody).build();
		httpPost.setEntity(httpEntity);
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if(statusCode==200){
			InputStream inputStream = responseEntity.getContent();
			byte[] byteArray = IOUtils.toByteArray(inputStream);
			return new String(byteArray);
		}
		
		if(httpResponse!=null){
			httpResponse.close();
		}
		if(httpClient!=null){
			httpClient.close();
		}
		return null;
	}
	public static void main(String[] args) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException {
		String url = "http://qixinkeji.jios.org:8081/pvwatchFileServer/uploadFile.htm";
		File file = new File("C:\\Users\\Administrator\\Desktop\\cde\\CDE ҩ�ﾯ��ϵͳ�����ύ��أ�ESG��Gateway to Gateway�������ݼ����.docx");
		String result = HttpClient.httpFileUpload(url, file);
		System.out.println(result);
		
//		String fileName = "M00/00/00/wKhkSluXMO2AfD6PAAMyhwXdPic67.docx";
//		String deleteurl = "http://192.168.100.115:8080/pvwatchFileServer/deleteFdfsFile.htm?groupName=group2&saveName="+fileName;
//		byte[] data = HttpClient.doGet(deleteurl);
//		String deleteresult = new String(data);
//		System.out.println(deleteresult);
	}
}
