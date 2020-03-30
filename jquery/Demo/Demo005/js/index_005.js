$(function(){
	/*
	 *	diff > 0
	 *	diff = 0
	 *	diff < 0
	 *
	 */



	//初始化page
	var curPage = 1;
	var oldPage = 0;
	var diffPage = 0;
	var timer1;
	var timer2;

	$('.nav-btn').on('click', function(){
		oldPage = curPage;
		curPage = $(this).index() + 1;
		diffPage = curPage - oldPage;
		//去除所有的active,加上当前的active
		$('.nav-btn').removeClass('active');
		$('.nav-'+curPage).addClass('active');
		if(diffPage > 0){
			window.clearTimeout(timer2);
			//当前+in,老的+small
			timer2 = window.setTimeout(function(){
				for (var i = oldPage; i < curPage; i++) {
					$(".page-"+ i).addClass("small");
					$(".page-"+ i +" .half").addClass("in");
				}
			},100);


			$(".page-"+curPage+" .half").addClass("in");
		}
		if(diffPage < 0){
			window.clearTimeout(timer1);

			for (var i = curPage + 1; i < oldPage; i++) {
				$(".page-"+ i +" .half").removeClass("in");
				$(".page-"+ i).removeClass("small");
			}

			//当前去small,老的去in,延迟处理,避免中间的page没有先隐藏了
			timer1 = window.setTimeout(function(){
				$(".page-"+oldPage+" .half").removeClass("in");
				$(".page-"+curPage).removeClass("small");

			},100);

		}
	});

	function next(curPage,oldPage){
		//旧的page添加small
		$('.page-'+oldPage).addClass('small');
		$('.nav-'+oldPage).removeClass('active');
		$('.page-'+curPage+' .half').addClass('in');
		$('.nav-'+curPage).addClass('active');
	}

	function up(curPage,oldPage){
		//旧的page移出small
		$('.page-'+oldPage+' .half').removeClass('in');
		$('.nav-'+oldPage).removeClass('active');
		$('.page-'+curPage).removeClass('small');
		$('.nav-'+curPage).addClass('active');
	}

	$('.next').click(function(){
		if(curPage== 4){
			return;
		}
		oldPage = curPage;
		curPage++;
		next(curPage,oldPage);

	});

	$('.up').click(function(){
		if(curPage== 1){
			return;
		}
		oldPage = curPage;
		curPage--;
		up(curPage,oldPage);
	});

});
