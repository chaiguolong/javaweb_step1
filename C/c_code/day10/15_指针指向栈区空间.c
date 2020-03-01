#include <stdio.h>

int main(int argc, char *argv[])
{
	int *p;

	int a;

	p = &a;

	*p = 10;

	printf("*p = %d\n", *p);
	
	return 0;
}
