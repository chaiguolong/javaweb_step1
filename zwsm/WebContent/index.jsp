<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三门县房地产管理处</title>
<link href="/css/css.css" rel="stylesheet" type="text/css"/>
<link href="/css/head.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/slide.js"></script>
<script type="text/javascript" src="/js/lzgg.js"></script>
<script type="text/javascript" src="/js/jquery.KinSlideshow-1.2.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.bgiframe.js"></script>
<script type="text/javascript">
	var n=6;
	for(var i=1; i<=n; i++){
		switchtag(i);
	}
	function switchtag(x){
    	$(document).ready(function(){
   		    $("#myCont" + x + " > div:not(:first)").hide();
		    var myLi = $("#myTop" + x + " > ul > li");
		    var myDiv =$("#myCont" + x + " > div");
			    myLi.each(function(i){
			       $(this).mouseover(function(){
			         myLi.removeClass("hover");
			          $(this).addClass("hover");
			           myDiv.hide();
			           myDiv.eq(i).show();
       			})
  		    })
    	})
	}
	
	function setTab(name,cursel,n){
		for(i=1;i<=n;i++){
			var nav=document.getElementById(name+i);
			var conlist=document.getElementById("con_"+name+"_"+i);
			nav.className=i==cursel?"hover":"";
			conlist.style.display=i==cursel?"block":"none";
		}
	}
	
	function hzfcgov(thisObj,Num){
		if(thisObj.className == "active")return;
		var tabObj = thisObj.parentNode.id;
		var tabList = document.getElementById(tabObj).getElementsByTagName("li");
		for(i=0; i <tabList.length - 1; i++) {
			if (i == Num)
			{
				thisObj.className = "active";
				document.getElementById(tabObj+"_Content"+i).style.display = "block";
			}else{
				tabList[i].className = "normal";
				document.getElementById(tabObj+"_Content"+i).style.display = "none";
			}
		}
	}
	
	function showdate() {
		var mydate = new Date();
		var myweekday = mydate.getDay();
		var mymonth = mydate.getMonth()+1;
		var myday = mydate.getDate();
		myyear = mydate.getFullYear();
		document.getElementById("showdate").innerHTML = myyear + "年" + mymonth + "月" + myday + "日    " + "星期" + getWeekday(myweekday);
	}
	function getWeekday(no) {
		if(no == 1) return "一";
		if(no == 2) return "二";
		if(no == 3) return "三";
		if(no == 4) return "四";
		if(no == 5) return "五";
		if(no == 6) return "六";
		return "日";
	}
	$(function(){
		$("#KinSlideshow").KinSlideshow({
			isHasTitleBar:false,
				moveStyle:"up",
				isHasTitleFont:false,
				titleBar:{titleBar_height:30,titleBar_bgColor:"#000000",titleBar_alpha:0.5},
				btn:{
					btn_bgColor:"#FFFFFF",btn_bgHoverColor:"#ff6600",btn_fontColor:"#000000",
	                btn_fontHoverColor:"#FFFFFF",btn_borderColor:"#cccccc",
	                btn_borderHoverColor:"#cccccc",
	                btn_borderWidth:1
                }
		});
	})
	function dosubmit() {
		document.search.submit();
	}
	$(function(e){
	 $('.TipsContent').bgiframe();
	})
</script>
</head>
<body>
<div class="header">
	<img src="images/zxtop.jpg" width="950" height="102" />
