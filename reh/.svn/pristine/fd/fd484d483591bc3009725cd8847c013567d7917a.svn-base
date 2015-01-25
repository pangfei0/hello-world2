/**   
* @Title: StringUtil.java 
* @Package com.ree.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月30日 下午8:32:37 
* @version  
*/
package com.ree.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @ClassName: StringUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月30日 下午8:32:37 
 *  
 */
public class StringUtil {
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            //Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        	Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
