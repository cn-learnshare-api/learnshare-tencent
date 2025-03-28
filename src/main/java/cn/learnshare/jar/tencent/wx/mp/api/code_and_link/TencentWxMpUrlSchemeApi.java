package cn.learnshare.jar.tencent.wx.mp.api.code_and_link;

import cn.learnshare.jar.tencent.common.RequestCommon;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * wx mini program url scheme api
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class TencentWxMpUrlSchemeApi {
	
	/**
	 * get encrypted scheme code
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of generateScheme
	 * @return JSONObject is the result of generateScheme
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-scheme/generateScheme.html">Official Website</a>
	 */
	public static JSONObject generateScheme(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxa/generatescheme?access_token=" + accessToken, params);
	}
	
	/**
	 * query encrypted scheme code
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of queryScheme
	 * @return JSONObject is the result of queryScheme
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-scheme/queryScheme.html">Official Website</a>
	 */
	public static JSONObject queryScheme(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxa/queryscheme?access_token=" + accessToken, params);
	}
	
	/**
	 * get  NFC encrypted scheme code
	 *
	 * @param accessToken is the access token of wx mini program
	 * @param params is the params of generateNFCScheme
	 * @return JSONObject is the result of generateNFCScheme
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-scheme/generateNFCScheme.html">Official Website</a>
	 */
	public static JSONObject generateNFCScheme(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPost("/wxa/generatenfcscheme?access_token=" + accessToken, params);
	}
	
}