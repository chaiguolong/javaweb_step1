#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.指针也是一种数据类型
	
	//p是一个变量,p的类型是int *;
	int * p;
	p = 123;
	printf("%d\n", p);

	//2.指针指向谁,就把谁的地址赋值给指针
	int a = 10;

	p = &a;

	//%p打印地址,是以16进制方式打印
	printf("%p, %p\n", p, &a);

	//3.直接操作指针变量,没有意义
	//4.需要操作*p,操作指针所指向的内存
	*p = 100; //*p相当于a
	printf("%d, %d\n", *p, a);
	

	return 0;
}
