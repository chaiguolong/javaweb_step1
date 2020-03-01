#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void test()
{
	int a = 0xaabbccdd;

	unsigned char *p = &a;

	printf("%x\n", *p);
	printf("%x\n", *(p+1));

}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
