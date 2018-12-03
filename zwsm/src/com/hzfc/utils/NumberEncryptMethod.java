package com.hzfc.utils;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class NumberEncryptMethod implements TemplateMethodModel{

	@SuppressWarnings("unchecked")
	public Object exec(List args) throws TemplateModelException {
		//数字ftl模板里加密成样式
		String val = args.get(0).toString();
		if(val != null && !"".equals(val)){
			val = val.replaceAll("1", "<span class=\"numbone\"></span>");
			val = val.replaceAll("2", "<span class=\"numbtwo\"></span>");
			val = val.replaceAll("3", "<span class=\"numbthree\"></span>");
			val = val.replaceAll("4", "<span class=\"numbfour\"></span>");
			val = val.replaceAll("5", "<span class=\"numbfive\"></span>");
			val = val.replaceAll("6", "<span class=\"numbsix\"></span>");
			val = val.replaceAll("7", "<span class=\"numbseven\"></span>");
			val = val.replaceAll("8", "<span class=\"numbeight\"></span>");
			val = val.replaceAll("9", "<span class=\"numbnine\"></span>");
			val = val.replaceAll("0", "<span class=\"numbzero\"></span>");
			val = val.replaceAll("\\.", "<span class=\"numbdor\"></span>");
		}
		else {
			val = "";
		}
		
		return val;
	}

}
