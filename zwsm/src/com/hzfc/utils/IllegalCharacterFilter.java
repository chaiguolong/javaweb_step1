package com.hzfc.utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class IllegalCharacterFilter implements Filter {
 
 private String[] characterParams = null;
 private boolean OK=true;
 
 public void destroy() {
  // TODO Auto-generated method stub
 }
 /**
  * 此程序块主要用来解决参数带非法字符等过滤功能
  */
 public void doFilter(ServletRequest request, ServletResponse response,
   FilterChain arg2) throws IOException, ServletException {
 
  HttpServletRequest servletrequest = (HttpServletRequest) request;
  HttpServletResponse servletresponse = (HttpServletResponse) response; 
  boolean status = false;  
  
  //java 获取请求 URL   
  String   url  =servletrequest.getRequestURL().toString();
  if(url.toLowerCase().indexOf("/esf")>=0||url.toLowerCase().indexOf("/super")>=0||url.toLowerCase().indexOf("/ckeditor")>=0){
	  	//排除后台请求
	  arg2.doFilter(request, response);
  }else{
	  for(int i=0;i<characterParams.length;i++){
	      if (url.toLowerCase().indexOf(characterParams[i]) >= 0) {
	       status = true;
	       break;
	      }
	  }
	  
	   java.util.Enumeration params = request.getParameterNames();
	   String param="";
	   String paramValue = "";
	   servletresponse.setContentType("text/html");
	   servletresponse.setCharacterEncoding("utf-8");
	   while (params.hasMoreElements()) {
	    param = (String) params.nextElement();
	   // if(!"newsContent.content".equals(param)&&!"newsContent.descr".equals(param)&&!"newsContent.title".equals(param)){
	    	for(int i=0;i<characterParams.length;i++){
	            if (param.toLowerCase().indexOf(characterParams[i]) >= 0) {
	             status = true;
	             break;
	            }
	        }
	        String[] values = request.getParameterValues(param);
	        paramValue = "";
	        if(OK){//过滤字符串为0个时 不对字符过滤
	        for (int i = 0; i < values.length; i++)
	          paramValue=paramValue+values[i].toLowerCase();
	        for(int i=0;i<characterParams.length;i++)
	         if (paramValue.indexOf(characterParams[i]) >= 0) {
	          status = true;
	          break;
	         }
	        if(status)break;
	        }
	    }
	    //}
	   
		   System.out.println(param+"="+paramValue+";");
		   if (status) {
		    PrintWriter out = servletresponse.getWriter();
		    out.print("<script language='javascript'>alert(\"您提交的相关表单数据字符含有非法字符 。"+paramValue+"\");</script>");
		   }else{
		   arg2.doFilter(request, response);
		   }
  }
 
  
 }
 
 
 
 public void init(FilterConfig config) throws ServletException {
  if(config.getInitParameter("characterParams").length()<1)
   OK=false;
  else
  this.characterParams = config.getInitParameter("characterParams").split(",");
 }
}
