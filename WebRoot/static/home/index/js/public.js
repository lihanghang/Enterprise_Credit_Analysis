// menu菜单导航
$(function(){
	var n=0;
	var m=$(".dh_bg ul li.cur").index();
	var w=$(".dh_bg ul li").width();

	var dh_LI=$(".dh_bg ul li").length ;
	var R;
	var h_DL;

	$(".dh_bg_cur").css("left",(m*w))
	$(".dh_bg ul li").mouseenter(
		function(){
			n=$(this).index();
			$(".dh_bg_cur").stop().animate({left:(n*w)},200)
			$(this).addClass("cur")
			$(this).siblings().removeClass("cur")

			if (n>0) {
				$(".dh_bg .two_nav").hide().eq(n-1).fadeIn()
			}else{
				$(".dh_bg .two_nav").hide()
			}
			
			R=(dh_LI-(n+1))*86
			$(".dh_bg .two_nav").css("right",R)

			h_DL=$(".dh_bg .two_nav").eq(n-1).height();
			$(".dh_bg .two_nav").eq(n-1).find("dl").css("height",h_DL);

		}
	)
	$(".dh_bg").mouseleave(
		function(){
			$(".dh_bg ul li").eq(m).addClass("cur")
			$(".dh_bg ul li").eq(m).siblings().removeClass("cur")
			$(".dh_bg_cur").stop().animate({left:(m*w)},200)

			$(".dh_bg .two_nav").fadeOut()
		}
	)

	


})