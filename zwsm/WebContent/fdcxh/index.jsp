<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tmsf_tag.tld" prefix="tmsf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>房地产协会_德清房地产信息网</title>
		<link href="/fdcxh/images/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/fdcxh/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/fdcxh/js/slide.js"></script>
		<script type="text/javascript" src="/fdcxh/js/jquery.KinSlideshow-1.2.1.min.js" ></script>
		<script type="text/javascript">
			var n=5;
			for(var i=1; i<=n; i++)
			{
				switchtag(i);
			}
			function switchtag(x)
			{
			   $(document).ready(function(){
			   $("#myCont" + x + " > div:not(:first)").hide();
			   var myLi = $("#myTop" + x + " > ul > li");
			   var myDiv =$("#myCont" + x + " > div");
			   myLi.each(function(i){
			      $(this).mousedown(function(){
			        myLi.removeClass("hover");
			         $(this).addClass("hover");
			          myDiv.hide();
			          myDiv.eq(i).show();
			      })
			   })
			   })
			}
	    </script>
		<script type="text/javascript">
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
				for(i=0; i <tabList.length; i++){
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
			$(document).ready(function(){	
				showdate();
			});
			function showdate() {
				var mydate = new Date();
				var myyear = mydate.getFullYear();
				var mymonth = mydate.getMonth()+1;
				var myday = mydate.getDate();
				var myweekday = mydate.getDay();
				var days= ["日","一","二","三","四","五","六" ]
				$('#date').html(myyear + "年" + mymonth + "月" + myday + "日" + " " +"星期" + days[myweekday]);
			}
			$(function(){
				$("#KinSlideshowid").KinSlideshow({
					isHasTitleBar:false,
					moveStyle:"up",
					isHasTitleFont:true,
					titleBar:{titleBar_height:30,titleBar_bgColor:"#000000",titleBar_alpha:0.5},
					btn:{btn_bgColor:"#FFFFFF",btn_bgHoverColor:"#ff6600",btn_fontColor:"#000000",
				               btn_fontHoverColor:"#FFFFFF",btn_borderColor:"#cccccc",
				               btn_borderHoverColor:"#cccccc",btn_borderWidth:1
				          }
				});
			})
       </script>
	</head>
	<body>
		<s:include value="/fdcxh/xh_fdcxh_top.html"></s:include>
		<s:include value="/include/fdcxh_top_link.html"></s:include>
		<div class="xscontent">
			<s:include value="/include/fdcxh_index.html"></s:include>
		</div>
		<div class="hg"></div>
		<s:include value="/fdcxh/xh_fdcxh_link.html"></s:include>
		<div class="hg01"></div>
		<s:include value="/fdcxh/xh_fdcxh_bottom.html"></s:include>
	</body>
</html>