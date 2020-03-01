#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char str[] = "              123456789          ";

	char *start = str;

	char *end = str + strlen(str) -1;

	int n = 0;

	//从左往右
	while(*start == ' ' && *start != '\0'){
		start++;
	}

	//从右往左
	while(*end == ' ' && end != str){
		end--;
	}

	n = end -start +1;

	printf("n = %d\n", n);

	char buf[100] = "aaaaaaaaaaaaaaaaaaaaaaaaaa";

	strncpy(buf,start,n);

	buf[n] = '\0';

	printf("buf = %s\n", buf);


	
	return 0;
}
