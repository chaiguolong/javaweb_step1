#include <stdio.h>

int main(int argc, char *argv[])
{
	char a = 127 + 1;
	
	printf("%d\n", a);

	unsigned char b = 255 + 2;

	printf("%u\n", b);

	return 0;
}
