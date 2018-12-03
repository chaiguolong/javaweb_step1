package com.itheima.web.servlet;
import com.itheima.domain.User;
import com.google.gson.Gson;
import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService_002;
import com.itheima.utils.JedisPoolUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import redis.clients.jedis.Jedis;


public class ProductServlet_002 extends BaseServlet_002{
	private static final long serialVersionUID = -345341231532346L;

	//提交订单
	public void submitOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();

		//判断用户是否已经登录 未登录下面代码不执行
		User user = new User();


	}
	//清空购物车
	public void clearCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("cart");

		//跳转回cart_002.jsp
		response.sendRedirect(request.getContextPath()+"/cart_002.jsp");
	}

	//删除单一商品
	public void delProFromCart(HttpServletRequest request ,HttpServletResponse response) throws ServletException,IOException{
		//获得要删除的item的pid
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null){
			Map<String,CartItem> cartItems = cart.getCartItems();
			//需要修改总价
			cart.setTotal(cart.getTotal() - cartItems.get(pid).getSubtotal());
			//删除
			cartItems.remove(pid);
			cart.setCartItems(cartItems);
		}

		session.setAttribute("cart",cart);

		//跳转回cart_002.jsp
		response.sendRedirect(request.getContextPath()+"/cart_002.jsp");
	}

	//添加商品到购物车
	public void addProductToCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();

		ProductService_002 service = new ProductService_002();

		//获得要放到购物车的商品的pid
		String pid = request.getParameter("pid");
		//获得该商品的购买数量
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));
		//获得product对象
		Product product = service.findProductByPid(pid);
		//计算小计
		double subtotal = product.getShop_price()*buyNum;
		//封装cartItem
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);

		//获得购物车---判断是否在session中已经存在购物车
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}

		//将购物项放到车中---key是pid
		//先判断购物车中是否已包含此购物项了 --- 判断key是否已经存在
		//如果购物车中已经存在该商品--- 将现在买的数量与原有的数量进行相加操作
		Map<String,CartItem> cartItems = cart.getCartItems();

		double newsubtotal = 0.0;
		if(cartItems.containsKey(pid)){
			//取出原有商品的数量
			CartItem cartItem = cartItems.get(pid);
			int oldBuyNum = cartItem.getBuyNum();
			oldBuyNum += buyNum;
			cartItem.setBuyNum(oldBuyNum);
			cart.setCartItems(cartItems);
			//修改小计
			//修改该商品的小计
			double oldsubtotal = cartItem.getSubtotal();
			//新买的商品的小计
			newsubtotal = buyNum*product.getShop_price();
			cartItem.setSubtotal(oldsubtotal + newsubtotal);
		}else{
			//如果购物车没有该商品
			cart.getCartItems().put(product.getPid(),item);
			newsubtotal = buyNum*product.getShop_price();
		}

		//计算总计
		double total = cart.getTotal()+newsubtotal;
		cart.setTotal(total);

		//将车再次访问session
		session.setAttribute("cart",cart);

		//直接跳转到购物车页面
		response.sendRedirect(request.getContextPath()+"/cart_002.jsp");

	}

	//显示商品的详细信息功能
	public void productInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//获得当前页
		String currentPage = request.getParameter("currentPage");
		//获得商品类别
		String cid = request.getParameter("cid");
		//获得要查询的商品的pid
		String pid = request.getParameter("pid");

		ProductService_002 service = new ProductService_002();

		Product product = service.findProductByPid(pid);

		request.setAttribute("product",product);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("cid",cid);

		//获得客户端携带cookie--获得名字是pids的cookie
		String pids = pid;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if("pids".equals(cookie.getName())){
					pids = cookie.getValue();
					String[] split = pids.split("-");
					List<String> asList = Arrays.asList(split);
					LinkedList<String> list = new LinkedList<String>(asList);
					//判断集合中是否存在当前pid
					if(list.contains(pid)){
						//包含当前查看商品的pid
						list.remove(pid);
						list.addFirst(pid);
					}else{
						//不包含当前查看商品的pid 直接将该pid放到头上
						list.addFirst(pid);
					}

					//将[3,2,1]转成3-1-2字符串
					StringBuffer sb = new StringBuffer();
					for(int i = 0;i<list.size()&&i<7;i++){
						sb.append(list.get(i));
						sb.append("-");
					}

					//去掉3-1-2-后的-
					pids = sb.substring(0,sb.length()-1);

				}
			}
		}

		Cookie cookie_pids = new Cookie("pids",pids);
		response.addCookie(cookie_pids);
		request.getRequestDispatcher("/product_info_002.jsp").forward(request,response);

	}

	//根据商品的类别获得商品的列表
	@SuppressWarnings("rawtypes")
	public void productList(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		

		//获得cid
		String cid = request.getParameter("cid");
		
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null) currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 12;

		ProductService_002 service = new ProductService_002();
		PageBean pageBean = service.findProductListByCid(cid,currentPage,currentCount);

		request.setAttribute("pageBean",pageBean);
		request.setAttribute("cid",cid);

		//定义一个记录历史商品信息的集合
		List<Product> historyProductList = new ArrayList<Product>();

		//获得客户端携带名字叫pids的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if("pids".equals(cookie.getName())){
					String pids = cookie.getValue();
					String[] split = pids.split("-");
					for (String pid : split) {
						Product pro = service.findProductByPid(pid);
						historyProductList.add(pro);
					}
				}
			}
		}

		//将历史记录的集合放到域中
		request.setAttribute("historyProductList",historyProductList);

		request.getRequestDispatcher("/product_list_002.jsp").forward(request,response);
	}



	//显示商品类别的功能
	public void categoryList(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		ProductService_002 service = new ProductService_002();

		//先从缓存中查询categoryList 如果有直接使用,没有再从数据库中查询 存到缓冲
		//1.获得jedis对象 连接redis数据库
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryListJson = jedis.get("categoryListJson");
		//2.判断categoryListJson是否为空
		if(categoryListJson == null){
			System.out.println("缓存没有数据,查询数据库");
			//准备分类数据
			List<Category> categoryList = service.findAllCategory();
			Gson gson = new Gson();
			categoryListJson = gson.toJson(categoryList);
			jedis.set("categoryListJson",categoryListJson);
		}

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);



	}

	//显示首页的功能
	//显示商品的类别的功能
	public void index(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		ProductService_002 service = new ProductService_002();

		//准备热门商品---List<Product>
		List<Product> hotProductList = service.findHotProductList();

		//准备最新商品---List<Product>
		List<Product> newProductList = service.findNewProductList();


		request.setAttribute("hotProductList",hotProductList);
		request.setAttribute("newProductList",newProductList);

		System.out.println(newProductList.get(1).getPname());
		System.out.println(newProductList.get(2).getMarket_price());


		request.getRequestDispatcher("/index_002.jsp").forward(request,response);

	}

}
