#include <stdio.h>

int main(int argc, char *argv[])
{
	int i = 0;
	
	int j = 0;

	int num = 0;

	for (i = 0; i < 10; ++i) {
		for (j = 0; j < 10; ++j) {
			num++;
		}
	}

	printf("num = %d\n", num);
	
	return 0;
}
