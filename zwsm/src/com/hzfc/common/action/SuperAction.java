package com.hzfc.common.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.hzfc.utils.TablesNameConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SuppressWarnings("serial")
public class SuperAction extends ActionSupport {

	/**
	 * 获得当前Http Servlet Request
	 */
	public HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	}

	/**
	 * 获得 Http Servlet Response
	 */
	public HttpServletResponse getHttpServletResponse() {
		return (HttpServletResponse) ActionContext.getContext().get((ServletActionContext.HTTP_RESPONSE));
	}

	/**
	 * 获得当前Action 请求路径
	 */
	public String getRequestUrl() {
		return getHttpServletRequest().getRequestURL().toString();
	}

	/**
	 * 获得当前Session
	 */
	public Map getSession() {
		return ActionContext.getContext().getSession();
	}

	/**
	 * 根据指定的页面参数名称，获取页面传递来的参数值
	 * 
	 * @param parameter
	 * @return 单个对象
	 */
	protected Object getParameterValue(String parameter) {
		Object[] parameterArray = getParamenterArray(parameter);
		if (parameterArray != null && parameterArray.length == 1) {
			return parameterArray[0];
		} else {
			return getHttpServletRequest().getAttribute(parameter);
		}
	}

	/**
	 * 根据指定的页面参数名称，获取页面传递来的参数值
	 * 
	 * @param parameter
	 * @return 数组对象
	 */
	protected Object[] getParamenterArray(String parameter) {
		return (Object[]) (ActionContext.getContext().getParameters().get(parameter));
	}

	/**
	 * 向request对象添加attribute
	 * 
	 * @param key
	 * @param value
	 */
	public void setRequestAttribute(String key, Object value) {
		getHttpServletRequest().setAttribute(key, value);
	}

	/**
	 * 从session中取得相应的值
	 * 
	 * @param key
	 * @return
	 */
	public Object getSessionObj(Object key) {
		return getSession().get(key);
	}

	/**
	 * 获得web应用根目录路径
	 * 
	 * @return
	 */
	protected String getWebRootDir() {
		String workDir = getHttpServletRequest().getSession().getServletContext().getRealPath("index.jsp");

		int len = workDir.indexOf("index.jsp");
		workDir = workDir.substring(0, len);

		StringBuffer sb = new StringBuffer();
		sb.append(workDir);

		return sb.toString();
	}

	/**
	 * 设置session
	 * 
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void setSessionObj(Object key, Object value) {
		getSession().put(key, value);
	}

	/**
	 * 封装response用于json输出
	 * 
	 * @param text
	 * @param contentType
	 */
	protected void render(String text, String contentType) {
		try {
			getHttpServletResponse().setContentType(contentType);
			getHttpServletResponse().getWriter().write(text);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 输出Text类型
	 * 
	 * @param response
	 * @param text
	 */
	protected void renderText(String text) {
		render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * 输出Xml
	 * 
	 * @param response
	 * @param text
	 */
	protected void renderXml(String text) {
		render(text, "text/xml;charset=UTF-8");

	}

	/**
	 * 输出Html
	 * 
	 * @param response
	 * @param text
	 */
	protected void renderHtml(String text) {
		render(text, "text/html;charset=UTF-8");
	}

	/**
	 * 获取请求IP来源
	 * 
	 * @return
	 */
	public String getIpAddr() {
		String ip = getHttpServletRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getHttpServletRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getHttpServletRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getHttpServletRequest().getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 传入规格获取缩略图
	 * 
	 * @param path
	 * @param standard
	 * @return
	 */
	public String getScaleImages(String path, String standard) {
		String[] tg = standard.split("\\*");
		int w = Integer.valueOf(tg[0]);
		int h = Integer.valueOf(tg[1]);
		return path.replaceAll("=", "_" + w + "x" + h);
	}
	
	// 校验非法字符
    public boolean checkStr(String str) {
		if (StringUtils.isBlank(str.trim())) {
		    return true;
		}
		String inj_str = "‘,*,%,;,/,+,&,|,(,),$,!,[,]";
		String[] inj_stra = inj_str.split(",");
		for (int i = 0; i < inj_stra.length; i++) {
		    if (str.indexOf(inj_stra[i]) >= 0) {
		    	return true;
		    }
		}
		return false;
    }
    
    /**
     * 判断字符串中是否存在！,<,>,=,?,如果存在以上字符则返回false，否则返回true
     */
    public boolean checkLegal(String str) {
    	// 判断去空格后是否为空前先判断字符串本身是否为空
    	if (StringUtils.isBlank(str)) {
    		return false;
    	}
		if (StringUtils.isBlank(str.trim())) {
		    return false;
		}
    	String inj_str = "!,<,>,=,?";
		String[] inj_stra = inj_str.split(",");
		for (int i = 0; i < inj_stra.length; i++) {
		    if (str.indexOf(inj_stra[i]) >= 0) {
		    	return false;
		    }
		}
		return true;
    }
    
    /**
	 * 返回合法的文字
	 * 
	 * @param str
	 *            需要检验的字符串
	 * @return 返回是否合法,合法返回原字符串，不合法返回404
	 */
	public String filterLegal(String str) {
		//去掉空
		if(StringUtils.isNotBlank(str)){
			str = filterKeyWord(str);
			if (str.matches("[a-zA-Z0-9_\u4e00-\u9fa5]*")) {
				// 不是非法字符
				return str;
			}
		}else{
			return "";
		}
		return "404";
	}
	
	/**
	 * 过滤可以被注入的脚本字符
	 * @param myStr
	 * @return
	 */
	public String filterStr(String myStr) {
		if(StringUtils.isNotBlank(myStr)){
			/**
			 * 添加括号转义字符过滤
			 */
			myStr=myStr.replaceAll("\\(", "");
			myStr=myStr.replaceAll("\\)", "");
			myStr=myStr.replaceAll("=", "");
			myStr=myStr.replaceAll("\"", "");
			myStr=myStr.replaceAll("&quot;", "");
			myStr=myStr.replaceAll("<", "");
			myStr=myStr.replaceAll("&lt;", "");
			myStr=myStr.replaceAll(">", "");
			myStr=myStr.replaceAll("&gt;", "");
			myStr=myStr.replaceAll("&", "");
			myStr=myStr.replaceAll("&amp;", "");
		}
		return myStr;
	}
	
	/**
	 * 过滤可以关键字注入sql语句
	 * @param myStr
	 * @return
	 */
	public String filterKeyWord(String myStr) {
		if(StringUtils.isNotBlank(myStr)){
			/**
			 * sql注入里用到的符号过滤掉
			 */
			myStr=myStr.replaceAll("\\(", "");
			myStr=myStr.replaceAll("\\)", "");
			myStr=myStr.replaceAll("=", "");
			myStr=myStr.replaceAll(",", "");
			myStr=myStr.trim();
		}
		return myStr;
	}

	/**
	 * 从根目录开始取路径，用于ftl里适用include指令
	 * 
	 * @param modelObj
	 *            信息实体类
	 * @param templateFile
	 *            信息实体类
	 * @param saveFile
	 *            保存文件路径
	 */
	public boolean GenerateHtmlWithRootPath(Map<String, Object> rootMap, String templateFile, String saveFile) {
		FileOutputStream outStream = null;
		try {

			File objSaveFile = new File(saveFile);
			if (!objSaveFile.getParentFile().exists()) {
				objSaveFile.getParentFile().mkdirs();
			}
			//File objTemplateFile = new File(templateFile);
			String rootpath = getWebRootDir();
			Configuration cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File(rootpath));//设置根目录为起始
			Template template = cfg.getTemplate(templateFile.substring(rootpath.length()), "UTF-8");//过滤根目录
			template.setEncoding("UTF-8");
			outStream = new FileOutputStream(objSaveFile);
			OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
			BufferedWriter sw = new BufferedWriter(writer);
			// 模板引擎解释模板
			template.process(rootMap, sw);
			sw.flush();
			sw.close();
			outStream.close();
			return true;
		} catch (TemplateException ex) {
			return false;
		} catch (IOException ex) {
			return false;
		} finally {
			try {
				outStream.close();
			} catch (IOException ex) {
			}
		}
	}
	

	/**
	 * 为message提供生成静态页面的方法
	 * 
	 * @param modelObj
	 *            信息实体类
	 * @param templateFile
	 *            信息实体类
	 * @param saveFile
	 *            保存文件路径
	 */
	public boolean GenerateHtml(Map<String, Object> rootMap, String templateFile, String saveFile) {
		FileOutputStream outStream = null;
		try {

			File objSaveFile = new File(TablesNameConstants.WEB_ROOT + saveFile);
			if (!objSaveFile.getParentFile().exists()) {
				objSaveFile.getParentFile().mkdirs();
			}
			File objTemplateFile = new File(TablesNameConstants.WEB_ROOT + templateFile);
			Configuration cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(objTemplateFile.getParentFile());
			Template template = cfg.getTemplate(objTemplateFile.getName(), "UTF-8");
			template.setEncoding("UTF-8");
			outStream = new FileOutputStream(objSaveFile);
			OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
			BufferedWriter sw = new BufferedWriter(writer);
			// 模板引擎解释模板
			template.process(rootMap, sw);
			sw.flush();
			sw.close();
			outStream.close();
			return true;
		} catch (TemplateException ex) {
			ex.printStackTrace();
			return false;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				outStream.close();
			} catch (IOException ex) {
			}
		}
	}

}