</div>
<div class="nav">
	<ul id="menu">
		<li class="mainlevel"><div class="title"><a href="/index.jsp" target="_blank">网站首页</a></div>
			<ul id="sub_02" class="TipsContent">
			</ul>
		</li>
		<li class="mainlevel"><div class="title">政务公开</div>
			<ul id="sub_02" class="TipsContent">
					<li><a href="law.jspx" target="_blank">政策法规</a></li>
					<li><a href="agency.jspx" target="_blank">机构信息</a></li>
			</ul>
		</li>
		<li class="mainlevel"><div class="title">网上办事</div>
			<ul id="sub_02" class="TipsContent">
					<li><a href="newslist.jspx?categoryid=12" target="_blank">表格下载</a></li>
					<li><a href="newslist.jspx?categoryid=11" target="_blank">办事指南</a></li>
			</ul>
		</li>
		<li class="mainlevel"><div class="title">房管资讯</div>
			<ul id="sub_02" class="TipsContent">
					<li><a href="/newslist.jspx?categoryid=28027158" target="_blank">白蚁防治</a></li>
					<li><a href="newslist.jspx?categoryid=14" target="_blank">公示公告</a></li>
					<li><a href="newslist.jspx?categoryid=13" target="_blank">房管快讯</a></li>
			</ul>
		</li>
		<li class="mainlevel"><div class="title"><a href="http://www.tmsf.com/tlweb/" target="_blank">透明售房</a></div>
			<ul id="sub_02" class="TipsContent">
					<li>二手房</li>
					<li>商品房</li>
			</ul>
		</li>
		<li class="mainlevel"><div class="title"><a href="/newslist.jspx?categoryid=28025489" target="_blank">下载中心</a></div>
			<ul id="sub_02" class="TipsContent">
			</ul>
		</li>
		<li class="mainlevel">
			<a href="/bzcx.jspx" target="_blank">信息查询</a>
			<ul id="sub_02"></ul>
		</li>
		<div class="clear"></div>
	</ul>
</div>

<div class="topsearch">
 <table width="100%" height="30" border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td width="8"></td>
	<td width="200"><div class="c" id="showdate">2011年11月20日 星期日</div><script type="text/javascript">showdate();</script></td>
	<td width="415"><div class="d"><marquee onMouseOver="this.stop()" onMouseOut="this.start()"  scrolldelay="120">
		<a href="news.jspx?contentid=28026936&categoryid=13" target="_blank" title="县房管处OA办公系统正式上线运行" class="main">
		县房管处OA办公系统正式上线运行</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28026818&categoryid=13" target="_blank" title="上门服务  情系群众" class="main">
		上门服务  情系群众</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28026989&categoryid=13" target="_blank" title="加强物管知识宣传 促进和谐小区建设" class="main">
		加强物管知识宣传 促进和谐小区建设</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28024904&categoryid=13" target="_blank" title="市建设局专家组对我县申报市级物业管理 示范（优秀）住宅小区进行考评" class="main">
		市建设局专家组对我县申报市级物业管理 示范（优秀）住宅小区进行考评</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28025095&categoryid=13" target="_blank" title="庆中秋、迎国庆，房管慰问进基层" class="main">
		庆中秋、迎国庆，房管慰问进基层</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28025087&categoryid=13" target="_blank" title="房管窗口上门服务暖人心" class="main">
		房管窗口上门服务暖人心</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28025091&categoryid=13" target="_blank" title="县房管处加强高温天气物业服务 防范应对工作" class="main">
		县房管处加强高温天气物业服务 防范应对工作</a>&nbsp;&nbsp;&nbsp;
		<a href="news.jspx?contentid=28025039&categoryid=13" target="_blank" title="规范中介机构行为  促进行业信用新建设" class="main">
		规范中介机构行为  促进行业信用新建设</a>&nbsp;&nbsp;&nbsp;
	</marquee></div></td>
	<td><div class="f">
	<form action="/search.jspx" method="post"  name="search" id="search" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<td width="85">
	<select name="type" id="select_type" style="width:80px; height:20px; border:1px solid #766b4f; color:#4c4c4c; margin:0; padding-top:2px; z-index:-50;">
		<option value='all' style='z-index:-50' >全站搜索</option>
		</select>
	</td>
	<td width="105"><input type="text" class="input_n_out" id="keyword" name="keyword" size="12"  title="请勿包含英文引号，双引号，斜号，反斜号"/></td>
	<td width="45"><input name="" type="button" class="input_btn" onclick="dosubmit();"/></td>
	</tr>
	</table>
	</form>
	</div>
	</td>
  </tr>
 </table>
