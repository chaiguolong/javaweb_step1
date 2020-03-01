#include <stdio.h>


//无参无返回值函数的定义
//1.没有返回值用void关键字修饰
//2.没有参数,也可以用void,或者空
//3.第一个void代表返回值,fun代表函数名字,()内部代表参数,空就是无参,{}就是函数体
//4.同一个文件,不能出现同名函数
//5.不同的函数,内部的函数是没有关系
void fun(){

	printf("我是无参无返回值函数的定义\n");

	//函数内部,包括()内部的变量,只有在调用时分配空间,调用完毕自动释放
	int a = 10;
	int b = 20;
	printf("a + b = %d\n", a+b);

}


int main(int argc, char *argv[])
{
	//1.除了main()函数,其他函数只有调用才会执行
	//2.函数的调用不可能出现void关键字
	//void fun()	//err
	//3.无参无返回值函数的调用的格式:fun();
	//fun(void)		//err
	//main函数的a,b和fun函数的a,b是没有关系的
	fun();

	return 0;
}

