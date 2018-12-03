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
<#list lsttopWebAd as webAd>
    <#if (webAd.rsstype?exists)&&(webAd.rsstype)?? && webAd_index < 8>
		<#if webAd.rsstype==1>
			<div class="gg1"><a href="${webAd.linkurl!""}" target="_blank"><img src="${webAd.adpath!""}" alt="${webAd.descr!""}" width="950" height="65" /></a></div>
			<div class="hg2"></div>
       </#if>
    </#if>
</#list>
<div class="header">
	<img src="images/zxtop.jpg" width="950" height="102" />
</div>
<div class="nav">
	<ul id="menu">
		<#list categorylist as c>
		<#if c.pid = 1>
		<li class="mainlevel"><div class="title"><#if c.url != '#' && c.url != ''><a href="${c.url}" target="_blank">${c.name}</a><#else>${c.name}</#if></div>
			<ul id="sub_02" class="TipsContent">
				<#list categorylist as son>
				<#if son.pid = c.categoryid>
					<li><#if son.url != '#' && son.url != ''><a href="${son.url}" target="_blank">${son.name}</a><#else>${son.name}</#if></li>
				</#if>
				</#list>
			</ul>
		</li>
		</#if>
		</#list>
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
	<#list kuaixunlist as k>
	<#if k_index < 8>
		<#if k.gotourl != "">
		<a href="${k.gotourl}" target="_blank" title="${k.title}" class="main">
		<#else>
		<a href="news.jspx?contentid=${k.contentid?c!""}&categoryid=13" target="_blank" title="${k.title}" class="main">
		</#if>
		${k.title}</a>&nbsp;&nbsp;&nbsp;
	</#if>
	</#list>
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
							<#list lstWebAd as webAd>
						        <#if (webAd.rsstype?exists)&&(webAd.rsstype)?? && webAd_index < 8>
									<#if webAd.rsstype==1>
									<a href="${webAd.linkurl!""}" target="_blank"><img src="${webAd.adpath!""}" alt="${webAd.descr!""}" width="220" height="200" /></a>
						           </#if>
						        </#if>
		    				</#list>
  						</div>
					</div>
				</div>
				<div class="hotnews">
					<ul>
						<#list kuaixunlist as k>
							<#if k_index = 0>
								<li class="zi">
									<#if k.gotourl != "">
									<a href="${k.gotourl}" target="_blank" title="${k.title}">
									<#else>
									<a href="news.jspx?contentid=${k.contentid?c!""}&categoryid=13" target="_blank" title="${k.title}">
									</#if>
									<font color=#ff0306><#if (k.title?length>15)>${k.title[0..15]?default("")}<#else>${k.title}</#if></font>
									</a>
									</li>
									<#elseif k_index < 9>
									<li>
									<font color="855c02"></font>
									<#if k.gotourl != "">
									<a href="${k.gotourl}" target="_blank" title="${k.title}">
									<#else>
									<a href="news.jspx?contentid=${k.contentid?c!""}&categoryid=13" target="_blank" title="${k.title}">
									</#if><#if (k.title?length>15)>${k.title[0..15]?default("")}<#else>${k.title}</#if></a>
									<span style="float:right">[${k.webshowdate[0..9]}]</span>
								</li>
							</#if>
						</#list>
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
									<#list tongzhilist as t>
										<#if t_index < 9>
											<tr height="25">
												<td align="left">&middot;<a href="news.jspx?contentid=${t.contentid?c!""}&categoryid=14" title="${t.title}"><#if (t.title?length>20)>${t.title[0..20]?default("")}<#else>${t.title}</#if></a></td>
												<td align="right">[${t.webshowdate?string[0..9]}]</td>
											</tr>
										<#else>
											<tr height="25"><td align="left"></td><td align="right"><a href="newslist.jspx?categoryid=14" target="_blank">更多>></a></td></tr>
										</#if>
									</#list>
								</table>
							</ul>
						</div>
						<div>
							<ul>
								<table width="97%" border="0">
									<#list gongshilist as t>
										<#if t_index < 10>
											<tr height="25">
												<td align="left">&middot;<a href="news.jspx?contentid=${t.contentid?c!""}&categoryid=14" title="${t.title}"><#if (t.title?length>20)>${t.title[0..20]?default("")}<#else>${t.title}</#if></a></td>
												<td align="right">[${t.webshowdate?string[0..9]}]</td>
											</tr>
										</#if>
									</#list>
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
					<#if (byfz?exists) && (byfz?size>0) >
			            <#list byfz as e>
			            	<div>
								<p>
					            	<#if e.descr?length lt 140 >
										${e.descr!""}
									<#else>
										${e.descr[0..139]}
									</#if>
					            	<#if e.gotourl?length gt 0>
				            			 <a href="${e.gotourl!""}"  target="_blank"> 
				            		<#else>
					            		<a href="/news.jspx?contentid=${e.contentid?c!""}&categoryid=${byfzid?c!""}" target="_blank" title="${e.title!""}">
				            		</#if>
										<font color="#1e8ebc">[查看详情]</font></a>
			            		</p>
							</div>
			            </#list>
			        </#if>
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
					<#list byfzlist as e>
						<#if e_index < 8>
							<li><a href='news.jspx?contentid=${e.contentid?c!""}&categoryid=28027158' target="_blank" title="${e.title!""}">
								<#if (e.title?length>15)>${e.title[0..14]?default("")}
								<#else>${e.title}
								</#if>
							</a></li>
						</#if>
					</#list>
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
					<#list complaintlist as c>
						<#if c_index < 8>
						<li><a href='/complaint.jspx?complaintid=${c.complaintid?c!""}' target="_blank" title="${c.infotitle}"><#if (c.infotitle?length>16)>${c.infotitle[0..15]?default("")}<#else>${c.infotitle}</#if></a></li>
						</#if>
					</#list>
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
												<#if dailylist?has_content>
												<#list dailylist as t>
												<#if t_index %2 == 0>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<#else>
												<tr style="color:#4d4d4d"  height="25">
												</#if>
												<td width="40%" style="text-indent:15px;">${t.districtname}</td>
												<td width="30%">${t.dealnum}套</td>
												<td>${t.dealarea}㎡</td>
												</tr>
												</#list>
												<#else>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</#if>
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
												<#if monthlylist?has_content>
												<#list monthlylist as t>
												<#if t_index %2 == 0>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<#else>
												<tr style="color:#4d4d4d"  height="25">
												</#if>
												<td width="40%" style="text-indent:15px;">${t.districtname}</td>
												<td width="30%">${t.dealnum}套</td>
												<td>${t.dealarea}㎡</td>
												</tr>
												</#list>
												<#else>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</#if>
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
												<#if useddailylist?has_content>
												<#list useddailylist as t>
												<#if t_index %2 == 0>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<#else>
												<tr style="color:#4d4d4d"  height="25">
												</#if>
												<td width="40%" style="text-indent:15px;">${t.districtname}</td>
												<td width="30%">${t.signnum?c!""}套</td>
												<td>${t.signarea?c!""}㎡</td>
												</tr>
												</#list>
												<#else>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</#if>
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
												<#if preselllist?has_content>
												<#list preselllist as t>
												<#if t_index %2 == 0>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<#else>
												<tr style="color:#4d4d4d"  height="25">
												</#if>
												<td width="45%" style="text-indent:15px;">
												<a href="http://tmsf.smfg.gov.cn/newhouse/property_331022_${t.propertyid?c!""}_price.htm target="_blank">
													${t.projname}
												</a>
												</td>
												<td width="30%">${t.presellname}</td>
												<td>${t.openingdate?string[0..9]}</td>
												</tr>
												</#list>
												<#else>
												<tr style="color:#4d4d4d"  height="25" bgcolor="#f9f4f1">
												<td width="30%" style="text-indent:15px;">暂无数据</td>
												</tr>
												</#if>
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
				<#list banshizhinanlist as f >
					<#if f_index < 3>
						<li class="normal" onclick="hzfcgov(this,${f_index + 1});">${f.name}</li>
					</#if>
				</#list>
				<li class="more"><a href="newslist.jspx?categoryid=11" target="_blank">更多>></a></li>
			</dt>
			<dd>
				<div class="box6_t" id="hzfc_002_Content0">
				<#list banshilist as fa><#if fa_index < 6>
					<li><#if fa.gotourl != ""><a href="${fa.gotourl}"><#else><a href="news.jspx?contentid=${fa.contentid?c!""}&categoryid=11"></#if>·${fa.title}</a></li>
				</#if></#list>
				</div>
				<#list banshizhinanlist as f>
					<#if f_index < 3>
						<div class="box6_t" id="hzfc_002_Content${f_index + 1}" style="display:none;">
							<#assign x = 0 />
							<#list banshigxlist as guanxi>
								<#if guanxi.categoryid = f.categoryid>
									<#list banshilist as fa>
									<#if guanxi.contentid = fa.contentid>
										<#if x < 6>
										<li><#if fa.gotourl != ""><a href="${fa.gotourl}"><#else><a href="news.jspx?contentid=${fa.contentid?c!""}&categoryid=11"></#if>·${fa.title}</a></li>
										<#assign x=x+1 />
										</#if>
									</#if>
									</#list>
								</#if>
							</#list>
						</div>
					</#if>
				</#list>
			</dd>
		</dl>
	</div>
	<div class="box6">
		<dl>
			<dt id="hzfc_005">
				<h1>法律法规</h1>
				<li class="active" onclick="hzfcgov(this,0);">最新</li>
				<#list falvmenulist as f >
				<#if f_index < 3>
				<li class="normal" onclick="hzfcgov(this,${f_index + 1});">${f.name}</li>
				</#if>
				</#list>
				<li class="more"><a href="law.jspx" target="_blank">更多>></a></li>
			</dt>
			<dd>
				<div class="box6_t" id="hzfc_005_Content0">
				<#list falvlist as fa><#if fa_index < 6>
					<li><#if fa.gotourl != ""><a href="${fa.gotourl}"><#else><a href="lawcontent.jspx?contentid=${fa.contentid?c!""}"></#if>·${fa.title}</a></li>
				</#if></#list>
				</div>
				<#list falvmenulist as f><#if f_index < 3>
				<div class="box6_t" id="hzfc_005_Content${f_index + 1}" style="display:none;">
					<#assign x = 0 />
					<#list guanxilist as guanxi>
						<#if guanxi.categoryid = f.categoryid>
							<#list falvlist as fa>
							<#if guanxi.contentid = fa.contentid>
								<#if x < 6>
								<li><#if fa.gotourl != ""><a href="${fa.gotourl}"><#else><a href="lawcontent.jspx?contentid=${fa.contentid?c!""}"></#if>·${fa.title}</a></li>
								<#assign x=x+1 />
								</#if>
							</#if>
							</#list>
						</#if>
					</#list>
				</div>
				</#if></#list>
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
								<#list developerlist as t>
									<tr height="25">
										<td colspan="2" align="left">
											<#if t_index < 6>
												·<a href="news.jspx?contentid=${t.contentid?c!""}&categoryid=14" title="${t.title}"><#if (t.title?length>31)>${t.title[0..30]?default("")}<#else>${t.title}</#if></a>
											</#if>
										</td>
									</tr>
								</#list>
							</tbody>
						</table>
					</ul>
				</div>
				<div style="display: block;">
					<ul>
						<table width="97%" border="0">
							<tbody>
								<#list zhongjiejglist as t>
									<tr height="25">
										<td colspan="2" align="left">
											<#if t_index < 6>
												·<a href="news.jspx?contentid=${t.contentid?c!""}&categoryid=14" title="${t.title}"><#if (t.title?length>31)>${t.title[0..30]?default("")}<#else>${t.title}</#if></a>
											</#if>
										</td>
									</tr>
								</#list>
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
								<#list wuyefwlist as t>
									<#if t_index < 6>
										<tr height="25">
											<td colspan="2" align="left">
												·<a href="news.jspx?contentid=${t.contentid?c!""}&categoryid=14" title="${t.title}"><#if (t.title?length>31)>${t.title[0..30]?default("")}<#else>${t.title}</#if></a>
											</td>
										</tr>
									</#if>
								</#list>
							</tbody>
						</table>
					</ul>
				</div>
				<div style="display: block;">
					<ul>
						<table width="97%" border="0">
							<tbody>
								<#list fdcxhlist as t>
									<#if t_index < 6>
										<tr height="25">
											<td colspan="2" align="left">
											·<a href="/xh/WebFdcxhAction_news.jspx?contentid=${t.contentid?c!""}&categoryid=14" title="${t.title}"><#if (t.title?length>31)>${t.title[0..30]?default("")}<#else>${t.title}</#if></a>
											</td>
										</tr>
									</#if>
								</#list>
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