</div>
<div class="hg"></div>
<div class="xscontent">
	<div class="left">
		<div class="box1">
			<div class="left2">
				<dl>
					<dt>公示公告</dt>
					<dd>
						<ul>
							<li class= "b"><a href="/agency.jspx">机构职能</a></li>
							<li class= "b"><a href="/law.jspx">政策法规</a></li>
							<li class= "b"><a href="/newslist.jspx?categoryid=11">办事指南</a></li>
							<li class= "b"><a href="/newslist.jspx?categoryid=12">表格下载</a></li>
						</ul>
					</dd>
				</dl>
			</div>
			<div class="left5">
				<h1><a href="newslist.jspx?categoryid=13" title="房管资讯">更多>></a>房管资讯</h1>
				<div class="hotleft">
					<div class="hotpic">
						<div id="KinSlideshow" style="visibility:hidden;">
  						</div>
					</div>
				</div>
				<div class="hotnews">
					<ul>
								<li class="zi">
									<a href="news.jspx?contentid=28026936&categoryid=13" target="_blank" title="县房管处OA办公系统正式上线运行">
									<font color=#ff0306>县房管处OA办公系统正式上线运行</font>
									</a>
									</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28026818&categoryid=13" target="_blank" title="上门服务  情系群众">
									上门服务  情系群众</a>
									<span style="float:right">[2013-10-31]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28026989&categoryid=13" target="_blank" title="加强物管知识宣传 促进和谐小区建设">
									加强物管知识宣传 促进和谐小区建</a>
									<span style="float:right">[2013-10-21]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28024904&categoryid=13" target="_blank" title="市建设局专家组对我县申报市级物业管理 示范（优秀）住宅小区进行考评">
									市建设局专家组对我县申报市级物业</a>
									<span style="float:right">[2013-10-12]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28025095&categoryid=13" target="_blank" title="庆中秋、迎国庆，房管慰问进基层">
									庆中秋、迎国庆，房管慰问进基层</a>
									<span style="float:right">[2013-09-18]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28025087&categoryid=13" target="_blank" title="房管窗口上门服务暖人心">
									房管窗口上门服务暖人心</a>
									<span style="float:right">[2013-09-13]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28025091&categoryid=13" target="_blank" title="县房管处加强高温天气物业服务 防范应对工作">
									县房管处加强高温天气物业服务 防</a>
									<span style="float:right">[2013-08-15]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28025039&categoryid=13" target="_blank" title="规范中介机构行为  促进行业信用新建设">
									规范中介机构行为  促进行业信用</a>
									<span style="float:right">[2013-07-15]</span>
								</li>
									<li>
									<font color="855c02"></font>
									<a href="news.jspx?contentid=28025031&categoryid=13" target="_blank" title="我县首例物业纠纷诉调对接案例开庭">
									我县首例物业纠纷诉调对接案例开庭</a>
									<span style="float:right">[2013-07-12]</span>
								</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="box2">
			<div class="left3">
				<dl>
					<dt>
						<span><a href="/bzcx.jspx" target="_blank">我要查询</a></span>房产领证公告
					</dt>
					<dd>
						<marquee style="WIDTH: 97%; HEIGHT: 250px" scrollamount="1" direction="up" onMouseOver="this.stop()" onMouseOut="this.start()"  >
							<table width="97%" border="0">
							<script type="text/javascript">document.write(getLzgg());</script>
							</table>
						</marquee>
					</dd>
				</dl>
			</div>
			<div class="left4">
				<dl>
					<dt class="divTop" id="myTop1">
						<ul>
							<li  class="hover">通知公告</li>
							<li>公示文件</li>
						</ul> 
					</dt>
					<dd id="myCont1">
						<div>
							<ul>
								<table width="97%" border="0">
								</table>
							</ul>
						</div>
						<div>
							<ul>
								<table width="97%" border="0">
											<tr height="25">
												<td align="left">&middot;<a href="news.jspx?contentid=28025490&categoryid=14" title="市住房和城乡建设局关于在物业管理区域内 建立物业服务公示制度的通知">市住房和城乡建设局关于在物业管理区域内 建</a></td>
												<td align="right">[2013-10-25]</td>
											</tr>
								</table>
							</ul>
						</div>
					</dd> 
				</dl>
			</div>
		</div>
	</div>
	<div class="right">
		<!--
		<div class="box7">
			<dt>白蚁防治</dt>
			<dd>
				<ul>
			            	<div>
								<p>
										
					            		<a href="/news.jspx?contentid=28027159&categoryid=28027158" target="_blank" title="白蚁防治1111">
										<font color="#1e8ebc">[查看详情]</font></a>
			            		</p>
							</div>
					<li><a href="" target="_blank">白蚁防治</a></li>
					<li><a href="" target="_blank">税费计算</a></li>
					<li><a href="http://www.tzgjj.gov.cn/" target="_blank">公积金查询</a></li>
					<li><a href="" target="_blank">合同备案</a></li>
				</ul>
			</dd>
		</div>
		-->
		<div class="box8">
			<dt>
				<span><a href="newslist.jspx?categoryid=28027158" target="_blank">更多&gt;&gt;</a></span>
				白蚁防治
			</dt>
			<dd>
				<ul>
							<li><a href='news.jspx?contentid=28027159&categoryid=28027158' target="_blank" title="白蚁防治1111">
								白蚁防治1111
							</a></li>
				</ul>
			</dd>
		</div>
		<div class="box8">
			<dt>
				<span><a href="/editcomplaint.jspx" target="_blank">我要投诉咨询</a></span>
				投诉常见问题
			</dt>
			<dd>
				<ul>
						<li><a href='/complaint.jspx?complaintid=28027226' target="_blank" title="这是什么">这是什么</a></li>
						<li><a href='/complaint.jspx?complaintid=28027225' target="_blank" title="阿斯蒂芬">阿斯蒂芬</a></li>
						<li><a href='/complaint.jspx?complaintid=28025522' target="_blank" title="房产">房产</a></li>
						<li><a href='/complaint.jspx?complaintid=28024914' target="_blank" title="HH">HH</a></li>
						<li><a href='/complaint.jspx?complaintid=28023071' target="_blank" title="咨询退房事宜">咨询退房事宜</a></li>
						<li><a href='/complaint.jspx?complaintid=28022938' target="_blank" title="启城不诚信，降低楼盘品质">启城不诚信，降低楼盘品质</a></li>
						<li><a href='/complaint.jspx?complaintid=28022905' target="_blank" title="闲林-竹海水韵-骗子公司">闲林-竹海水韵-骗子公司</a></li>
						<li><a href='/complaint.jspx?complaintid=28022878' target="_blank" title="工程进度">工程进度</a></li>
				</ul>
			</dd>
		</div>
	</div>
