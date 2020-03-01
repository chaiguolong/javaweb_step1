#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.空指针,给指定变量赋值为NULL
	//2.NULL就是数字0
	int *p = NULL;

	/*
	 int * p;
	 p = NULL;
	 */

	int a = 11;

	p = &a;

	if(p != NULL){
		*p = 100;
	}
	
	return 0;
}
