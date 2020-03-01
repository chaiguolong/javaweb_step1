#include <stdio.h>

void swap(int m,int n){

	int tmp = m;

	m = n;

	n = tmp;

	printf("m = %d, n = %d\n", m, n);

}

void swap2(int *m,int *n){

	int tmp = *m;

	*m = *n;

	*n = tmp;

}
int main(int argc, char *argv[])
{
	int a = 10;

	int b = 20;

	swap(a,b);
	swap2(&a,&b);

	printf("a = %d, b = %d\n", a, b);

	
	return 0;
}
