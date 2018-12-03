<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link href="/css/css.css" rel="stylesheet" type="text/css" />
<link href="/css/zx.css" rel="stylesheet" type="text/css" />
<link href="/css/head.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/slide.js"></script>
<script>
	/*第一种形式 第二种形式 更换显示样式*/
	function setTab(name, cursel, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById("con_" + name + "_" + i);
			if(menu != null) {
				menu.className = i == cursel ? "hover" : "";
			}
			if(con != null) {
				con.style.display = i == cursel ? "block" : "none";
			}
		}
	}

	/*显示/隐藏层代码片段*/
	var number = 2;

	function LMYC() {
		var lbmc;
		//var treePic;
		for (i = 1; i <= number; i++) {
			lbmc = eval('LM' + i);
			//treePic = eval('treePic'+i);
			//treePic.src = 'images/file.gif';
			lbmc.style.display = 'none';
		}
	}

	function ShowFLT(i) {
		lbmc = eval('LM' + i);
		//treePic = eval('treePic' + i)
		if (lbmc.style.display == 'none') {
			LMYC();
			//treePic.src = 'images/nofile.gif';
			lbmc.style.display = '';
		} else {
			//treePic.src = 'images/file.gif';
			lbmc.style.display = 'none';
		}
	}

	//-->
</script>