</div>
<div class="guanggao"><img src="images/xsadminad01.jpg" width="950" height="65"></div>
<div class="hg1"></div>
<div class="chjiao">
	<div class="box4">
		<dl>
			<dt>
				<div>
					<ul>
						<li style="width: 50%">
							今日成交
						</li>
						<li style="width: 50%">
							上月成交
						</li>
					</ul>
				</div>
			</dt>
			<dd>
				<table width="946px" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td width="472">
								<table width="470px" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr height="25">
											<td bgcolor="#f9f4f1" colspan="3" style="text-indent: 15px;">
												商品房
											</td>
										</tr>
										<tr style="font-weight: bold" height="33">
											<td width="40%" style="text-indent: 15px">
												城区
											</td>
											<td width="30%">
												交易套数
											</td>
											<td>
												交易面积
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<marquee style="WIDTH: 100%; HEIGHT: 100px" scrollamount="1" direction="up" onMouseOver="this.stop()" onMouseOut="this.start()"  >
												<table width="100%" border="0" cellpadding="0" cellspacing="0">
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</table>
												</marquee>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td width="472">
								<table width="470px" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr height="25">
											<td bgcolor="#f9f4f1" colspan="3" style="text-indent: 15px;">
												商品房
											</td>
										</tr>
										<tr style="font-weight: bold" height="33">
											<td width="40%" style="text-indent: 15px">
												城区
											</td>
											<td width="30%">
												交易套数
											</td>
											<td>
												交易面积
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<marquee style="WIDTH: 100%; HEIGHT: 100px" scrollamount="1" direction="up" onMouseOver="this.stop()" onMouseOut="this.start()"  >
												<table width="100%" border="0" cellpadding="0" cellspacing="0">
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</table>
												</marquee>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</dd>
		</dl>
	</div>
