#include <stdio.h>

int main(int argc, char *argv[])
{
	//使用函数前,声明函数
	//声明函数,extern可有可无
	//声明可以多次
	extern void test();

	test();	//函数调用

	//使用全局变量,先声明
	extern int a;
	extern int b;

	a = 111;

	b = 222;


	
	return 0;
}
