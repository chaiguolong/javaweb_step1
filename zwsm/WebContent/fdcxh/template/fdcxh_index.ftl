<div class="topsearch">
	<table width="100%" height="30" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="8"></td>
			<td width="200">
				<div class="c" id="date">2013年5月08日星期三</div>
			</td>
			<td>
				<div class="d">
					<marquee onMouseOver="this.stop()" onMouseOut="this.start()"  scrolldelay="120">
						<#if (hotlink?exists) && (hotlink?size>0) >
				            <#list hotlink as e>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank"  class="main"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhdtid?c!""}"  target="_blank"  class="main">
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
				<#list fdcxhWebAd as e>
			        <#if (e.rsstype?exists)&&(e.rsstype)?? && e_index lt 5>
						<#if e.rsstype==1>
							<a href="${e.linkurl!""}" target="_blank"><img src="/${e.adpath!""}" alt="${e.descr!""}" width="330" height="240" /></a>
			           </#if>
			        </#if>
		   		</#list>
		  	</div>
		</div>
	</div>
	<div class="left2">
		<!--房管资讯讯开始-->
		<#if (fdcnewinfo?exists) && (fdcnewinfo?size>0) >
			<dl>
				<dt>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020228" target="_blank">>> more</a> </span>最新资讯
				</dt>
				<dd>
					<ul>
						<#list fdcnewinfohead as e>
							<#if e_index == 0 >
								<li class="zi">
									<#if e.gotourl?length gt 0>
				            			 <a href="${e.gotourl!""}" title="${e.title!""}" target="_blank" class="main">
				            		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${fczxid?c!""}" title="${e.title!""}" target="_blank" class="main">
				            		</#if>
									<font color=#ff0306>
										<#if e.title?length lt 18 >
											${e.title!""}
										<#else>
											${e.title[0..17]}
										</#if>
									</font></a>
								</li>
							</#if>
						</#list>
						<#list fdcnewinfo as e>
			            	<li>
			            		<#if e.gotourl?length gt 0>
			            			 <a href="${e.gotourl!""}" title="${e.title!""}" target="_blank">
			            		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${fczxid?c!""}" title="${e.title!""}" target="_blank">
			            		</#if>
				            	<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
				            	</a><span>[${e.webshowdate[5..9]}]</span>
			            	</li>
			            </#list>
		            </ul>
				</dd>
			</dl>
        </#if>
		<!--房管快讯结束-->
	</div>
	<div class="right1">
		<dl>
			<dt class="divTop" id="myTop1">
				<ul>
					<li>
						协会简介
					</li>
					<li class="hover">
						协会章程
					</li>
					<li>
						组织机构
					</li>
				</ul>
			</dt>
			<dd id="myCont1">
				<#if (xhjj?exists) && (xhjj?size>0) >
		            <#list xhjj as e>
		            	<div>
							<p>
				            	<#if e.descr?length lt 150 >
									${e.descr!""}
								<#else>
									${e.descr[0..149]}
								</#if>
				            	<#if e.gotourl?length gt 0>
			            			 <a href="${e.gotourl!""}"  target="_blank"> 
			            		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhgsid?c!""}" target="_blank" title="${e.title!""}">
			            		</#if>
									<font color="#1e8ebc">[查看详情]</font></a>
		            		</p>
						</div>
		            </#list>
		        </#if>
		        <#if (xhzc?exists) && (xhzc?size>0) >
		            <#list xhzc as e>
		            	<div>
							<p>
				            	<#if e.descr?length lt 150 >
									${e.descr!""}
								<#else>
									${e.descr[0..149]}
								</#if>
				            	<#if e.gotourl?length gt 0>
			            			 <a href="${e.gotourl!""}"  target="_blank"> 
			            		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhgsid?c!""}" target="_blank" title="${e.title!""}">
			            		</#if>
									<font color="#1e8ebc">[查看详情]</font></a>
		            		</p>
						</div>
		            </#list>
		        </#if>
		        <#if (zzjg?exists) && (zzjg?size>0) >
		            <#list zzjg as e>
		            	<div>
							<p>
				            	<#if e.descr?length lt 150 >
									${e.descr!""}
								<#else>
									${e.descr[0..149]}
								</#if>
				            	<#if e.gotourl?length gt 0>
			            			 <a href="${e.gotourl!""}"  target="_blank"> 
			            		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhgsid?c!""}" target="_blank" title="${e.title!""}">
			            		</#if>
									<font color="#1e8ebc">[查看详情]</font></a>
		            		</p>
						</div>
		            </#list>
		        </#if>
			</dd>
		</dl>
	</div>
</div>
<div class="hg"></div>
<div class="box1">
	<div class="left3" style="background: url(/fdcxh/images/xsfx007.png) no-repeat; width: 281px;">
		<#if (ggtz?exists) && (ggtz?size>0) >
			<dt>
				<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020181" target="_blank"> >>more</a> </span>公告通知
			</dt>
        	<dl>
				<dd>
					<ul>
						<#list ggtz as e>
							<li>
				            	<#if e.gotourl?length gt 0>
				        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
				        		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhdtid?c!""}" target="_blank" title="${e.title!""}">
				        		</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
					    </#list>
					</ul>
				</dd>
			</dl>
        </#if>
	</div>
	<div class="left3" style="background: url(/fdcxh/images/xsfx009.png) no-repeat; width: 403px;">
		<dl>
			<#if (fcxw?exists) && (fcxw?size>0) >
				<dt>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020229" target="_blank"> >>more</a> </span>房产新闻
				</dt>
            	<dd>
					<ul>
						<#list fcxw as e>
							<li>
				            	<#if e.gotourl?length gt 0>
				        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
				        		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${fczxid?c!""}" target="_blank" title="${e.title!""}">
				        		</#if> 
								<#if e.title?length lt 31 >
									${e.title!""}
								<#else>
									${e.title[0..30]}
								</#if>
									</a>
							</li>
						</#list>
					</ul>
				</dd>
	        </#if>
		</dl>
	</div>
	<div class="right2">
		<dl>
			<dt class="divTop" id="myTop2">
				<ul>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020231" target="_blank">>> more</a> </span>
					<li class="hover">
						楼市日评
					</li>
					<li>
						德清楼市
					</li>
				</ul>
			</dt>
			<dd id="myCont2">
				<div>
					<ul>
						<#if (lsrp?exists) && (lsrp?size>0) >
				            <#list lsrp as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${fczxid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
				<div>
					<ul>
						<#if (xsls?exists) && (xsls?size>0) >
				            <#list xsls as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${fczxid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
			</dd>
		</dl>
	</div>
