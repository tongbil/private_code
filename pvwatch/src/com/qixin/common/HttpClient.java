package com.qixin.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 
 * @author shusheng
 *
 */
public class HttpClient {
	public static byte[] doGet(String url) throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException{
		byte[] buffer = null;
		CloseableHttpClient httpClient = null;
		if(url.startsWith("https")){
			httpClient = new SSLHttpClient();
		}else{
			httpClient = HttpClients.createDefault();
		}
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		if(httpResponse.getStatusLine().getStatusCode()==200){
			buffer=EntityUtils.toByteArray(httpResponse.getEntity());
		}
		return buffer;
	}
	public static byte[] doPost(String url,Map<String,String> headers,Object params,String type){
		CloseableHttpClient httpClient = null;
		if(url.startsWith("https")){
			try {
				httpClient = new SSLHttpClient();
			} catch (KeyManagementException | NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}else{
			httpClient =  HttpClients.createDefault();
		}
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
					try {
						httpPost.setEntity(new UrlEncodedFormEntity(nvp,"UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode()==200){
				return EntityUtils.toByteArray(response.getEntity());
			}
			response.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
