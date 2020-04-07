$(function(){
	/*
	 *	
	 *	1.在jquery的eq方法中传入参数时是变量的时候需要对变量进行字符串拼接; 
	 *	
	 *	2.background-size: 
	 *		cover:		缩放背景图片以完全覆盖背景区，可能背景图片部分看不见。 
	 *					和contain 值相反，cover 值尽可能大的缩放背景图像并保持图像的宽高比例（图像不会被压扁）。 
	 *					该背景图以它的全部宽或者高覆盖所在容器。 当容器和背景图大小不同时，背景图的 左/右 或者 上/下 部分会被裁剪。 
	 *		contain:	缩放背景图片以完全装入背景区，可能背景区部分空白。
	 *					contain 尽可能的缩放背景并保持图像的宽高比例（图像不会被压缩）。
	 *					该背景图会填充所在的容器。当背景图和容器的大小的不同时，容器的空白区域（上/下或者左/右）会显示由 background&#45;color 设置的背景颜色。 
	 *		percentage:	父元素如果为100%的宽和高,那么设置背景图片的尺寸为(background-size:100%)100%,则图片尺寸会和缩放浏览器的尺寸一同缩放,
	 *					也就是在缩放浏览器的视图的情况下,图片在视觉上不会改变大小尺寸.
	 *
	 *	3.transform: 
	 *		translateY(-50%):在Y轴方向,移动元素本身高度的50%;先将整体元素绝对定位,在将元素top:50%,然后移动元素本身的高度50%,达到元素居中的目的.
	 *
	 *	4.list-style与list-style-type的区别:
	 *		1.list-style是对列表标签的缩写，而list-style-type是其中的一个属性，而list-style一共可以包含三个值:
	 *		list-style:list-style-type|list-style-position|list-style-image
	 *		因此，要去掉一个列表前面的默认符号，使用以上的两种方法都是可以的！
	 *
	 *	5.transform-origin:50% 50%
	 *		1.transform-origin的用法是对元素进行变换或者旋转时,设置变换或者旋转时的原点,也就是变换或者旋转时的基点.
	 *
	 *	6.transition的作用点在于同一个元素,同一个元素的两个状态中的属性不同,导致出现了动画的效果
	 *
	 *	7.background-size: 100%;:
	 *		父元素如果为100%的宽和高,那么设置背景图片的尺寸为100%,则图片尺寸会和缩放浏览器的尺寸一同缩放,也就是在缩放浏览器的视图的情况下,
	 *		图片在视觉上不会改变大小尺寸.
	 *
	 *	8.border-bottom: 50px solid transparent; transparent透明的意思,可以利用它来画出不规则的形状;
	 *
	 *	9.height: 100vh; vh流式布局中的单位,vh:view height;vw: view width;
	 *
	 *	10.transform: skew();对元素进行歪曲,斜切,可以做出平行四边形等
	 *
	 *	11.perspective: 50:perspective属性为人眼到元素中心的距离,translateZ为元素往人眼方向移动的距离,
	 *		当translateZ > perspective(50)时,则没有透视,因为元素已经跑到人眼的后面,所以看不到.
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */



});
