package cn.learnshare.jar.tencent.wx.mp.api.login;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * wx mini program user api
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentWxMpLoginApi {

	/**
	 * login
	 *
	 * @param appId is the app id of your mini program
	 * @param secret is the secret of your mini program
	 * @param code is the code of wx mini program login
	 * @return login response is a json object
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-login/code2Session.html">Official Website</a>
	 */
	public static JSONObject login(String appId, String secret, String code) {
		Map<String, String> params = new HashMap<>();
		params.put("appid", appId);
		params.put("secret", secret);
		params.put("js_code", code);
		params.put("grant_type", "authorization_code");
		return RequestCommon.doGet("/sns/jscode2session", null, params);
	}

}