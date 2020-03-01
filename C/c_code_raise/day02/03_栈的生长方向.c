#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void test()
{
	int a = 10;
	int b = 20;
	int c = 30;
	int d = 40;

	printf("a = %d\n", &a);
	printf("b = %d\n", &b);
	printf("c = %d\n", &c);
	printf("d = %d\n", &d);
}


int main(int argc, char *argv[])
{
	
	test();

	return 0;
}
