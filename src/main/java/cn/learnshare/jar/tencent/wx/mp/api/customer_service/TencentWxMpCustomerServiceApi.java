package cn.learnshare.jar.tencent.wx.mp.api.customer_service;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * wx mini program customer service api
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class TencentWxMpCustomerServiceApi {
	
	
	/**
	 * send custom message
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of sendCustomMessage
	 * @return JSONObject is the result of sendCustomMessage
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/kf-mgnt/kf-message/sendCustomMessage.html">Official Website</a>
	 */
	public static JSONObject sendCustomMessage(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/cgi-bin/message/custom/send?access_token=" + accessToken, params);
	}
	
	/**
	 * upload temp media
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of uploadTempMedia
	 * @return JSONObject is the result of uploadTempMedia
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/kf-mgnt/kf-message/uploadTempMedia.html">Official Website</a>
	 */
	public static JSONObject uploadTempMedia(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/cgi-bin/media/upload?access_token=" + accessToken, params);
	}
	
	/**
	 * set typing
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of setTyping
	 * @return JSONObject is the result of setTyping
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/kf-mgnt/kf-message/setTyping.html">Official Website</a>
	 */
	public static JSONObject setTyping(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/cgi-bin/message/custom/business/typing?access_token=" + accessToken, params);
	}
	
	/**
	 * get temp media
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of getTempMedia
	 * @return JSONObject is the result of getTempMedia
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/kf-mgnt/kf-message/getTempMedia.html">Official Website</a>
	 */
	public static JSONObject getTempMedia(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/cgi-bin/media/get?access_token=" + accessToken, params);
	}
	
}