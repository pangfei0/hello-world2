/**   
* @Title: maintenenceModeFilter.java 
* @Package com.ree.filter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年11月1日 上午2:22:30 
* @version  
*/
package com.ree.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @ClassName: maintenenceModeFilter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年11月1日 上午2:22:30 
 *  
 */
public class maintenenceModeFilter implements Filter {
	private FilterConfig config; // 这个东西好，可以从配置文件里面读，就是读的filter里面那个参数  
    public void destroy() {  
        config = null;  
    }  
    public void doFilter(ServletRequest paramServletRequest,  
            ServletResponse paramServletResponse, FilterChain paramFilterChain)  
            throws IOException, ServletException {  
        HttpServletRequest request = (HttpServletRequest) paramServletRequest;// 强制转换  
        HttpServletResponse response = (HttpServletResponse) paramServletResponse;// 强制转换  
//        if("1".equals(config.getInitParameter("use")))
//        	response.sendRedirect("maintenanceMode.jsp");// 过滤完之后跳转，这样跳转是从定向，客户端跳转  
        if("1".equals(config.getInitParameter("use"))&&!request.getRequestURI().contains("dwz")
        		&&!request.getRequestURI().contains("css")&&!request.getRequestURI().contains("scripts"))
        {
        	 RequestDispatcher rd = request.getRequestDispatcher("maintenanceMode.jsp");   //request的重定位，服务端跳转 
             rd.forward(request, response); 
        }   
        else
        	paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
    }  
    public void init(FilterConfig paramFilterConfig) throws ServletException {  
        this.config = paramFilterConfig;  
    }  
}
