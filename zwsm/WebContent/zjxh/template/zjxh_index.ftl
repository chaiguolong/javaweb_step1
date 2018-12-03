<div class="topsearch">
	<table width="100%" height="30" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="8"></td>
			<td width="200">
				<div class="c" id="date">2013年5月08日星期三</div>
			</td>
			<td>
				<div class="d">&nbsp;
					<marquee onMouseOver="this.stop()" onMouseOut="this.start()"  scrolldelay="120">
						<#if (toplist?exists) && (toplist?size>0) >
							<#list toplist as e>
									<#if e.gotourl?length gt 0>
										 <a href="${e.gotourl!""}"  target="_blank"  class="main"> 
									<#else>
										<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}"  target="_blank"  class="main">
									</#if> 
									<#if e.title?length lt 15 >
										${e.title!""}
									<#else>
										${e.title[0..14]}
									</#if>
										</a> &nbsp;&nbsp;&nbsp; 
							</#list>
						</#if>
					</marquee>   
				</div>
			</td>
		</tr>
	</table>
</div>
<div class="hg"></div>
<div class="box1">
	<div class="left1">
		<div class="hotpic">
			<div id="KinSlideshowid" style="visibility:hidden;">
			<#if (fdcxhWebAd?exists) && (fdcxhWebAd?size>0) >
				<#list fdcxhWebAd as e>
					<#if (e.rsstype?exists)&&(e.rsstype)?? && e_index lt 5>
						<#if e.rsstype==1>
							<a href="${e.linkurl!""}" target="_blank"><img src="/${e.adpath!""}" alt="${e.descr!""}" width="330" height="240" /></a>
					   </#if>
					</#if>
		   		</#list>
		   	</#if>
		  	</div>
		</div>
	</div>
	<div class="left2">
		<!--房管资讯讯开始-->
		<#if (toplist?exists) && (toplist?size>0) >
			<dl>
				<dt>
					最新资讯
				</dt>
				<dd>
					<ul>
						<#list toplist as e>
							<#if e_index == 0 >
								<li class="zi">
									<#if e.gotourl?length gt 0>
										 <a href="${e.gotourl!""}" title="${e.title!""}" target="_blank" class="main">
									<#else>
										<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}" title="${e.title!""}" target="_blank" class="main">
									</#if>
									<font color=#ff0306>
										<#if e.title?length lt 18 >
											${e.title!""}
										<#else>
											${e.title[0..17]}
										</#if>
									</font></a>
								</li>
							<#else>
								<li>
									<#if e.gotourl?length gt 0>
										 <a href="${e.gotourl!""}" title="${e.title!""}" target="_blank">
									<#else>
										<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}" title="${e.title!""}" target="_blank">
									</#if>
									<#if e.title?length lt 18 >
										${e.title!""}
									<#else>
										${e.title[0..17]}
									</#if>
									</a><span>[${e.webshowdate[5..9]}]</span>
								</li>
							</#if>
						</#list>
					</ul>
				</dd>
			</dl>
		</#if>
		<!--房管快讯结束-->
	</div>
	<div class="left3" style="background: url(/zjxh/images/xsfx007.png) no-repeat; width: 281px;">
		<dl>
			<dt class="divTop">
				协会简介
			</dt>
			<dd>
				<div>
					<p>
						德清县房地产中介行业协会在凯豪大酒店召开第一届会员大会，标志着筹备一年多的区房地产中介行业协会正式成立。<br/>
						区房地产中介行业协会由区房地产管理处筹备组织，得到了区民政局、区建设局的大力支持以及各房产中介机构的积极响应。<br/>
					</p>
				</div>
			</dd>
		</dl>
	</div>
