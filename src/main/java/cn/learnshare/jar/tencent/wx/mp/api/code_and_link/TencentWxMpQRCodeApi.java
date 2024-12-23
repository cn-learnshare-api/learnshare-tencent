package cn.learnshare.jar.tencent.wx.mp.api.code_and_link;

import cn.learnshare.jar.tencent.common.RequestCommon;
import cn.learnshare.jar.utils.file.FileImageUtils;

import java.util.Map;

/**
 * wx mini program qrcode api
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TencentWxMpQRCodeApi {

	/**
	 * getQRCode
	 *
	 * @param accessToken is the access token of wechat mini program
	 * @param params is the params of wechat mini program
	 * @return byte[] is the byte array of qrcode image
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getQRCode.html">Official Website</a>
	 */
	public static byte[] getQRCode(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPostForByte("/wxa/getwxacode?access_token=" + accessToken, null, params);
	}

	/**
	 * getQRCode
	 *
	 * @param accessToken is the access token of wechat mini program
	 * @param params is the params of wechat mini program
	 * @param savePath is the save path of qrcode image
	 * @return boolean is the result of save qrcode image
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getQRCode.html">Official Website</a>
	 */
	public static Boolean getQRCode(String accessToken, Map<String, Object> params, String savePath) {
		return FileImageUtils.writeByteToFile(getQRCode(accessToken, params), savePath);
	}

	/**
	 * getUnlimitedQRCode
	 *
	 * @param accessToken is the access token of wechat mini program
	 * @param params is the params of wechat mini program
	 * @return boolean is the result of save qrcode image
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getUnlimitedQRCode.html">Official Website</a>
	 */
	public static byte[] getUnlimitedQRCode(String accessToken, Map<String, Object> params) {
		return RequestCommon.doPostForByte("/wxa/getwxacodeunlimit?access_token=" + accessToken, null, params);
	}

	/**
	 * getUnlimitedQRCode
	 *
	 * @param accessToken is the access token of wechat mini program
	 * @param params is the params of wechat mini program
	 * @param savePath is the save path of qrcode image
	 * @return boolean is the result of save qrcode image
	 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getUnlimitedQRCode.html">Official Website</a>
	 */
	public static Boolean getUnlimitedQRCode(String accessToken, Map<String, Object> params, String savePath) {
		return FileImageUtils.writeByteToFile(getUnlimitedQRCode(accessToken, params), savePath);
	}

}