</div>

<div class="hg"></div>
<div class="box1">
	<div class="right3">
		<dl>
			<dt class="divTop" id="myTop4">
				<ul>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020239" target="_blank">>> more</a> </span>
					<li class="hover">
						会员动态
					</li>
					<li>
						会员风采
					</li>
					<li>
						入会指南
					</li>
				</ul>
			</dt>
			<dd id="myCont4">
				<div>
					<ul>
						<#if (hydt?exists) && (hydt?size>0) >
				            <#list hydt as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhyhid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
				<div>
					<ul>
						<#if (hyfc?exists) && (hyfc?size>0) >
				            <#list hyfc as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhyhid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
				<div>
					<ul>
						<#if (rhzn?exists) && (rhzn?size>0) >
				            <#list rhzn as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhyhid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
			</dd>
		</dl>
	</div>

	<div class="right3" style="width: 401px;">
		<dl>
			<dt class="divTop" id="myTop3"
				style="background: url(/fdcxh/images/xsfx013.png) no-repeat">
				<ul>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020167" target="_blank">>> more</a> </span>
					<li class="hover">
						协会要闻
					</li>
					<li>
						协会通讯
					</li>
					<li>
						会务公开
					</li>
				</ul>
			</dt>
			<dd id="myCont3">
				<div>
					<ul>
						<#if (xhyw?exists) && (xhyw?size>0) >
				            <#list xhyw as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhdtid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
				<div>
					<ul>
						<#if (xhtx?exists) && (xhtx?size>0) >
				            <#list xhtx as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhdtid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
				<div>
					<ul>
						<#if (hwgk?exists) && (hwgk?size>0) >
				            <#list hwgk as e>
				            	<li>
				            		<#if e.gotourl?length gt 0>
					        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
					        		<#else>
					            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhdtid?c!""}" target="_blank" title="${e.title!""}">
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
				</div>
			</dd>
		</dl>
	</div>
	<div class="left3" style="background: url(/fdcxh/images/xsfx014.png) no-repeat; width: 252px; margin-right: 0px;">
		<#if (zcfg?exists) && (zcfg?size>0) >
			<dl>
				<dt>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020230" target="_blank">>>more</a> </span>政策法规
				</dt>
				<dd>
					<ul>
			            <#list zcfg as e>
			            	<li>
			            		<#if e.gotourl?length gt 0>
				        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
				        		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${fczxid?c!""}" target="_blank" title="${e.title!""}">
				        		</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
			            </#list>
		            </ul>
				</dd>
			</dl>
        </#if>
	</div>
</div>
<div class="hg"></div>
<div class="box1">
	<img src="/fdcxh/images/xsfx015.jpg" width="950" height="95" />
</div>
<div class="hg"></div>
<div class="box1">
	<div class="left3" style="background: url(/fdcxh/images/xsfx007.png) no-repeat; width: 281px;">
		<#if (pxxx?exists) && (pxxx?size>0) >
			<dl>
				<dt>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020245" target="_blank">>>more</a> </span>培训信息
				</dt>
				<dd>
					<ul>
			            <#list pxxx as e>
			            	<li>
			            		<#if e.gotourl?length gt 0>
				        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
				        		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhfwid?c!""}" target="_blank" title="${e.title!""}">
				        		</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
			            </#list>
		            </ul>
				</dd>
			</dl>
        </#if>
	</div>
	<div class="left4">
		<img src="/fdcxh/images/xsfx016.jpg" width="402" height="73" style="margin-bottom: 7px;" />
		<img src="/fdcxh/images/xsfx017.jpg" width="402" height="72" style="margin-bottom: 7px;" />
		<img src="/fdcxh/images/xsfx018.jpg" width="402" height="66" />
	</div>
	<div class="left3" style="background: url(/fdcxh/images/xsfx014.png) no-repeat; width: 252px; margin-right: 0px;">
		<#if (xzzx?exists) && (xzzx?size>0) >
			<dl>
				<dt>
					<span><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=28020246" target="_blank">>>more</a> </span>下载中心
				</dt>
				<dd>
					<ul>
			            <#list xzzx as e>
			            	<li>
			            		<#if e.gotourl?length gt 0>
				        			 <a href="${e.gotourl!""}"  target="_blank" title="${e.title!""}"> 
				        		<#else>
				            		<a href="/xh/WebFdcxhAction_news.jspx?contentid=${e.contentid?c!""}&categoryid=${xhfwid?c!""}" target="_blank" title="${e.title!""}">
				        		</#if> 
								<#if e.title?length lt 18 >
									${e.title!""}
								<#else>
									${e.title[0..17]}
								</#if>
									</a>
							</li>
			            </#list>
		            </ul>
				</dd>
			</dl>
        </#if>
	</div>
</div>
		