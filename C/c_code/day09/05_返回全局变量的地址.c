#include <stdio.h>

int a;

int *fun(){
	return &a;
}

int main(int argc, char *argv[])
{
	int *p = NULL;

	p = fun();

	*p = 100;

	*fun() = 111;

	printf("*p = %d\n", *p);
	printf("a = %d\n", a);


	

	return 0;
}
