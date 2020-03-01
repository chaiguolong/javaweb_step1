#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[3][4];
	int i = 0;
	int j = 0;
	int num =0;

	for (i = 0; i < 3; ++i) {
		for (j = 0;  j< 4; j++) {
			
			a[i][j] = num;
			num++;
		}
	}

	for (i = 0; i < 3; ++i) {
		for (j = 0; j < 4; ++j) {
			printf("%d,", a[i][j]);
		}
		printf("\n");
	}
	
	return 0;
}
