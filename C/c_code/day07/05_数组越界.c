#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char src[] = "aaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbjj";

	char dst[10];

	strcpy(dst,src);

	printf("dst = %s\n", dst);
	
	return 0;
}
