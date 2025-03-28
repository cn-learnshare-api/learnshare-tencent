package cn.learnshare.jar.tencent.wx;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * wx common api
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentWxApi {

	/**
	 * get access_token
	 *
	 * @param appId is the appid of your app
	 * @param secret is the app secret of your app
	 * @return access_token is the access token of your app
	 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html">Official Website</a>
	 */
	public static JSONObject getAccessToken(String appId, String secret) {
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "client_credential");
		params.put("appid", appId);
		params.put("secret", secret);
		return RequestCommon.doGet("/cgi-bin/token", params);
	}

	/**
	 * get stable access_token
	 *
	 * @param appId is the appid of your app
	 * @param secret is the app secret of your app
	 * @return access_token is the access token of your app
	 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/getStableAccessToken.html">Official Website</a>
	 */
	public static JSONObject getStableAccessToken(String appId, String secret) {
		return getStableAccessToken(appId, secret, false);
	}

	/**
	 * get stable access_token
	 *
	 *
	 * @param appId is the appid of your app
	 * @param secret is the app secret of your app
	 * @param forceRefresh is the refresh
	 * @return access_token is the access token of your app
	 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/getStableAccessToken.html">Official Website</a>
	 */
	public static JSONObject getStableAccessToken(String appId, String secret, Boolean forceRefresh) {
		Map<String, Object> params = new HashMap<>();
		params.put("grant_type", "client_credential");
		params.put("appid", appId);
		params.put("secret", secret);
		params.put("force_refresh", forceRefresh);
		return RequestCommon.doPost("/cgi-bin/stable_token", params);
	}

}