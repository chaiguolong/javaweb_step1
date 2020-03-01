#include <stdio.h>
#include <stdlib.h>

void fun(int **tmp){
	*tmp = (int *)malloc(sizeof(int));
	**tmp = 100;
}


int main(int argc, char *argv[])
{
	int *p = NULL;

	fun(&p);

	printf("*p = %d\n", *p);


	
	return 0;
}
