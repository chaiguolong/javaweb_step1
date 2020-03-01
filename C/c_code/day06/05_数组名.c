#include <stdio.h>


int main(int argc, char *argv[])
{
	int a[10];
	//数组名是常量,不能修改
	//a = 10;	//err
	
	//数组名是数组首元素的地址
	printf("a = %p,a[0]=%p\n", a,&a[0]);

	//sizeof(数组名)测数组总大小: 10 * 4 = 40;
	int n = sizeof(a)/sizeof(a[0]);

	printf("n = %d\n", n);


	
	return 0;
}
