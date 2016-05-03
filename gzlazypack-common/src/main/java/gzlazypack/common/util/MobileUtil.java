package gzlazypack.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileUtil {
	
	/**  
     * 验证手机号码  
     * @param mobiles  
     * @return  [0-9]{5,9}  
     */  
    public static boolean isMobileNO(String mobiles){  
     boolean flag = false;  
     try{  
      Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
      Matcher m = p.matcher(mobiles);  
      flag = m.matches();  
     }catch(Exception e){  
      flag = false;  
     }  
     return flag;  
    }  

}
