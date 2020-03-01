#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void A()
{
	int param = malloc(100);
	B();
}

int B()
{
	int b = 20;

	return b;
	
}

int main(int argc, char *argv[])
{
	int a = 10;

	A();
	
	return 0;
}
