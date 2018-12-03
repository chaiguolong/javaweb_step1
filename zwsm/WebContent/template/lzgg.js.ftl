function getLzgg() {
	var str = '';
	<#if noticelist?exists>
	<#list noticelist as n>
	str += '<tr height="25">${n}</tr>';
	</#list>
	</#if>
	return str;
}
