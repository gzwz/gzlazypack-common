package gzlazypack.common.util;

import com.alibaba.fastjson.JSON;
/**
 * 异步请求消息结果
 * @author chenhaohao
 *
 */
public class ResultJSON {

	/**
	 * 成功失败
	 */
	private boolean success;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	/**
	 * 结果
	 */
	private Object data;
	
	
	private ResultJSON(Object data,boolean success){
		this.data = data;
		this.success = success;
	}
	
	/**
	 * 成功返回结果
	 * @param success
	 * @param result
	 */
	private ResultJSON(boolean success, String errorMsg){
		this.success = success;
		this.errorMsg = errorMsg;
	}
	
	private ResultJSON(boolean success, String errorMsg,Object data){
		this.success = success;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	
	/**
	 * 返回消息提示
	 * @param success
	 * @param errorMsg
	 */
	public static String resultToJSONStr(boolean success, Object data){
		return JSON.toJSONString(new ResultJSON(data,success));
	}
	
	public static String resultToJSONStr(boolean success, String errorMsg){
		return JSON.toJSONString(new ResultJSON(success, errorMsg));
	}
	
	public static String resultToJSONStr(boolean success, String errorMsg,Object data){
		return JSON.toJSONString(new ResultJSON(success,errorMsg,data));
	}



	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	

}
