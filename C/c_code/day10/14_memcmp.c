#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	int a[10] = {1,2,3,4,5,6,7,8,9,10};

	int b[10] = {1,2,3,4,5,6,7,8,9,11};

	int flag = memcmp(a, b, 9 * sizeof(int));

	if(flag > 0){

		printf("a > b\n");

	}else if(flag < 0){

		printf("a < b\n");

	}else{

		printf("a == b\n");

	}

	
	return 0;
}
