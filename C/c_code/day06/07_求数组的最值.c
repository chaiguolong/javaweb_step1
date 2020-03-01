#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[10] = {13,38,76,23,54,2,43,23,111,10};

	int max = a[0];

	int i;

	for (i = 1; i < 10; ++i) {
		if(a[i] > max){
			max = a[i];
		}
	}

	printf("max = %d\n", max);
	
	return 0;
}
