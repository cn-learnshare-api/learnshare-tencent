package cn.learnshare.jar.tencent.wx.mp.api.code_and_link;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * wx mini program url link api
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class TencentWxMpUrlLinkApi {
	
	/**
	 * generate url link
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of generateUrlLink
	 * @return JSONObject is the result of generateUrlLink
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-link/generateUrlLink.html">Official Website</a>
	 */
	public static JSONObject generateUrlLink(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxa/generate_urllink?access_token=" + accessToken, params);
	}
	
	/**
	 * query url link
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of queryUrlLink
	 * @return JSONObject is the result of queryUrlLink
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-link/queryUrlLink.html">Official Website</a>
	 */
	public static JSONObject queryUrlLink(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxa/query_urllink?access_token=" + accessToken, params);
	}
	
}