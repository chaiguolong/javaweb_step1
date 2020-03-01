#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[10];

	//1.数组名是数组首元素地址
	printf("a = %p, a[0] = %p\n", a, &a[0]);

	//2.数组名是常量,不允许修改, int * const p;
	//a = 10; //err
	
	return 0;
}
