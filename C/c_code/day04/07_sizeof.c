#include <stdio.h>

int main(int argc, char *argv[])
{

	//数据类型的作用:告诉编译器,定义此类型变量需要分配多大空间
	printf("sizeof(char) = %lu\n", sizeof(char));

	int a;
	printf("sizeof(a) = %lu\n", sizeof(a));

	int len = sizeof(a);

	printf("%d\n", len);

	return 0;
}
