#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	//语法上没有问题,栈区分配很大的内存,越界了,导致段错误
	//int a[100000000000000] = {0};
	
	int *p = (int *) malloc(10000000000000000 * sizeof(int));

	if(p == NULL){
		printf("分配失败\n");
	}
	
	return 0;
}
