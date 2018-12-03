package com.hzfc.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TmsfPageTag extends BodyTagSupport {

	private static final long serialVersionUID = 677734752811372487L;
	
	private static final String ATTRIBUTE_VALUE = "attributeValue";//属性
	
	private static final String WEB_TOTAL_TOOLS = "webtotaltools";//网站统计工具
	
	private static final String WEB_KEYWORDS = "webkeywords";//关键字
	
	private static final String WEB_DESCRIPTION = "webdescription";//网站描述

	// 类型属性，决定输出内容

	private String type;

	private String attributeName;

	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int doStartTag() throws JspException {
		String outText = "";//输出内容
		HttpServletRequest request = (HttpServletRequest) pageContext
		.getRequest();
		if(type.equalsIgnoreCase(WEB_KEYWORDS)){
			if(value.equals("xsweb")){
				outText = "房产,萧山房产,房地产,萧山房价,萧山买房,萧山租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("yhweb")){
				outText = "房产,余杭房产,房地产,余杭房价,余杭买房,余杭租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("tlweb")){
				outText = "房产,桐庐房产,房地产,桐庐房价,桐庐买房,桐庐租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("fyweb")){
				outText = "房产,富阳房产,房地产,富阳房价,富阳买房,富阳租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("jdweb")){
				outText = "房产,建德房产,房地产,建德房价,建德买房,建德租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("caweb")){
				outText = "房产,淳安房产,房地产,淳安房价,淳安买房,淳安租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("laweb")){
				outText = "房产,临安房产,房地产,临安房价,临安买房,临安租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else if(value.equals("tzweb")){
				outText = "房产,临安房产,房地产,德清房价,德清买房,德清租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
			else{
				outText = "房产,杭州房产,房地产,杭州房价,杭州买房,杭州租房,新房,二手房,写字楼,商铺,房产新闻,一房一价,透明点评,房价走势";
			}
		}
		else if(type.equalsIgnoreCase(WEB_DESCRIPTION)){
			if(value.equals("xsweb")){
				outText = "萧山透明售房网(xs.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("yhweb")){
				outText = "余杭透明售房网(yh.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("tlweb")){
				outText = "桐庐透明售房网(tl.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("fyweb")){
				outText = "富阳透明售房网(fy.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("jdweb")){
				outText = "建德透明售房网(jd.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("caweb")){
				outText = "淳安透明售房网(ca.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("laweb")){
				outText = "临安透明售房网(la.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else if(value.equals("tzweb")){
				outText = "德清透明售房网(tz.tmsf.com)成立于2013年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
			else {
				outText = "透明售房网(www.tmsf.com)成立于2004年，网站提供权威、即时、准确的商品房、二手房交易数据，发布最新房产资讯、房产政策等内容，是老百姓买房、卖房的重要参考网站。";
			}
		}
		else if(type.equalsIgnoreCase(WEB_TOTAL_TOOLS)){
			String servername = request.getServerName();
			if(servername.indexOf("hzfc") >= 0 
					|| servername.indexOf("tmsf") >= 0){
				StringBuffer str= new StringBuffer();
				//百度统计
				str.append("<script type=\"text/javascript\">");
				str.append("var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");");
				str.append("document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3F5bbc90d068807d82c72909ecd298e11a' type='text/javascript'%3E%3C/script%3E\"));");
				str.append("</script>");
				//站长统计
				str.append("<div style=\"display:none\"><script src=\"http://s96.cnzz.com/stat.php?id=4179430&web_id=4179430\" language=\"JavaScript\"></script></div>");
				
				//百度统计
				str.append("<script type=\"text/javascript\">");
				str.append("var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");");
				str.append("document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3Fbbb8b9db5fbc7576fd868d7931c80ee1' type='text/javascript'%3E%3C/script%3E\"));");
				str.append("</script>");
				
				outText = str.toString();
			}
		}
		else if(type.equalsIgnoreCase(ATTRIBUTE_VALUE)){
			if (request.getAttribute(attributeName) == null) {
				outText = "";
		    }
		    else {
		    	outText = request.getAttribute(attributeName).toString();
		    }
		}
		//页面输入值
		try {
		    pageContext.getOut().write(outText);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
