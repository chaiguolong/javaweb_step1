#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[9] = {7,5,9,2,4,6,8,0,3};

	int n = sizeof(a) / sizeof(a[0]);

	int i = 0;

	int j = 0;

	int tmp;

	printf("排序前:\n");

	for (i = 0; i < n; ++i) {
		
		printf("%d,", a[i]);

	}

	printf("\n");


	for (i = 0; i < n-1; ++i) {
		for (j = 0; j < n-1-i; ++j) {

			if(a[j+1] < a[j]){	//相邻两个元素交换,大于交换

				tmp = a[j];

				a[j] = a[j+1];

				a[j+1] = tmp;

			}

		}
	}


	printf("排序后:\n");

	for (i = 0; i < n; ++i) {
		
		printf("%d,", a[i]);

	}

	printf("\n");
	
	return 0;
}
