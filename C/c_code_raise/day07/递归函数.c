#include <stdio.h>
#include <string.h>
#include <stdlib.h>


void reversePrint(char *p){
	//首先要写出递归退出条件
	if(*p == '\0'){
		return;
	}

	reversePrint(p + 1);
	printf("%c", *p);
}

int main(int argc, char *argv[])
{
	char *s = "abcdefg";
	reversePrint(s);
	printf("\n");
	
	return 0;
}
