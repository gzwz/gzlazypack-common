package gzlazypack.common.component;

@SuppressWarnings("serial")
public class BaseException extends Exception {

	private int code;

	private String codeStr;

	public final static Integer NECESSARY_PARAM_NULL = 1000; // 缺少必需的参数

	public BaseException() {
		super();
	}

	public BaseException(int code, String message) {
		super(message);
		this.code = code;
	}

	public BaseException(String codeStr, String message) {
		super(message);
		this.codeStr = codeStr;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCodeStr() {
		return codeStr;
	}

	public void setCodeStr(String codeStr) {
		this.codeStr = codeStr;
	}

}
