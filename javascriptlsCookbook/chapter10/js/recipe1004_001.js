window.onload=function(){
	try {
		someFunction(var1);
	} catch (e) {
		alert(e.message);
	}finally{
		j=null;
	}
}