</div>
<div class="hg"></div>
<div class="box1">
	<div class="left3" style="background: url(/zjxh/images/xsfx007.png) no-repeat; width: 281px;">
			<dt>
				<span><a href="/zjxh/newslist.jspx?categoryid=1001" target="_blank"> >>more</a> </span>政策法规
			</dt>
			<dl>
				<dd>
					<ul>
					<#if (zcfglist?exists) && (zcfglist?size>0) >
						<#list zcfglist as e>
							<li>
								<#if e.gotourl?length gt 0>
									 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
								<#else>
									<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}&categoryid=1001" target="_blank" title="${e.title!""}">
								</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
						</#list>
					</#if>
					</ul>
				</dd>
			</dl>
	</div>
	<div class="left3" style="background: url(/zjxh/images/xsfx009.png) no-repeat; width: 403px;">
		<dl>
			<dt>
				<span><a href="/zjxh/newslist.jspx?categoryid=1002" target="_blank"> >>more</a> </span>协会新闻
			</dt>
			<dd>
				<ul>
				<#if (xhxwlist?exists) && (xhxwlist?size>0) >
					<#list xhxwlist as e>
						<li>
							<#if e.gotourl?length gt 0>
								 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
							<#else>
								<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}&categoryid=1002" target="_blank" title="${e.title!""}">
							</#if> 
							<#if e.title?length lt 31 >
								${e.title!""}
							<#else>
								${e.title[0..30]}
							</#if>
								</a>
						</li>
					</#list>
				</#if>
				</ul>
			</dd>
		</dl>
	</div>
	<div class="left3" style="background: url(/zjxh/images/xsfx014.png) no-repeat; width: 252px; margin-right: 0px;">
		<dl>
			<dt>
				<span><a href="/zjxh/newslist.jspx?categoryid=1003" target="_blank">>> more</a> </span>通知公告
			</dt>
			<dd>
				<ul>
					<#if (tzgglist?exists) && (tzgglist?size>0) >
						<#list tzgglist as e>
							<li>
								<#if e.gotourl?length gt 0>
									 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
								<#else>
									<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}&categoryid=1003" target="_blank" title="${e.title!""}">
								</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
						</#list>
					</#if>
				</ul>
			</dd>
		</dl>
	</div>
</div>

<div class="hg"></div>
<div class="box1">
	<img src="/zjxh/images/xsfx015.jpg" width="950" height="95" />
</div>
<div class="hg"></div>
<div class="box1">
	<div class="left3" style="background: url(/zjxh/images/xsfx007.png) no-repeat; width: 281px;">
		
			<dl>
				<dt>
					<span><a href="/zjxh/newslist.jspx?categoryid=1004" target="_blank">>>more</a> </span>会员单位
				</dt>
				<dd>
					<ul>
					<#if (hydwlist?exists) && (hydwlist?size>0) >
						<#list hydwlist as e>
							<li>
								<#if e.gotourl?length gt 0>
									 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
								<#else>
									<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}&categoryid=1004" target="_blank" title="${e.title!""}">
								</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
						</#list>
					</#if>
					</ul>
				</dd>
			</dl>
	</div>
	<div class="left4">
		<img src="/zjxh/images/xsfx016.jpg" width="402" height="73" style="margin-bottom: 7px;" />
		<img src="/zjxh/images/xsfx017.jpg" width="402" height="72" style="margin-bottom: 7px;" />
		<img src="/zjxh/images/xsfx018.jpg" width="402" height="66" />
	</div>
	<div class="left3" style="background: url(/zjxh/images/xsfx014.png) no-repeat; width: 252px; margin-right: 0px;">
		
			<dl>
				<dt>
					<span><a href="/zjxh/newslist.jspx?categoryid=1005" target="_blank">>>more</a> </span>资料下载
				</dt>
				<dd>
					<ul>
					<#if (zlxzlist?exists) && (zlxzlist?size>0) >
						<#list zlxzlist as e>
							<li>
								<#if e.gotourl?length gt 0>
									 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
								<#else>
									<a href="/zjxh/news.jspx?contentid=${e.contentid?c!""}&categoryid=1005" target="_blank" title="${e.title!""}">
								</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
						</#list>
					</#if>
					</ul>
				</dd>
			</dl>
	</div>
</div>
		