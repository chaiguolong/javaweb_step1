<div class="nav">
	<ul id="name">
		德清县中介协会
	</ul>
	<ul id="menu">
		<#if (categorylist?exists) && (categorylist?size>0) >
			<#list categorylist as e>
				<#if e.pid = 1000>
					<li class="mainlevel" id="mainlevel_01">
						<#if e.url?length gt 0>
	        				<a href="${e.url!""}"  target="_blank">${e.name}</a> 
						<#else>
							<a href="/zjxh/newslist.jspx?categoryid=${e.categoryid?c!""}" target="_blank">${e.name}</a>
						</#if>
						<ul id="sub_02">
							<#list categorylist as son>
								<#if son.pid = e.categoryid>
									<li>
										<#if son.url?length gt 0>
						        			 <a href="${son.url!""}"  target="_blank">${son.name}</a> 
						        		<#else>
						        			<a href="/zjxh/newslist.jspx?categoryid=${son.categoryid?c!""}" target="_blank">${son.name}</a>
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

		