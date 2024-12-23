package cn.learnshare.jar.tencent.qq.api.user;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * QQ user api
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentQqUserApi {

	/**
	 * login
	 *
	 * @param oauthConsumerKey QQ internet applications oauth_consumer_key
	 * @param openId QQ login successful openId
	 * @param accessToken QQ login successful accessToken
	 * @return login successful user information
	 * @see <a href="https://wiki.connect.qq.com/openapi%e8%b0%83%e7%94%a8%e8%af%b4%e6%98%8e_oauth2-0">Official Website</a>
	 */
	public static JSONObject login(String oauthConsumerKey, String openId, String accessToken) {
		Map<String, String> params = new HashMap<>();
		params.put("oauth_consumer_key", oauthConsumerKey);
		params.put("openid", openId);
		params.put("access_token", accessToken);
		return RequestCommon.doGet("https://graph.qq.com/oauth2.0/me", null, params);
	}

}