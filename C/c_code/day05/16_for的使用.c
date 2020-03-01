#include <stdio.h>


int main(int argc, char *argv[])
{
	int i = 1;

	int sum = 0;

	for (i = 0; i < 101; ++i) {
		sum += i;
	}

	printf("sum = %d\n", sum);
	
	return 0;
}
