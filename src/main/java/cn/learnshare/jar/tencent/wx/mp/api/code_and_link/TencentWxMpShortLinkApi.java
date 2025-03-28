package cn.learnshare.jar.tencent.wx.mp.api.code_and_link;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * wx mini program short link api
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class TencentWxMpShortLinkApi {
	
	/**
	 * generate short link
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of generateShortLink
	 * @return JSONObject is the result of generateShortLink
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/short-link/generateShortLink.html">Official Website</a>
	 */
	public static JSONObject generateShortLink(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxa/genwxashortlink?access_token=" + accessToken, params);
	}
	
}