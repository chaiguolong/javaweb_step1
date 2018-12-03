var menu_flag = true;
//menu
$(document).ready(function(){ 
	$('li.mainlevel').mousemove(function(){
		if(menu_flag) {
			menu_flag = false;
			$(this).find('ul').slideDown('normal',function() {
				menu_flag = true;
			});//you can give it a speed
		}
	});
	$('li.mainlevel').mouseleave(function(){
		$(this).find('ul').slideUp("fast");
	});
});


