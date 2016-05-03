package gzlazypack.common.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import com.alibaba.fastjson.JSON;

public class SMSUtils {

	// 短信发送地址
	private String smsAddress;

	// 短信发送用户名
	private String smsUser;

	// 短信发送密码
	private String smsPassword;
	
	public SMSUtils(){
		
	}

	public SMSUtils(String smsAddress, String smsUser, String smsPassword) {
		this.smsAddress = smsAddress;
		this.smsUser = smsUser;
		this.smsPassword = smsPassword;
	}

	public String sendSms(String mobile, String msg) throws Exception {
		// POST请求提交
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(smsAddress);

		// 防止乱码
		client.getParams().setHttpElementCharset("UTF-8");
		client.getParams().setContentCharset("UTF-8");

		// 平台调用的用户名密码
		post.setParameter("userName", smsUser);
		post.setParameter("pass", smsPassword);
		OpenSms os = new OpenSms();
		os.setContent(msg);// 短信内容 不超过400个字符
		os.setMobile(mobile);// 接受号码
		List<OpenSms> list = new ArrayList<OpenSms>();
		list.add(os);
		String jsonArrayString = JSON.toJSONString(list);
		post.setParameter("listSms", jsonArrayString);
		client.executeMethod(post);// 服务器状态码
		return post.getResponseBodyAsString(); // 调用后返回结果
	}

	public void setSmsAddress(String smsAddress) {
		this.smsAddress = smsAddress;
	}
	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public static void main(String[] args) {
		SMSUtils sendSms = new SMSUtils();
		try {
			String result = sendSms.sendSms("13634153082",
					"尊敬的复核员，您有交易待批复，请在15点前登录平台的待办事项中查看并批复。");// 
			// String result = sendSms.sendSms("13634153082", "Hello世界");//
			// String result = sendSms.sendSms("18668432229", "Hello世界");//lixx
			// String result = sendSms.sendSms("13757193676", "Hello世界");//yangk
			// String result = sendSms.sendSms("15336525966",
			// "Hello世界");//zhangqy
			System.out.println("返回结果：" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
