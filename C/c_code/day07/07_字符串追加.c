#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char src[] = " hello mike";

	char dst[100] = "abc";

	//strcat(dst,src);

	//strcpy(dst,src);
	
	strncat(dst,src,strlen(" hello "));

	printf("dst = %s\n", dst);


	
	return 0;
}
