#include <stdio.h>
#include <string.h>
#include <stdlib.h>
	/*
	请参照本章例题，编写一个C程序，输出以下信息：
	**************************
	Hello World!
	**************************
	Hello与World之间有一个空格
	*也是输出的一部分，别光打印Hello World！
	*/
void printHelloWorld(){
	printf("**************************\n");
	printf("Hello World!\n");
	printf("**************************\n");
}

int main(int argc, char *argv[])
{
	printHelloWorld();
	
	return 0;
}
