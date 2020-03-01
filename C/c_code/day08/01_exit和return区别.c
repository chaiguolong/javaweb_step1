#include <stdio.h>
#include <stdlib.h>

void fun(){

	printf("in fun\n");

	//return ;

	exit(250);	//结束整个程序,结束进程
}

int main(int argc, char *argv[])
{

	fun();

	printf("after fun\n");

	while(1){

	}
	
	return 0;	//return作用:中断函数,中断main,程序就结束
}
