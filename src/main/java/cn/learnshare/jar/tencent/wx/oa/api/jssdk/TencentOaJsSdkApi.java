package cn.learnshare.jar.tencent.wx.oa.api.jssdk;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * wx oa ticket api
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentOaJsSdkApi {

	/**
	 * get js api ticket
	 *
	 * @param accessToken is the access token of wechat oa
	 * @return js api ticket
	 * @see <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html">Official Website</a>
	 */
	public static JSONObject getTicket(String accessToken) {
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("type", "jsapi");
		return RequestCommon.doGet("/cgi-bin/ticket/getticket", null, params);
	}

}