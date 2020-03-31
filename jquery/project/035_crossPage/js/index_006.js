$(function(){
	var i = 0;
	var picLength = $(".pic").length;

	$(".container").one("mousewheel", go_mouse);

	function go_mouse(event){
		if(i != 0){
			$(".arrow").removeClass("in");
		}
	

		if(event.deltaY < 0){
			i++;
			if(i >= picLength -1){
				i = picLength -1;
				$(".arrow").addClass("in");
			}
		}else{
			i--;
			if(i <= 0){
				i = 0;
			}
		}
		//整个容器下移一页
		$(".container").css("top","-"+100*i+"%");
		//先remove所有的active
		$(".nav li").removeClass("active");
		$('.nav li:eq('+i+')').addClass("active");

		//递归运行go函数,解决one()方法只运行一次
		window.setTimeout(function(){
			$(".container").one("mousewheel", go_mouse);
		},1100);
	}

	$(".arrow").one("click", go);

	function go(){
		//判断是不是第一个页面,因为后面要++,所以设置为-1,+1后为0,0*-100%=0,跳到第一个页面
		if(i == 5){
			$(".arrow").removeClass("in");
			i = -1;
		}

		i++;
		//整个容器下移一页
		$(".container").css("top","-"+100*i+"%");
		//先remove所有的active
		$(".nav li").removeClass("active");
		$('.nav li:eq('+i+')').addClass("active");

		//判断有没有到最后一页,到最后一页,添加向上箭头,跳到第一页
		if(i >= picLength - 1){
			i = picLength - 1;
			$(".arrow").addClass("in");
		}

		//递归运行go函数,解决one()方法只运行一次
		window.setTimeout(function(){
			$(".arrow").one("click", go);
		},1000);
	}

	$('.nav li').on('click', function(index){

		//获取点击的Li的索引,作为i
		i = $(this).index();
		//要放在获取index之后再进行比较是否相等
		if(i != (picLength -1)){
			$(".arrow").removeClass("in");
		}
		$(".container").css("top","-"+100*i+"%");
		//先remove所有的active
		$(".nav li").removeClass("active");
		$('.nav li:eq('+i+')').addClass("active");

		if(i >= picLength - 1){
			i = picLength - 1;
			$(".arrow").addClass("in");
		}
	});




});
