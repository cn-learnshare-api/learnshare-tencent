package cn.learnshare.jar.tencent.wx.mp.params;

import java.util.Collection;
import java.util.Map;

/**
 * wx mini program subscribe message dto
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/subscribe-message/sendMessage.html#%E8%AF%B7%E6%B1%82%E5%8F%82%E6%95%B0">Official Website</a>
 */
public class TencentWxMpSubscribeMsgParams {
	
	private String toUser;
	private String templateId;
	private String page = "";
	private String miniProgramState = "formal";
	private String lang = "zh_CN";
	private Map<String, String> data;
	
	public String getToUser() {
		return toUser;
	}
	
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
	public String getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	public String getPage() {
		return page;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getMiniProgramState() {
		return miniProgramState;
	}
	
	public void setMiniProgramState(String miniProgramState) {
		this.miniProgramState = miniProgramState;
	}
	
	public String getLang() {
		return lang;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public Map<String, String> getData() {
		return data;
	}
	
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	public TencentWxMpSubscribeMsgParams() {}
	
	public TencentWxMpSubscribeMsgParams(String toUser, String templateId, String page, String miniProgramState, String lang, Map<String, String> data) {
		this.toUser = toUser;
		this.templateId = templateId;
		this.page = page;
		this.miniProgramState = miniProgramState;
		this.lang = lang;
		this.data = data;
	}
	
	public String toJSONFormat() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append(String.format("\"touser\":\"%s\"", this.toUser)).append(",");
		buffer.append(String.format("\"template_id\":\"%s\"", this.templateId)).append(",");
		buffer.append(String.format("\"page\":\"%s\"", this.page)).append(",");
		buffer.append(String.format("\"miniprogram_state\":\"%s\"", this.miniProgramState)).append(",");
		buffer.append(String.format("\"lang\":\"%s\"", this.lang)).append(",");
		buffer.append("\"data\":{");
		Collection<String> keys = this.data.keySet();
		for (int i = 0; i < keys.size(); i++) {
			buffer.append(String.format("\"%s\": {\"value\":\"%s\"}", keys.toArray()[i], this.data.get(keys.toArray()[i])));
			if (i < keys.size() - 1){
				buffer.append(",");
			}
		}
		buffer.append("}");
		buffer.append("}");
		return buffer.toString();
	}
	
}