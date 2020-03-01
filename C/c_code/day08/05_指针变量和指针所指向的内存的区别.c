#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 10;
	//*有2层含义
	//1.定义变量时,*代表类型,它是指针类型int *;
	int * p;
	p = &a;

	//2.在使用变量时,*代表操作指针所指向的内存;
	*p = 100;
	printf("a = %d\n", a);

	int b = 11;
	p = &b;
	*p = 200;
	printf("a = %d, b = %d\n", a, b);


	
	return 0;
}
