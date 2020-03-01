#include <stdio.h>

int main(int argc, char *argv[])
{
	int **********p;

	p = 0x1122;

	int ***********q;

	q = &p;

	*q = 0xaabb;

	printf("p = %x\n", p);

	*p = 0xbbcc;

	
	return 0;
}
