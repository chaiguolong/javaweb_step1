#include<stdio.h>
#include<string.h>
#include<stdlib.h>
//宏函数不是一个真正的函数(指示预处理器进行简单的替换)
#define MYADD(x,y) ((x) + (y))
#define MAX 1024

//这个才是真正的函数	返回值 函数参数 函数体
int add(int a, int b)
{
	return a + b;
}


//宏函数在一定场景下,效率比函数高

int main(int argc, char *argv[])
{
	int a = 20;
	int b = 30;

	//以空间换时间
	//对于频繁使用 并且短小的函数 我们一般使用宏函数代替,因为宏函数没有普通函数的开销(函数压栈,跳转,返回等)
	printf("a + b = %d\n", ((a) + (b)));
	
	return 0;
}
