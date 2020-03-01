#include <stdio.h>

void fun(){
	int i = 0;
	i++;
	printf("i = %d\n", i);
}


void static_fun(){
	//1.在{}内部定义的变量就是局部变量
	//2.static局部变量,是在编译阶段就已经分配空间,函数没有调用前,它已经存在
	//3.当离开{},static局部变量不会释放,只有程序结束,static局部变量才会释放
	//4.局部变量的作用域在当前的{},离开此{},无法使用此变量
	//5.不同的{}中,变量名字可以一样,可以把{}比作房子,不同房子可以有同名的小伙伴
	//6.如果static局部变量不初始化,它的默认值为0
	//7.static局部变量初始化语句,只会执行一次,但可以赋值多次
	//8.static变量只能用常量初始化(注意)
	static int i = 0;
	i++;
	printf("static_fun i = %d\n", i);

	int a = 10;

	//static int j = a;	//使用变量a给static变量j初始化
}

int main(int argc, char *argv[])
{

	//fun();
	//fun();
	//fun();

	static_fun();
	static_fun();
	static_fun();
	
	return 0;
}
