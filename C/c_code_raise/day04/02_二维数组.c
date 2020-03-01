#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void printByArray(int(*pArr)[3], int len1, int len2)
{
	for (int i = 0; i < len1; ++i) {
		for (int j = 0; j < len2; ++j) {
			//printf("%d ", *(*(pArr + i) +j));
			printf("%d ", pArr[i][j]);
		}
	}

	printf("\n");
}

void test01()
{
	int arr[3][3] = {
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}
	};

	printByArray(arr, 3, 3);

	//int arr[3][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	//int arr[][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	//对于二维数组,同一维数组一样,除了sizeof 和取地址以外,那么数组名就是指向数组首元素的指针

	//int(*pArray)[3] = arr;

	printf("%d\n", arr[2][1]);
	printf("*(*(arr + 2) +1) = %d\n", *(*(arr + 2) +1));
}

int main(int argc, char *argv[])
{
	test01();
	return 0;
}
