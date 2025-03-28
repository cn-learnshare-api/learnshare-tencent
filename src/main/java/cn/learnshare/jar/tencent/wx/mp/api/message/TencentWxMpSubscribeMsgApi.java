package cn.learnshare.jar.tencent.wx.mp.api.message;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * wx mini program subscribe message api
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentWxMpSubscribeMsgApi {

	/**
	 * send subscribe message
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of send subscribe message
	 * @return JSONObject is the result of send subscribe message
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/subscribe-message/sendMessage.html">Official Website</a>
	 */
	public static JSONObject send(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/cgi-bin/message/subscribe/send?access_token=" + accessToken, params);
	}
	
	/**
	 * add subscribe message template
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of add subscribe message template
	 * @return  JSONObject is the result of add subscribe message template
	 * @version 1.0.1
	 * @since 1.0.1
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/subscribe-message/addMessageTemplate.html">Official Website</a>
	 */
	public static JSONObject addTemplate(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxaapi/newtmpl/addtemplate?access_token=" + accessToken, params);
	}
	
	/**
	 * del subscribe message template
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of del subscribe message template
	 * @return  JSONObject is the result of del subscribe message template
	 * @version 1.0.1
	 * @since 1.0.1
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/subscribe-message/deleteMessageTemplate.html">Official Website</a>
	 */
	public static JSONObject delTemplate(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxaapi/newtmpl/deltemplate?access_token=" + accessToken, params);
	}
	
}