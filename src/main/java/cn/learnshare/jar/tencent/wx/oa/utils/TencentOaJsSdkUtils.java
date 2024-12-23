package cn.learnshare.jar.tencent.wx.oa.utils;

import cn.learnshare.jar.utils.encrypt.EncryptShaUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * wx oa js sdk utils
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentOaJsSdkUtils {

	/**
	 * share
	 *
	 * @param appId is the app id of your app
	 * @param jsApiTicket is the js api ticket of your app
	 * @param url is the current url of your app
	 * @return the map of share parameters
	 */
	public static Map<String, String> share(String appId, String jsApiTicket, String url) {
		Map<String, String> vo = new HashMap<>();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String nonceStr = UUID.randomUUID().toString();
		String signature = EncryptShaUtils.sha1("jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url);
		vo.put("appId", appId);
		vo.put("url", url);
		vo.put("jsapi_ticket", jsApiTicket);
		vo.put("nonceStr", nonceStr);
		vo.put("timestamp", timestamp);
		vo.put("signature", signature);
		return vo;
	}

}