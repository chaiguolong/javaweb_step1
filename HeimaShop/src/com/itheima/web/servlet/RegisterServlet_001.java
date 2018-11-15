package com.itheima.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.itheima.domain.User;
import com.itheima.service.UserService_001;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.MailUtils;

public class RegisterServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		request.setCharacterEncoding("UTF-8");

		//获得表单数据
		Map<String,String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			ConvertUtils.register(new Converter(){

				@SuppressWarnings("rawtypes")
				@Override
				public Object convert(Class clazz,Object value){
					//将String 转成date
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date parse = null;
					try {
						parse = format.parse(value.toString());
					} catch(Exception e){
						e.printStackTrace();
					}
					return parse;
				}
			},Date.class);
			//映射封装
			BeanUtils.populate(user,properties);
		} catch(Exception e){
			e.printStackTrace();
		}

		//private String uid
		user.setUid(CommonsUtils.getUUID());
		//private String telephone;
		user.setTelephone(null);
		//private int state;//是否激活
		user.setState(0);
		//private String code;//激活码
		String activeCode = CommonsUtils.getUUID();
		user.setCode(activeCode);

		//将user传递给service层
		UserService_001 service = new UserService_001();
		boolean isRegisterSucces = service.regist(user);

		//是否注册成功
		if(isRegisterSucces){
			//发送激活邮件
			// String emailMsg = "恭喜您注册成功,请点击下面的链接进行激活账户"+
			// 	"<a href='http://localhost:8080/HeimaShop/active?activeCode="+activeCode+"'>"
			// 	+"http://localhost:8080/HeimaShop/active?activeCode="+activeCode+"</a>";
			// try {
			// 	MailUtils.sendMail(user.getEmail(),emailMsg);
			// } catch(Exception e){
			// 	e.printStackTrace();
			// }

			//跳转到注册成功页面
			response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
		}else{
			//跳转到失败的提示页面
			response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
		}


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
