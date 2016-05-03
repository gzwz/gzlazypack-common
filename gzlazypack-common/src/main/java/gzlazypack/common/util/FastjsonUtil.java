package gzlazypack.common.util;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * Json 处理类
 * @author xiaobin
 *
 */
public class FastjsonUtil {
	private static SerializeConfig mapping = new SerializeConfig();
	
	static{
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * @param object 将要序列化的对象
	 * @param includesProperties 需要转换的属性
	 * @param excludesProperties 不需要转换的属性
	 * @return
	 */
	public static String toJSONString(Object object, String[] includesProperties, String[] excludesProperties){
		FastjsonFilter filter = new FastjsonFilter();// excludes优先于includes
		if (excludesProperties != null && excludesProperties.length > 0) {
			filter.getExcludes().addAll(Arrays.<String> asList(excludesProperties));
		}
		if (includesProperties != null && includesProperties.length > 0) {
			filter.getIncludes().addAll(Arrays.<String> asList(includesProperties));
		}
		
		// 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd hh24:mi:ss
		// 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
		String json = JSON.toJSONString(object, filter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);

		return json;
	}
	
	/**
	 * 
	 * 序列化对象  将null 转换为  "" 输出
	 * 
	 * @param object 将要序列化的对象
	 * @param includesProperties 需要转换的属性
	 * @param excludesProperties 不需要转换的属性
	 * @return
	 */
	public static String toJSONStringNotNull(Object object, String[] includesProperties, String[] excludesProperties){
		FastjsonFilter fastjsonFilter = new FastjsonFilter();// excludes优先于includes
		if (excludesProperties != null && excludesProperties.length > 0) {
			fastjsonFilter.getExcludes().addAll(Arrays.<String> asList(excludesProperties));
		}
		if (includesProperties != null && includesProperties.length > 0) {
			fastjsonFilter.getIncludes().addAll(Arrays.<String> asList(includesProperties));
		}
		
		//将null 转换为  "" 输出
		ValueFilter valueFilter = new ValueFilter(){
            public Object process(Object source, String name, Object value) {  
                if (null != value) {
        			if (value instanceof java.util.Date) {
        				return String.format("%1$tF %1tT", value);
        			}
        			return value;
        		} else {
        			return "";
        		}
            }  
        };  
        
        SerializeFilter[] filters = {fastjsonFilter, valueFilter};
		// 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd hh24:mi:ss
		// 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
		String json = JSON.toJSONString(object, fastjsonFilter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
		return json;
	}
	
	/**
	 * 
	 * 序列化对象  将null 转换为  "" 输出
	 * 
	 * @param object 将要序列化的对象
	 * @param includesProperties 需要转换的属性
	 * @param excludesProperties 不需要转换的属性
	 * @return
	 */
	public static String toJSONStringNotNull(Object object){
		//将null 转换为  "" 输出
		ValueFilter valueFilter = new ValueFilter(){
            public Object process(Object source, String name, Object value) {  
                if (null != value) {
        			if (value instanceof java.util.Date) {
        				return String.format("%1$tF %1tT", value);
        			}
        			return value;
        		} else {
        			return "";
        		}
            }  
        };  
//		return JSON.toJSONString(object, valueFilter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
        return JSON.toJSONString(object, valueFilter, SerializerFeature.WriteDateUseDateFormat);
	}
	
	
	public static String toJSONStringNotNullQuery(Object object){
		//将null 转换为  "" 输出
		ValueFilter valueFilter = new ValueFilter(){
            public Object process(Object source, String name, Object value) {  
                if (null != value) {
        			if (value instanceof java.util.Date) {
        				return String.format("%1$tF %1tT", value);
        			}
        			return value;
        		} else {
        			return "";
        		}
            }  
        };  
	return JSON.toJSONString(object, valueFilter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
//	return JSON.toJSONString(object, valueFilter, SerializerFeature.WriteDateUseDateFormat);
	}
	


	public static void main(String[] args) {
//		List list = new ArrayList();
//		for (int i = 0; i <= 20; i++) {
//			Map m = new HashMap();
//			m.put(String.valueOf(i), null);
//			m.put("date", new Date(System.currentTimeMillis()));
//			list.add(m);
//		}
//		
//		System.out.println(toJSONStringNotNull(list, null, null));
	}

	


}
