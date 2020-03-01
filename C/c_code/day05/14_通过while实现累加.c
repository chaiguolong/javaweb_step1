#include <stdio.h>

int main(int argc, char *argv[])
{
	int num = 1;

	int sum = 0;

	while(num <= 100){
		sum = sum + num;
		num++;
	}

	printf("sum = %d\n", sum);
	
	return 0;
}
