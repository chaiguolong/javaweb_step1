#include <stdio.h>
#include <stdlib.h>

void fun(int **tmp){
	int *p = (int *)malloc(sizeof(int));

	*p = 10;

	*tmp = p;
}


int main(int argc, char *argv[])
{
	int *p = NULL;

	fun(&p);

	printf("*p = %d\n", *p);

	if(p == NULL){
		free(p);
		p = NULL;
	}


	
	return 0;
}