</div>
<div class="chjiao">
	<div class="box4">
		<dl>
			<dt>
				<div>
					<ul>
						<li style="width: 50%">
							今日签约
						</li>
						<li style="width: 42%">
							预售证公示
						</li>
						<li class="more"><a href="/preselllist.jspx" target="_blank">更多&gt;&gt;</a></li>
					</ul>
				</div>
			</dt>
			<dd>
				<table width="946px" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td width="472">
								<table width="470px" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr height="25">
											<td bgcolor="#f9f4f1" colspan="3" style="text-indent: 15px;">
												二手房
											</td>
										</tr>
										<tr style="font-weight: bold" height="33">
											<td width="40%" style="text-indent: 15px">
												城区
											</td>
											<td width="30%">
												交易套数
											</td>
											<td>
												交易面积
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<marquee style="WIDTH: 100%; HEIGHT: 100px" scrollamount="1" direction="up" onMouseOver="this.stop()" onMouseOut="this.start()"  >
												<table width="100%" border="0" cellpadding="0" cellspacing="0">
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</table>
												</marquee>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td width="472">
								<table width="470px" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr height="25">
											<td bgcolor="#f9f4f1" colspan="3" style="text-indent: 15px;"></td>
										</tr>
										<tr style="font-weight: bold" height="33">
											<td width="45%" style="text-indent: 15px">
												楼盘名称
											</td>
											<td width="30%">
												预售证号
											</td>
											<td>
												签发日期
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<marquee style="WIDTH: 100%; HEIGHT: 100px" scrollamount="1" direction="up" onMouseOver="this.stop()" onMouseOut="this.start()"  >
												<table width="100%" border="0" cellpadding="0" cellspacing="0">
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_20228688_price.htm target="_blank">
													晴庐11幢
												</a>
												</td>
												<td width="30%">萧售许字(2013)第066号</td>
												<td>2013-09-06</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_37106423_price.htm target="_blank">
													西河公寓（5幢、6幢、7幢）
												</a>
												</td>
												<td width="30%">萧售许字(2013)第062号</td>
												<td>2013-08-28</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_20229913_price.htm target="_blank">
													新义名苑商业部分
												</a>
												</td>
												<td width="30%">萧售许字(2013)第065号</td>
												<td>2013-08-28</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_30100249_price.htm target="_blank">
													和庭3幢、5幢、7幢、9幢
												</a>
												</td>
												<td width="30%">萧售许字(2013)第064号</td>
												<td>2013-08-28</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_30100249_price.htm target="_blank">
													和庭13幢、15幢
												</a>
												</td>
												<td width="30%">萧售许字(2013)第063号</td>
												<td>2013-08-28</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_16282805_price.htm target="_blank">
													凯丽晶座
												</a>
												</td>
												<td width="30%">萧售备字(2013)第011号</td>
												<td>2013-08-27</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_16190717_price.htm target="_blank">
													南城景园商铺组团
												</a>
												</td>
												<td width="30%">萧售备字(2013)第010号</td>
												<td>2013-08-20</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_35840115_price.htm target="_blank">
													保亿中心
												</a>
												</td>
												<td width="30%">萧售许字(2013)第061号</td>
												<td>2013-08-08</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_20221457_price.htm target="_blank">
													闻兴路147-219号、三江路297-333号商铺
												</a>
												</td>
												<td width="30%">萧售备字(2013)第008号</td>
												<td>2013-08-07</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_20221457_price.htm target="_blank">
													隐龙湾4幢及3、4幢裙房
												</a>
												</td>
												<td width="30%">萧售备字(2013)第009号</td>
												<td>2013-08-07</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_27749883_price.htm target="_blank">
													江南丽锦苑5#
												</a>
												</td>
												<td width="30%">萧售许字(2013)第060号</td>
												<td>2013-07-29</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_28666438_price.htm target="_blank">
													丽晶国际中心1幢2幢
												</a>
												</td>
												<td width="30%">萧售许字(2013)第059号</td>
												<td>2013-07-12</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_20229859_price.htm target="_blank">
													锦绣学府1幢
												</a>
												</td>
												<td width="30%">萧售许字(2013)第057号</td>
												<td>2013-07-11</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_33480236_price.htm target="_blank">
													联合中心南区
												</a>
												</td>
												<td width="30%">萧售许字(2013)第058号</td>
												<td>2013-07-11</td>
												</tr>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_33234578_price.htm target="_blank">
													建业金座1#、2#、3#楼
												</a>
												</td>
												<td width="30%">萧售许字(2013)第056号</td>
												<td>2013-07-10</td>
												</tr>
												</table>
												</marquee>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</dd>
		</dl>
	</div>
