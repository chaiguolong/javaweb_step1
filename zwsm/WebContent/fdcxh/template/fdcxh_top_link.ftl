<div class="nav">
	<ul id="name">
		德清县房地产协会
	</ul>
	<ul id="menu">
		<#if (categorylist?exists) && (categorylist?size>0) >
			<#list categorylist as e>
				<#if e.pid = 28020155>
					<li class="mainlevel" id="mainlevel_01">
						<#if e.url?length gt 0>
	        				<div class="title"><a href="${e.url!""}"  target="_blank">${e.name}</a></div>
						<#else>
							<div class="title"><a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=${e.categoryid?c!""}" target="_blank">${e.name}</a></div>
						</#if>
						<ul id="sub_02">
							<#list categorylist as son>
								<#if son.pid = e.categoryid>
									<li>
										<#if son.url?length gt 0>
						        			 <a href="${son.url!""}"  target="_blank">${son.name}</a> 
						        		<#else>
						        			<a href="/xh/WebFdcxhAction_newslist.jspx?categoryid=${son.categoryid?c!""}" target="_blank">${son.name}</a>
						        		</#if> 
									</li>
								</#if>
							</#list>
						</ul>
					</li>
				</#if>
			</#list>
		</#if>
	<div class="clear"></div>
	</ul>
</div>

		