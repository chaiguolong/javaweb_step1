#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//当你操作某块内存的时候,这块内存一定要是合法的(自己申请的,在使用的时候)
int main(int argc, char *argv[])
{
	char *p = malloc(64);

	++p;

	if(NULL != p){
		free(p);
		p = NULL;
	}
	
	return 0;
}
