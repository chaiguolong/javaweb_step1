#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char *p = NULL;

	p = (char *)malloc(0);

	//以下代码错误
	if(p == NULL){
		printf("分配失败\n");
		return -1;
	}

	strcpy(p, "hellomike");

	printf("p = %s\n", p);
	
	return 0;
}