</div>
<!--<div class="banshizn">
	<div class="box6">
		<dl>
			<dt id="hzfc_002">
				<h1>办事指南</h1>
				<li class="active" onclick="hzfcgov(this,0);">最新</li>
						<li class="normal" onclick="hzfcgov(this,1);">权属管理</li>
						<li class="normal" onclick="hzfcgov(this,2);">房地产管理</li>
						<li class="normal" onclick="hzfcgov(this,3);">物业管理</li>
				<li class="more"><a href="newslist.jspx?categoryid=11" target="_blank">更多>></a></li>
			</dt>
			<dd>
				<div class="box6_t" id="hzfc_002_Content0">
					<li><a href="news.jspx?contentid=28025380&categoryid=11">·选聘前期物业服务企业备案资料</a></li>
					<li><a href="news.jspx?contentid=28025375&categoryid=11">·新建物业项目承接验收备案应提供的资料</a></li>
					<li><a href="news.jspx?contentid=28025370&categoryid=11">·建设单位采用协议方式选聘物业服务企业审批资料</a></li>
					<li><a href="news.jspx?contentid=28025361&categoryid=11">·物业服务企业三级（暂定三级）资质申报</a></li>
					<li><a href="news.jspx?contentid=28025356&categoryid=11">·前期物业服务企业招投标流程</a></li>
					<li><a href="news.jspx?contentid=28024840&categoryid=11">·房地产经纪机构备案登记</a></li>
				</div>
						<div class="box6_t" id="hzfc_002_Content1" style="display:none;">
										<li><a href="news.jspx?contentid=28024508&categoryid=11">·转移登记（二手房）</a></li>
										<li><a href="news.jspx?contentid=28024524&categoryid=11">·房屋登记费</a></li>
										<li><a href="news.jspx?contentid=28024493&categoryid=11">·初始登记（个人）</a></li>
										<li><a href="news.jspx?contentid=28024519&categoryid=11">·房产交易手续费</a></li>
										<li><a href="news.jspx?contentid=28024513&categoryid=11">·转移登记（商品房）</a></li>
										<li><a href="news.jspx?contentid=28024488&categoryid=11">·初始登记（单位）</a></li>
						</div>
						<div class="box6_t" id="hzfc_002_Content2" style="display:none;">
										<li><a href="news.jspx?contentid=28024820&categoryid=11">·商品房项目预售资金监管审批</a></li>
										<li><a href="news.jspx?contentid=28024840&categoryid=11">·房地产经纪机构备案登记</a></li>
										<li><a href="news.jspx?contentid=28024835&categoryid=11">·注销监管帐户需提供的资料</a></li>
										<li><a href="news.jspx?contentid=28024810&categoryid=11">·房地产开发企业资质定级申请</a></li>
										<li><a href="news.jspx?contentid=28024805&categoryid=11">·房地产开发企业暂定资质申请</a></li>
										<li><a href="news.jspx?contentid=28024815&categoryid=11">·房地产开发企业资质变更申请</a></li>
						</div>
						<div class="box6_t" id="hzfc_002_Content3" style="display:none;">
										<li><a href="news.jspx?contentid=28025375&categoryid=11">·新建物业项目承接验收备案应提供的资料</a></li>
										<li><a href="news.jspx?contentid=28025356&categoryid=11">·前期物业服务企业招投标流程</a></li>
										<li><a href="news.jspx?contentid=28025361&categoryid=11">·物业服务企业三级（暂定三级）资质申报</a></li>
										<li><a href="news.jspx?contentid=28025370&categoryid=11">·建设单位采用协议方式选聘物业服务企业审批资料</a></li>
										<li><a href="news.jspx?contentid=28025380&categoryid=11">·选聘前期物业服务企业备案资料</a></li>
						</div>
			</dd>
		</dl>
	</div>
	<div class="box6">
		<dl>
			<dt id="hzfc_005">
				<h1>法律法规</h1>
				<li class="active" onclick="hzfcgov(this,0);">最新</li>
				<li class="normal" onclick="hzfcgov(this,1);">综合类</li>
				<li class="normal" onclick="hzfcgov(this,2);">房地产管理</li>
				<li class="normal" onclick="hzfcgov(this,3);">权属登记</li>
				<li class="more"><a href="law.jspx" target="_blank">更多>></a></li>
			</dt>
			<dd>
				<div class="box6_t" id="hzfc_005_Content0">
					<li><a href="lawcontent.jspx?contentid=800124">·浙江省实施《中华人民共和国消费者权益保护法》办法</a></li>
					<li><a href="lawcontent.jspx?contentid=800123">·浙江省社会中介机构管理办法</a></li>
					<li><a href="lawcontent.jspx?contentid=800084">·房产测绘管理办法</a></li>
					<li><a href="lawcontent.jspx?contentid=800083">·城市异产毗连房屋管理规定</a></li>
					<li><a href="lawcontent.jspx?contentid=800082">·城市商品房预售管理办法</a></li>
					<li><a href="lawcontent.jspx?contentid=800071">·中华人民共和国土地管理法实施条例</a></li>
				</div>
				<div class="box6_t" id="hzfc_005_Content1" style="display:none;">
								<li><a href="lawcontent.jspx?contentid=800124">·浙江省实施《中华人民共和国消费者权益保护法》办法</a></li>
								<li><a href="lawcontent.jspx?contentid=800071">·中华人民共和国土地管理法实施条例</a></li>
								<li><a href="lawcontent.jspx?contentid=800070">·中华人民共和国婚姻法</a></li>
				</div>
				<div class="box6_t" id="hzfc_005_Content2" style="display:none;">
								<li><a href="lawcontent.jspx?contentid=800123">·浙江省社会中介机构管理办法</a></li>
								<li><a href="lawcontent.jspx?contentid=800064">·中华人民共和国城市房地产管理法</a></li>
								<li><a href="lawcontent.jspx?contentid=800084">·房产测绘管理办法</a></li>
								<li><a href="lawcontent.jspx?contentid=800082">·城市商品房预售管理办法</a></li>
								<li><a href="lawcontent.jspx?contentid=800083">·城市异产毗连房屋管理规定</a></li>
				</div>
				<div class="box6_t" id="hzfc_005_Content3" style="display:none;">
				</div>
			</dd>
		</dl>
	</div>
