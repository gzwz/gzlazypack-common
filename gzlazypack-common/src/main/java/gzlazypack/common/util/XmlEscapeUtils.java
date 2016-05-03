package gzlazypack.common.util;

/**
 * @类功能说明：XML转义工具
 * @类修改者：
 * @修改日期：2015-1-23下午5:51:29
 * @修改说明：
 * @公司名称：
 * @作者：
 * @创建时间：2015-1-23下午5:51:29
 */
public class XmlEscapeUtils {

	private static final String LT = "&lt;";
	private static final String GT = "&gt;";
	private static final String AMP = "&amp;";
	private static final String QUOT = "&quot;";
	private static final String APOS = "&apos;";

	/**
	 * @方法功能说明：XML转义
	 * @修改者名字：
	 * @修改时间：2015-1-23下午5:51:45
	 * @修改内容：
	 * @参数：@param str
	 * @参数：@return
	 * @return:String
	 * @throws
	 */
	public static String escape(String str) {
		if (str == null)
			return "";
		StringBuilder sb = new StringBuilder();
		char[] cs = str.toCharArray();
		for (char c : cs) {
			switch (c) {
			case '<':
				sb.append(LT);
				break;
			case '>':
				sb.append(GT);
				break;
			case '&':
				sb.append(AMP);
				break;
			case '"':
				sb.append(QUOT);
				break;
			case '\'':
				sb.append(APOS);
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(escape("<哈罗\">"));
	}

}
