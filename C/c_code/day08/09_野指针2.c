#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 10;

	int *p;

	p = &a;

	int b = *p;

	*p = 111;

	printf("a = %d, b = %d\n", a, b);
	
	return 0;
}
