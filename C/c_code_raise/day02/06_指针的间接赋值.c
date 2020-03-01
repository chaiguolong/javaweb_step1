#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void changeValue(int *p)
{
	*p = 100;
}

void test01()
{
	int a = 10;
	changeValue(&a);
	printf("a = %d\n", a);

}

void changePointer(int **val)
{
	*val = 0x008;
}

void test02()
{
	int *p = NULL;
	changePointer(&p);
	printf("p = %x\n", p);

}

int main(int argc, char *argv[])
{
	//test01();
	test02();
	
	return 0;
}
