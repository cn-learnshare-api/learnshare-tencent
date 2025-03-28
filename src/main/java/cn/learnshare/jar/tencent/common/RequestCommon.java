package cn.learnshare.jar.tencent.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

/**
 * request common
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class RequestCommon {

	// encoding default value is UTF-8
	private static final String ENCODING = "UTF-8";

	// set connect timeout
	private static final int CONNECT_TIMEOUT = 6000;

	// set socket timeout
	private static final int SOCKET_TIMEOUT = 6000;

	private static final String base = "https://api.weixin.qq.com";

	/**
	 * do get request
	 *
	 * @param url is the request url
	 * @return JSONObject
	 */
	public static JSONObject doGet(String url) {
		return doGet(url, null, null);
	}
	
	/**
	 * do get request
	 *
	 * @param url is the request url
	 * @param params is the request params
	 * @return JSONObject
	 */
	public static JSONObject doGet(String url, Map<String, String> params) {
		return doGet(url, null, params);
	}
	
	/**
	 * do get request
	 *
	 * @param url is the request url
	 * @param headers is the request headers
	 * @param params is the request params
	 * @return JSONObject
	 */
	public static JSONObject doGet(String url, Map<String, String> headers, Map<String, String> params) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			URIBuilder uriBuilder = new URIBuilder(packageUrl(url));
			if (params != null) {
				Set<Map.Entry<String, String>> entrySet = params.entrySet();
				for (Map.Entry<String, String> entry : entrySet) {
					uriBuilder.setParameter(entry.getKey(), entry.getValue());
				}
			}
			HttpGet http = new HttpGet(uriBuilder.build());
			packageHeader(headers, http);
			packageConfig(http);
			return buildJsonResult(getHttpClientResult(response, client, http));
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			release(response, client);
		}
	}
	
	/**
	 * do post
	 *
	 * @param url is the request url
	 * @return JSONObject
	 */
	public static JSONObject doPost(String url) {
		return doPost(url, null, null);
	}
	
	/**
	 * do post
	 *
	 * @param url is the request url
	 * @param params is the request params
	 * @return JSONObject
	 */
	public static JSONObject doPost(String url, Map<String, Object> params) {
		return doPost(url, null, params);
	}
	
	/**
	 * do post
	 *
	 * @param url is the request url
	 * @param headers is the request headers
	 * @param params is the request params
	 * @return JSONObject
	 */
	public static JSONObject doPost(String url, Map<String, String> headers, Map<String, Object> params) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost http = new HttpPost(packageUrl(url));
			packageHeader(headers, http);
			packageConfig(http);
			packageParam(params, http);
			return buildJsonResult(getHttpClientResult(response, client, http));
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			release(response, client);
		}
	}
	
	/**
	 * do post for byte
	 *
	 * @param url is the request url
	 * @return byte[] is the response byte array
	 */
	public static byte[] doPostForByte(String url) {
		return doPostForByte(url, null, null);
	}
	
	/**
	 * do post for byte
	 *
	 * @param url is the request url
	 * @param params is the request params
	 * @return byte[] is the response byte array
	 */
	public static byte[] doPostForByte(String url, Map<String, Object> params) {
		return doPostForByte(url, null, params);
	}
	
	/**
	 * do post for byte
	 *
	 * @param url is the request url
	 * @param headers is the request headers
	 * @param params is the request params
	 * @return byte[] is the response byte array
	 */
	public static byte[] doPostForByte(String url, Map<String, String> headers, Map<String, Object> params) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		ByteArrayOutputStream out = null;
		try {
			HttpPost http = new HttpPost(packageUrl(url));
			packageHeader(headers, http);
			packageConfig(http);
			packageParam(params, http);
			HttpEntity entity = getHttpClientResult(response, client, http);
			if (entity != null) {
				out = new ByteArrayOutputStream();
				entity.writeTo(out);
				return out.toByteArray();
			} else {
				return null;
			}
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			release(response, client);
		}
	}

	/**
	 * package url
	 *
	 * @param url is the request url
	 * @return String
	 */
	public static String packageUrl(String url) {
		return url.startsWith("http") ? url : (base + url);
	}

	/**
	 * package header
	 *
	 * @param headers is the request headers
	 * @param http is the request method
	 */
	public static void packageHeader(Map<String, String> headers, HttpPost http) {
		if (headers != null) {
			Set<Map.Entry<String, String>> entrySet = headers.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				http.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}
	
	/**
	 * package header
	 *
	 * @param headers is the request headers
	 * @param http is the request method
	 */
	public static void packageHeader(Map<String, String> headers, HttpGet http) {
		if (headers != null) {
			Set<Map.Entry<String, String>> entrySet = headers.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				http.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}
	
	/**
	 * package param
	 *
	 * @param params is the request params
	 * @param http is the request method
	 */
	public static void packageParam(Map<String, Object> params, HttpPost http) {
		if (params != null) {
			try {
				StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(params));
				http.setEntity(stringEntity);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * package config
	 *
	 * @param http is the request method
	 */
	public static void packageConfig(HttpGet http) {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		http.setConfig(config);
	}
	
	/**
	 * package config
	 *
	 * @param http is the request method
	 */
	public static void packageConfig(HttpPost http) {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		http.setConfig(config);
	}
	
	/**
	 * release
	 *
	 * @param httpResponse is the request response
	 * @param httpClient is the request client
	 */
	public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) {
		try {
			if (httpResponse != null) {
				httpResponse.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * get http client result
	 *
	 * @param response is the request response
	 * @param client is the request client
	 * @param http is the request method
	 * @return HttpEntity is the response entity
	 * @throws Exception is the exception
	 */
	public static HttpEntity getHttpClientResult(CloseableHttpResponse response, CloseableHttpClient client, HttpRequestBase http) throws Exception {
		response = client.execute(http);
		if (response != null && response.getStatusLine() != null) {
			if(response.getStatusLine().getStatusCode() == 200){
				return response.getEntity();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * build json result
	 *
	 * @param httpEntity is the request response
	 * @return JSONObject is the response json object
	 * @throws Exception is the exception
	 */
	public static JSONObject buildJsonResult(HttpEntity httpEntity) throws Exception {
		if (httpEntity == null) {
			return null;
		} else {
			String body = EntityUtils.toString(httpEntity, ENCODING);
			byte[] bodyBytes = body.getBytes(StandardCharsets.ISO_8859_1);
			body = new String(bodyBytes, StandardCharsets.UTF_8);
			return JSONObject.parseObject(body);
		}
	}

}