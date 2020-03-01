#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//栈区的内存自动申请,自动释放,不需要程序手动管理
int* myFunc()
{
	int a = 10;
	
	//不要反悔局部变量的地址
	return &a;
}

void test01()
{
	//我们并不关心值是多少,因为局部变量a的内存已经被回收了
	int *p = myFunc();

	printf("*p:%d\n", *p);
	
}

char * getString(){
	char str[] = "hello world!";

	return str;
}

void test02()
{
	printf("getString(): %s\n", getString());
}


int main(int argc, char *argv[])
{
	
	return 0;
}
