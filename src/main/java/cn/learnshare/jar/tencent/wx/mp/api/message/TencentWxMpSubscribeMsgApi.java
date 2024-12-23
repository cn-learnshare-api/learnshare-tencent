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
	 * @param accessToken is wechat mini program access token
	 * @param params is the message params, please refer to the official documentation for details
	 * @return the response of the request, please refer to the official documentation for details
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/subscribe-message/sendMessage.html">Official Website</a>
	 */
	public static JSONObject send(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/cgi-bin/message/subscribe/send?access_token=" + accessToken, null, params);
	}

}