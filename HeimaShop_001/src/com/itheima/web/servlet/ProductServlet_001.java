package com.itheima.web.servlet;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.domain.User;
import com.itheima.service.ProductService_001;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

@SuppressWarnings("rawtypes")
public class ProductServlet_001 extends BaseServlet{
	private static final long serialVersionUID = -23324535345L;


	//确认订单--更新收货人信息+在线支付
	public void confirmOrder(HttpServletRequest request ,HttpServletResponse response) throws ServletException,IOException{
		//1.更新收货人信息
		Map<String,String[]> properties = request.getParameterMap();
		Order order = new Order();
		try {
			BeanUtils.populate(order,properties);
		} catch(Exception e){
			e.printStackTrace();
		}
		ProductService_001 service = new ProductService_001();
		service.updateOrderAdrr(order);
	}

	//提交订单
	public void submitOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,ParseException{
		HttpSession session = request.getSession();

		//判断用户是否已经登录,未登录下面代码不执行
		User user = (User)session.getAttribute("user");
		if(user==null){
			//没有登录
			response.sendRedirect(request.getContextPath()+"/login_001.jsp");
			return;
		}

		//目的:封装好一个Order对象 传递给service层
		Order order = new Order();

		//1.private String欧弟;//该订单的订单号
		String oid = CommonsUtils.getUUID();
		order.setOid(oid);

		//2.private Date ordertime;//下单时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date_fmt =  sdf.parse(sdf.format(date));
		order.setOrdertime(date_fmt);
		System.out.println(order.getOrdertime());


		//3.private double total;//该订单的总金额
		//获得session中的购物车
		Cart cart =(Cart)session.getAttribute("cart");
		double total = cart.getTotal();
		order.setTotal(total);

		//4.private int state;//订单支付状态 1代表已付款 0 代表未付款
		order.setState(0);

		//5.private String address;//收获地址
		order.setAddress(null);

		//6.private String name;//收货人
		order.setName(null);

		//7.private String telephone;//收获人电话
		order.setTelephone(null);

		//8.private User user;//该订单属于哪个用户
		order.setUser(user);

		//9.该订单中有多少订单项List<OrderItem> orderItems = new ArrayList<OrderItem>();
		//获得购物车中的购物项的集合map
		Map<String,CartItem> cartItems = cart.getCartItems();
		for(Map.Entry<String,CartItem> entry : cartItems.entrySet()){
			//取出每一个购物项
			CartItem cartItem = entry.getValue();
			//创建新的订单项
			OrderItem orderItem = new OrderItem();
			//1)private String itemid;//订单项id
			orderItem.setItemid(CommonsUtils.getUUID());
			//2.private int count;//订单项内商品的购买数量
			orderItem.setCount(cartItem.getBuyNum());
			//3.private double subtotal;//订单项小计
			orderItem.setSubtotal(cartItem.getSubtotal());
			//4.private Product product;//订单项内部的商品
			orderItem.setProduct(cartItem.getProduct());
			//5.private Order order;//该订单项属于哪个订单
			orderItem.setOrder(order);

			//将该订单项添加到订单的订单项集合中
			order.getOrderItems().add(orderItem);
		}
		//order对象封装完毕
		//传递数据到service层
		ProductService_001 service = new ProductService_001();
		service.submitOrder(order);

		session.setAttribute("order",order);

		//页面跳转
		response.sendRedirect(request.getContextPath()+"/order_info_001.jsp");

	}


	//清空购物车
	public void clearCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("cart");