</div>
<div class="hg01"></div>
<div class="laste">
	<div class="lleft4">
		<dl>
			<dt class="divTop" id="myTop5">
				<ul>
					<li class="hover">开发公司</li>
					<li>中介机构</li>
				</ul>
			</dt>
			<dd id="myCont5">
				<div>
					<ul>
						<table width="97%" border="0">
							<tbody>
									<tr height="25">
										<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026716&categoryid=14" title="美都建设有限公司">美都建设有限公司</a>
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28025742&categoryid=14" title="升华地产集团有限公司">升华地产集团有限公司</a>
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28025738&categoryid=14" title="浙江华盛达房地产开发有限公司">浙江华盛达房地产开发有限公司</a>
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28025734&categoryid=14" title="县微利房屋开发有限公司">县微利房屋开发有限公司</a>
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28025730&categoryid=14" title="浙江兴隆房地产开发有限公司">浙江兴隆房地产开发有限公司</a>
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28025726&categoryid=14" title="名城置业有限公司">名城置业有限公司</a>
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
									<tr height="25">
										<td colspan="2" align="left">
										</td>
									</tr>
							</tbody>
						</table>
					</ul>
				</div>
				<div style="display: block;">
					<ul>
						<table width="97%" border="0">
							<tbody>
							</tbody>
						</table>
					</ul>
				</div>
			</dd>
		</dl>
	</div>
	<div class="lleft4">
		<dl>
			<dt class="divTop" id="myTop6">
				<ul>
					<li class="hover">
						物业服务
					</li>
					<li>
						房地产协会
					</li>
				</ul>
			</dt>
			<dd id="myCont6">
				<div>
					<ul>
						<table width="97%" border="0">
							<tbody>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026530&categoryid=14" title="盛全物业服务有限公司分公司">盛全物业服务有限公司分公司</a>
											</td>
										</tr>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026526&categoryid=14" title="绿城物业服务集团有限公司分公司">绿城物业服务集团有限公司分公司</a>
											</td>
										</tr>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026522&categoryid=14" title="浙江金都物业管理有限公司分公司">浙江金都物业管理有限公司分公司</a>
											</td>
										</tr>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026518&categoryid=14" title="杭州开元物业服务有限公司分公司">杭州开元物业服务有限公司分公司</a>
											</td>
										</tr>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026514&categoryid=14" title="升华集团物业管理有限公司">升华集团物业管理有限公司</a>
											</td>
										</tr>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=28026510&categoryid=14" title="浙江银杏物业管理有限公司分公司">浙江银杏物业管理有限公司分公司</a>
											</td>
										</tr>
							</tbody>
						</table>
					</ul>
				</div>
				<div style="display: block;">
					<ul>
						<table width="97%" border="0">
							<tbody>
							</tbody>
						</table>
					</ul>
				</div>
			</dd>
		</dl>
	</div>
