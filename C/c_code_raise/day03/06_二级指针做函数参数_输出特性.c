#include<stdio.h>
#include<string.h>
#include<stdlib.h>


void allocationSpace(int **temp)
{
	int *arr = malloc(sizeof(int) * 10);

	int i = 0;
	for (i = 0; i < 10; ++i) {
		arr[i] = i + 1;
	}

	//指针间接赋值
	*temp = arr;
}

void printArray(int *arr, int len)
{
	for (int i = 0; i < len; ++i) {
		printf("%d ", arr[i]);
	}
	printf("\n");
}
#if 0
	void freeSpace(void *arr)
	{
		if(NULL == arr){
			return ;
		}

		free(arr);
		arr = NULL;
	}
#else
	void freeSpace(int **arr)
	{
		if(NULL == arr){
			return ;
		}

		if(NULL != *arr){
			free(*arr);
			*arr = NULL;
			arr = NULL;
		}
	}

#endif

void test01()
{
	int *pArray = NULL;
	allocationSpace(&pArray);
	printArray(pArray, 10);
#if 0
	freeSpace(pArray);
	pArray = NULL;
#endif
	freeSpace(&pArray);
	if(NULL == pArray){
		printf("pArray被置空\n");
	}
}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
