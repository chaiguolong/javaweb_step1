<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYpE html pUBliC "-//W3C//dtD XHTML 1.0 Transitional//EN" "http://www.w3.org/tr/xhtml1/dtD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投诉咨询_台州市三门县房地产管理处</title>
<link href="/css/zx.css" rel="stylesheet" type="text/css" />
<link href="/css/head.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/slide.js"></script>
</head>

<body>
<jsp:include page="/head.jsp" />
<div class="top">您现在的位置：<a href="/index.jsp">首页 </a>>投诉咨询详情</div>
<div class="hg"></div>
<div class="content">
<div class="middle">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr class="lftip" height="25px">
		<td width="15%" id="zxgl" align="center">投诉咨询</td>
		<td width="83%">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">
			<div class="box4">
				<table border="0" cellSpacing="0" cellpadding="0" width="742" align="center">
			        <tr>
						<td height="37">
							<table border="0" cellSpacing="0" cellpadding="0" width="708" align="center">
								<tr>
									<td width="240" style="float:left;"><img src="images/tousu_1.jpg" width="240" height="37" /></td>
									<td background="images/menubg.jpg" width="502">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<table class="main" border="0" cellSpacing="1" cellpadding="6" width="95%" bgColor="#cccccc" align="center">
						    	<tr>
									<td bgColor="#d5ebff" height="24" width="95">
										<div align="right">发布时间</div>
									</td>
									<td width="573" height="24" bgColor="#ffffff">
									<s:property value="complaint.addtime" />
									</td>
								</tr>
								<tr>
									<td bgColor="#d5ebff" height="24" width="95">
										<div align="right">投诉/咨询事宜</div>
									</td>
									<td bgColor="#ffffff" height="24">
										<s:property value="complaint.infotitle" />
									</td>
								</tr>
								<tr>
									<td bgColor="#d5ebff" height="110" vAlign="top" width="95">
										<div align="right">投诉/咨询内容</div>
									</td>
									<td bgColor="#ffffff" height="110" vAlign="top">
										<s:property value="complaint.infocontent" />
									</td>
								</tr>
							</table>
							<br>
							<table class="main" border="0" cellSpacing="1" cellpadding="6" width="95%" bgColor="#cccccc" align="center">
								<tr>
									<td bgColor="#d5ebff" height="24" width="95">
										<div align="right">答复时间</div>
									</td>
									<td bgColor="#ffffff" height="24">
										<s:property value="complaint.replytime" />
									</td>
								</tr>
								<tr>
									<td bgColor="#d5ebff" height="24" vAlign="top" width="80">
										<div align="right">答复内容</div>
									</td>
									<td bgColor="#ffffff" height="110" vAlign="top">
										<s:property value="complaint.replycontent" /><p></p>
									</td>
								</tr>
							</table><br>
						</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
</table>
</div>
<div class="clear"></div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
