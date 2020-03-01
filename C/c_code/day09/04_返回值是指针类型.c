#include <stdio.h>

int * fun(){
	int a;
			
	return &a;	//linux64位不允许返回局部变量的地址
}

int main(int argc, char *argv[])
{
	int *p = NULL;

	p = fun();	//接受函数的地址

	*p = 100;	//操作指针所指向的内存
	
	return 0;
}