		//跳转回cart.jsp
		response.sendRedirect(request.getContextPath()+"/cart_001.jsp");
	}

	//删除单一商品
	public void delProFromCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//获得要删除的item的pid
		String pid = request.getParameter("pid");
		//删除session中的购物车中的购物项集合中的item
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart!=null){
			Map<String,CartItem> cartItems = cart.getCartItems();
			//需要修改总价
			cart.setTotal(cart.getTotal()-cartItems.get(pid).getSubtotal());
			//删除
			cartItems.remove(pid);
			cart.setCartItems(cartItems);
		}

		session.setAttribute("cart",cart);

		//跳转回cart_001.jsp
		response.sendRedirect(request.getContextPath()+"/cart_001.jsp");
	}

	//将商品添加到购物车
	public void addProductToCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		ProductService_001 service = new ProductService_001();

		//获得要放到购物车的商品的pid
		String pid = request.getParameter("pid");
		//获得该商品的购买数量
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));

		//获得product对象
		Product product = service.findProductByPid(pid);
		//计算小计
		double subtotal = product.getShop_price()*buyNum;
		//封装CartItem
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);

		//获得购物车---判断是否在session中已经存在购物车
		Cart cart =(Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}
		//将购物项放到车中---key是pid
		//先判断购物车中是否已经包含购物项了 ---- 判断key是否已经存在
		//如果购物车中已经存在该商品---将现在买的数量与原有的数量进行相加操作
		Map<String,CartItem> cartItems = cart.getCartItems();

		double newsubtotal = 0.0;

		if(cartItems.containsKey(pid)){
			//取出原有商品的数量
			CartItem cartItem = cartItems.get(pid);
			int oldBuyNum = cartItem.getBuyNum();
			oldBuyNum +=buyNum;
			cartItem.setBuyNum(oldBuyNum);
			cart.setCartItems(cartItems);
			//修改小计
			//原来该商品的小计
			double oldsubtotal = cartItem.getSubtotal();
			//新买的商品的小计
			newsubtotal = buyNum*product.getMarket_price();
			cartItem.setSubtotal(oldsubtotal+newsubtotal);
		}else{
			//如果车中没有该商品
			cart.getCartItems().put(product.getPid(),item);
			newsubtotal = buyNum*product.getShop_price();
		}

		//计算总计
		double total = cart.getTotal()+newsubtotal;
		cart.setTotal(total);

		//将车再次放入session
		session.setAttribute("cart",cart);

		//直接跳转到购物车页面
		response.sendRedirect(request.getContextPath()+"/cart_001.jsp");


	}

	//显示商品的类别的的功能
	public void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService_001 service = new ProductService_001();

		//先从缓存中查询categoryList 如果有直接使用 没有在从数据库中查询 存到缓存中
		//1、获得jedis对象 连接redis数据库
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryListJson = jedis.get("categoryListJson");
		//2、判断categoryListJson是否为空
		if(categoryListJson==null){
			System.out.println("缓存没有数据 查询数据库");
			//准备分类数据
			List<Category> categoryList = service.findAllCategory();
			Gson gson = new Gson();
			categoryListJson = gson.toJson(categoryList);
			jedis.set("categoryListJson", categoryListJson);
		}

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);
	}

	//显示首页的功能
	//显示商品的类别的的功能
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService_001 service = new ProductService_001();

		//准备热门商品---List<Product>
		List<Product> hotProductList = service.findHotProductList();

		//准备最新商品---List<Product>
		List<Product> newProductList = service.findNewProductList();

		//准备分类数据
		//List<Category> categoryList = service.findAllCategory();

		//request.setAttribute("categoryList", categoryList);
		request.setAttribute("hotProductList", hotProductList);
		request.setAttribute("newProductList", newProductList);

		request.getRequestDispatcher("/index_001.jsp").forward(request, response);

	}

	//显示商品的详细信息功能
	public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得当前页
		String currentPage = request.getParameter("currentPage");
		//获得商品类别
		String cid = request.getParameter("cid");

		//获得要查询的商品的pid
		String pid = request.getParameter("pid");

		ProductService_001 service = new ProductService_001();
		Product product = service.findProductByPid(pid);

		request.setAttribute("product", product);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("cid", cid);


		//获得客户端携带cookie---获得名字是pids的cookie
		String pids = pid;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if("pids".equals(cookie.getName())){
					pids = cookie.getValue();
					//1-3-2 本次访问商品pid是8----->8-1-3-2
					//1-3-2 本次访问商品pid是3----->3-1-2
					//1-3-2 本次访问商品pid是2----->2-1-3
					//将pids拆成一个数组
					String[] split = pids.split("-");//{3,1,2}
					List<String> asList = Arrays.asList(split);//[3,1,2]
					LinkedList<String> list = new LinkedList<String>(asList);//[3,1,2]
					//判断集合中是否存在当前pid
					if(list.contains(pid)){
						//包含当前查看商品的pid
						list.remove(pid);
						list.addFirst(pid);
					}else{
						//不包含当前查看商品的pid 直接将该pid放到头上
						list.addFirst(pid);
					}
					//将[3,1,2]转成3-1-2字符串
					StringBuffer sb = new StringBuffer();
					for(int i=0;i<list.size()&&i<7;i++){
						sb.append(list.get(i));
						sb.append("-");//3-1-2-
					}
					//去掉3-1-2-后的-
					pids = sb.substring(0, sb.length()-1);
				}
			}
		}


		Cookie cookie_pids = new Cookie("pids",pids);
		response.addCookie(cookie_pids);

		request.getRequestDispatcher("/product_info_001.jsp").forward(request, response);

	}

	//根据商品的类别获得商品的列表
	public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得cid
		String cid = request.getParameter("cid");

		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 12;

		ProductService_001 service = new ProductService_001();
		PageBean pageBean = service.findProductListByCid(cid,currentPage,currentCount);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cid", cid);

		//定义一个记录历史商品信息的集合
		List<Product> historyProductList = new ArrayList<Product>();

		//获得客户端携带名字叫pids的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("pids".equals(cookie.getName())){
					String pids = cookie.getValue();//3-2-1
					String[] split = pids.split("-");
					for(String pid : split){
						Product pro = service.findProductByPid(pid);
						historyProductList.add(pro);
					}
				}
			}
		}

		//将历史记录的集合放到域中
		request.setAttribute("historyProductList", historyProductList);

		request.getRequestDispatcher("/product_list_001.jsp").forward(request, response);


	}


}