</div>-->
<div class="hg1"></div>
<div class="link">
	<ul>
		<p>
			<a href="http://www.tmsf.com/" target=_blank> 透明售房网 </a>
			<a href="http://www.realestate.gov.cn/" target=_blank> 中国住宅与房地产信息网 </a>
			<a href="http://www.hzjw.gov.cn/" target=_blank> 杭州建设网 </a>
			<a href="http://www.zjjs.gov.cn/DesktopDefault.aspx?tabid=1" target=_blank> 浙江省建设信息港 </a>
			<a href="http://www.srea.org.cn/" target=_blank> 上海房产网 </a>
			<a href="http://www.bjjs.gov.cn/tabid/2207/Default.aspx" target=_blank> 北京市房地产交易管理网 </a>
			<a href="http://www.tjfdc.com.cn/tj/default.aspx" target=_blank> 天津市房地产综合信息网 </a>
		</p>
		<p>
			<a href="http://www.cq315house.com/" target=_blank> 重庆网上房地产 </a>
			<a href="http://www.szfdc.gov.cn/" target=_blank> 深圳市国土资源和房产管理局 </a>
			<a href="http://www.cnnbfdc.com/" target=_blank> 宁波住宅与房地产网 </a>
			<a href="http://www.deqing.gov.cn/" target=_blank> 德清政府网  </a>
			<a href="http://www.dqjsj.gov.cn/" target=_blank> 德清建设局网站 </a>
		</p>
	</ul>
</div>
<div class="hg01"></div>
<div class="footer">
<table width="100%" border="0"  cellspacing="0" cellpadding="0" >
<div class="hg01"></div>
	<span id="_ideConac" style="position:absolute; right:0px; top:30px;display:block;">
		<script type="text/javascript">document.write(unescape("%3Cspan id='_ideConac' %3E%3C/span%3E%3Cscript src='http://dcs.conac.cn/js/12/194/0000/41026650/CA121940000410266500002.js' type='text/javascript'%3E%3C/script%3E"));</script>
	</span>
	<tr>
		<td height="36" style=" text-align:center; color:#333; font-size:14px; line-height:26px;" ><span style="margin-top:10px;">主办单位 三门房产管理处 Copyright &copy; 2013 技术支持：杭州中房信息科技有限公司 All Rights Reserved</span> </td>
	</tr>
	<tr align="center">
		<td align="center" >
			<ul class="l_lj">
				<li><img src="images/zxbg09.jpg" width="118" height="49" />
				</li>
				<li><img src="images/zxbg10.jpg" width="118" height="49" />
				</li>
				<li><img src="images/zxbg11.jpg" width="118" height="49" />
				</li>
				<li><img src="images/zxbg12.jpg" width="118" height="49" />
				</li>
			</ul>
		</td>
	</tr>
</table>
</div>


<div class="footer" style="position:relative;">
<table width="100%" border="0"  cellspacing="0" cellpadding="0" >
<div class="hg01"></div>
	<span id="_ideConac" style="position:absolute; right:0px; top:30px;display:block;">
		<script type="text/javascript">document.write(unescape("%3Cspan id='_ideConac' %3E%3C/span%3E%3Cscript src='http://dcs.conac.cn/js/12/194/0000/41026650/CA121940000410266500002.js' type='text/javascript'%3E%3C/script%3E"));</script>
	</span>
	<tr>
		<td height="36" style=" text-align:center; color:#333; font-size:14px; line-height:26px;" ><span style="margin-top:10px;">主办单位 湖州市建设局 Copyright &copy; 2014 湖州房产网 All Rights Reserved</span> </td>
	</tr>
	<tr align="center">
		<td align="center" >
			<ul class="l_lj">
				<li><img src="images/zxbg09.jpg" width="118" height="49" />
				</li>
				<li><img src="images/zxbg10.jpg" width="118" height="49" />
				</li>
				<li><img src="images/zxbg11.jpg" width="118" height="49" />
				</li>
				<li><img src="images/zxbg12.jpg" width="118" height="49" />
				</li>
			</ul>
		</td>
	</tr>
</table>
</div>
</body>
</html>
