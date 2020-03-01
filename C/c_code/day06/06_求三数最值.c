#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 10;

	int b = 20;

	int c = 30;

	int max = a;

	if(b > max){

		max = b;

	}

	if(c > max){
		max = c;
	}

	printf("max = %d\n", max);

	
	return 0;
}

int main02(int argc, char *argv[])
{
	int a = 10;

	int b = 20;

	int c = 30;

	int max;

	max = (a > b ? a : b) > c ? (a > b ? a : b) : c;

	printf("max = %d\n", max);

	
	return 0;
}

int main01(int argc, char *argv[])
{
	int a = 10;

	int b = 20;

	int c = 30;

	int max;

	if(a > b){

		max = a;

	}else{

		max = b;

	}

	if(max < c){

		max = c;

	}

	printf("max = %d\n", max);

	
	return 0;
}
