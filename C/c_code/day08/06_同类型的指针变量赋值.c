#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 10;

	int *p = &a;

	*p = 111;

	int *q;

	q = p;

	*q = 222;

	printf("&a = %p, p = %p, q = %p\n", &a, p, q);

	printf("a = %d, *p = %d, *q = %d\n", a, *p, *q);



	
	return 0;
}
