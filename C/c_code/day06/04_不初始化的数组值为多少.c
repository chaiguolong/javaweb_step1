#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[10];

	int i;

	for (i = 0; i < 10; ++i) {
		printf("%d,", a[i]);
	}
	printf("\n");
	
	return 0;
}
