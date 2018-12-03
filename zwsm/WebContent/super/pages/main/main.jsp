<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>三门房产政务网·房产综合信息门户</title>
    <meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
    <link rel="stylesheet" type="text/css" href="/super/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
    <script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/super/js/jquery.form.js"></script>
	<script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/super/js/comm.js"></script>
	<style type=text/css>
		HTML {
			PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; OVERFLOW: hidden; PADDING-TOP: 0px
		}
		BODY {
			PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; OVERFLOW: hidden; PADDING-TOP: 0px
		}
		HTML {
			HEIGHT: 100%;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			loadTopmenuList();
		});

		//加载顶部菜单
		function loadTopmenuList(){
			$.ajax({
				url:'/super/Framework_loadTopMenu.jspx',
				type: 'get', dataType:'html', cache: false, async:false,
				error: function(xhr){
					exceptionAlert();
				},
				success: function(data){	
					if(data != null){
						var d = eval('(' + data + ')');
						for(var i in d){
							$('#topmenulist').append('<a href="javascript:loadLeftmenuList(' + d[i].menuid + ');" class="toptitle">' + d[i].menuname + '</a><span class="addrtitle">&nbsp;&nbsp;|&nbsp;&nbsp;</span>')
						}
						$('#topmenulist').append('<a href="javascript:doExit();" class="toptitle">退出</a>');
						loadLeftmenuList(d[0].menuid);
					}
				}
			});
		}

		function loadLeftmenuList(pid){
			$('#leftmenulist').html('');
			$.ajax({
				url:'/super/Framework_loadLeftMenu.jspx?pid=' + pid,
				type: 'get', dataType:'html', cache: false, async:false,
				error: function(xhr){
					exceptionAlert();
				},
				success: function(data){	
					if(data != null){
						var d = eval('(' + data + ')');	
						for(var i in d){
							if(d[i].levelid == 1){
								$('#leftmenulist').append('<li id="' + d[i].menuid + '" pid="' + d[i].pid + '" class="fs" style=""><a href="javascript:openNewWindow(\'' + d[i].pid + '\',\'' + d[i].menuname + '\',\'' + d[i].definestring + '\');" class="f_size" title="' + d[i].menuname + '">' + d[i].menuname + '</a></li>')
							}
							else if(d[i].levelid == 2) {
								$('#leftmenulist').append('<li id="' + d[i].menuid + '" pid="' + d[i].pid + '" class="fs" style="padding-left: 20px; display: block; "><a href="javascript:openNewWindow(\'' + d[i].pid + '\',\'' + d[i].menuname + '\',\'' + d[i].definestring + '\');" class="f_size" title="' + d[i].menuname + '"><img src="/super/common/flexigrid/css/images/level.gif">' + d[i].menuname + '</a></li>')
							}
							else if(d[i].levelid == 3) {
								$('#leftmenulist').append('<li id="' + d[i].menuid + '" pid="' + d[i].pid + '" class="fs" style="padding-left: 40px; display: block; "><a href="javascript:openNewWindow(\'' + d[i].pid + '\',\'' + d[i].menuname + '\',\'' + d[i].definestring + '\');" class="f_size" title="' + d[i].menuname + '"><img src="/super/common/flexigrid/css/images/level.gif">' + d[i].menuname + '</a></li>')
							}
						}
					}
					$('#folder ul li').bind('click', function(){
						var pid = $(this).attr('id');
						$('#folder ul li').each(function (){
							$(this).attr('class', 'fs');
							if($(this).attr('pid') == pid){
								$(this).css('display') == 'block' ? $(this).css('display','none') : $(this).css('display','block');
							}
						});
						$(this).addClass('fn');
					});
				}
			});
		}
		
		function openTips(){
			$("#systemtips").css('bottom', '-151px');
			$("#systemtips").animate({ bottom: "0"}, 'slow');
		}
		
		function closeTips(){
			$("#systemtips").animate({ bottom: "-151"}, 'slow');
		}
		
		//新窗口方法
		function openNewWindow(id, name, _url){
			if(_url == "javascript:void(0);") return ;
			var url = '/' + _url;
			var _isOpen = false;//是否已经开启窗口
			$('.mainTabs ul li').each(function(){
				if($(this).attr('id') == 'tabitem_' + id){
					_isOpen = true;
				}
			});
			if(_isOpen){
				$('#tabitem_link_' + id ).attr('title', name);
				$('#tabitem_span_' + id ).html(name);
				$('#container_' + id + ' iframe').attr('src', url);
			}
			else {
				if($('.mainTabs ul li').length >=6){
					id = $('.mainTabs ul li:last').attr('id').substring(8);
					$('#tabitem_link_' + id ).attr('title', name);
					$('#tabitem_span_' + id ).html(name);
					$('#container_' + id + ' iframe').attr('src', url);
				}
				else {
					//创建tabs
					$('.mainTabs ul').append('<li style="width: 100px; " id="tabitem_' + id + '" class="WB3-gTop-tabs-item fn-animation-slideIn fn-animation-slideIn-lr fn-animation-showing" onclick="javascript:displayTabs(\'' + id + '\');">'
						+ '<a id="tabitem_link_' + id + '" href="javascript:void(0);" class="WB3-gTop-tabs-link il" title="' + name + '"><b class="WB3-gTop-tabs-rc WB3-gTop-tabs-rc-1"></b><b class="WB3-gTop-tabs-rc WB3-gTop-tabs-rc-2"></b>'
						+ '<span id="tabitem_span_' + id +'">' + name + '</span></a>'
						+ '<a href="javascript:removeTabs(\'' + id + '\');" class="WB3-gTop-tabs-close"></a></li>');
					
					//创建container
					$('body').append('<div id="container_' + id + '" class="mainFrameContainer" style="display:none;">'
						+ '<iframe src="' + url + '" name="mainFrame" id="mainFrame" frameborder="0" scrolling="yes"></iframe></div>');
				}
			}
			displayTabs(id);
		}
		
		//窗口切换显示窗口
		function displayTabs(id){
			$('.mainTabs ul li').each(function(){
				$(this).removeClass('WB3-gTop-tabs-item-on');
			});
			$('.mainFrameContainer').each(function(){
				$(this).css('display', 'none');
			});
			$('#tabitem_'+id).addClass('WB3-gTop-tabs-item-on');
			$('#container_'+id).css('display', 'inline');
		}
		
		//关闭窗口
		function removeTabs(id){
			$('#tabitem_'+id).remove();
			$('#container_'+id).remove();
			//显示最后一个tab
			displayTabs($('.mainTabs ul li:last').attr('id').substring(8));
		}

		//退出
		function doExit(){
			$.ajax({
				url:'/super/Framework_doExit.jspx',
				type: 'get', dataType:'html', cache: false, async:false,
				error: function(xhr){
					exceptionAlert();
				},
				success: function(data){	
					window.location.reload();
				}
			});
		}

		//切换站点
		function showChangedSite(){
			$('#websiteSpan').css('display', 'none');
			$('#webselect').css('display', 'inline-block');
			$('#sitelist').val($('#siteid').val()+','+$('#sqlMapClientId').val());
		}

		function dochangedWebSite(){
			var id = $('#sitelist option:selected').val().split(',');
			$('#siteid').val(id[0]);
			$('#sqlMapClientId').val(id[1]);
			$('#sitename').val($('#sitelist option:selected').html());
			var saveOptions={
				target: '#siteForm',
				url:"/super/Framework_changedWebSite.jspx", type: 'post', dataType: 'html', cache:false, async:false,
				beforeSubmit:function(formArray, jqForm){
				},
				error:function(xhr){
					exceptionAlert();
				},
				success: function(data) {
					var r = eval('(' + data + ')');	
					if(r.flag){
						$('#websiteSpan').html($('#sitename').val());
						$('#websiteSpan').css('display', 'inline-block');
						$('#webselect').css('display', 'none');
					}
					else {
						showAlert("切换失败，请重新登录！", "alert");
					}
				}
			}
			$('#siteForm').ajaxSubmit(saveOptions);
		}
		
	</script>
 </head>
 <body class="frame_class">
	<div class="getuserdata" id="topDataTd"> 
		<div class="topdata"> 
			<div class="topbg" style="height:66px"> 
				<div class="setinfo addrtitle" id="SetInfo"> 
					<!-- 顶部菜单 -->
					<div class="right" id="topmenulist"></div> 
				</div> 
			</div> 
			<div class="lgoo" id="logotips"> 
				<a class="imglogo pointer" href="javascript:openNewWindow('index','首页','super/pages/main/wellcome.jsp');"><img id="imglogo" src="/super/css/images/comm/logo.jpg" height="60" /></a> 
				<div class="switcha">
					<div class="left" style="margin-top:1px;"> 
						<span id="useraddrcontainer" class="pointer"><span id="useraddr" style="color: #2C4A77;font-weight: bold;">${sysAccount.loginuser}</span>&nbsp;[&nbsp;<a href="javascript:openNewWindow('index','首页','super/pages/main/wellcome.jsp');">首页</a>&nbsp;|&nbsp;<a href="javascript:openNewWindow('index','设置密码','super/Framework_toPassword.jspx');" id="frame_html_setting">设置密码</a>&nbsp;]&nbsp;</span> 
					</div> 
				</div> 
			</div> 
		</div> 
	</div> 
	<div class="mainTabs">
		<ul>
			<li id="tabitem_index" class="WB3-gTop-tabs-item fn-animation-slideIn fn-animation-slideIn-lr fn-animation-showing WB3-gTop-tabs-item-on" onclick="javascript:displayTabs('index');">
				<a href="javascript:openNewWindow('index','首页','super/pages/main/wellcome.jsp');" class="WB3-gTop-tabs-link il" title="首页">
					<b class="WB3-gTop-tabs-rc WB3-gTop-tabs-rc-1"></b>
					<b class="WB3-gTop-tabs-rc WB3-gTop-tabs-rc-2"></b>
					<span id="tabitem_span_index">首页</span>
				</a>
			</li>
		</ul>
	</div>
	<div class="topline_height" id="sepLineTd"> 
		<div class="topline"> 
			<div class="toplineimg left" id="imgLine"></div> 
		</div>
	</div>
	<!-- left -->
	<div class="fdbody bodybgbt"></div>
	<div class="newskinbody" id="leftPanel"> 
		<div id="navMidBar" class="listbg listflow"> 
			<div id="folder" class="folderDiv" style="overflow-x:hidden; overflow-y: auto;"> 
				<ul class="fdul" id="leftmenulist"></ul>
			</div>
		</div>
		<div id="navBottomTd" class="navbottom"></div>
	</div>
	<div id="container_index" class="mainFrameContainer">
		<iframe src="/super/pages/main/wellcome.jsp" name="mainFrame" id="mainFrame" frameborder="0" scrolling="yes"></iframe>
	</div>
 </body>
</html>
