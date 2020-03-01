#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.指针的加法,不是传统的加法
	//2.步长由指针指向的数据类型决定
	
	int a;

	int *p;

	p = &a;

	char b;

	char *q;

	q = &b;

	printf("p = %d, p+1 = %d\n", p, p+1);

	printf("q = %d, q+1 = %d\n", q, q+1);


	return 0;
}
