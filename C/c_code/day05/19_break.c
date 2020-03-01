#include <stdio.h>

int main(int argc, char *argv[])
{
	int i = 0;

	int j = 0;

	for (i = 0; i < 10; ++i) {
		for (j = 0; j < 10; ++j) {

			if(0 == j){
				break;//跳出的是内循环for (j = 0; j < 10; ++j) {}
			}
			
			printf("j = %d\n", j);
		}
	}

	return 0;
}

int main01(int argc, char *argv[])
{
	int i = 0;

	for (i = 0; i < 10; ++i) {

		if(5 == i){
			break;
		}
		printf("i = %d\n", i);
	}
	
	return 0;
}
