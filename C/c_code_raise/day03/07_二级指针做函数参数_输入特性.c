#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void printArray(int **arr, int len)
{
	for (int i = 0; i < len; ++i) {
		printf("%d ", *arr[i]);
	}
	printf("\n");
}

void test01()
{
	//堆上分配指针内存
	int **pArray = malloc(sizeof(int *) * 6);

	//栈上分配数据空间
	int a1 = 100;
	int a2 = 200;
	int a3 = 300;
	int a4 = 400;
	int a5 = 500;
	int a6 = 600;

#if 0
	pArray[0] = &a1;
	pArray[1] = &a2;
	pArray[2] = &a3;
	pArray[3] = &a4;
	pArray[4] = &a5;
	pArray[5] = &a6;
#endif
	*(pArray + 0) = &a1;
	*(pArray + 1) = &a2;
	*(pArray + 2) = &a3;
	*(pArray + 3) = &a4;
	*(pArray + 4) = &a5;
	*(pArray + 5) = &a6;

	printArray(pArray, 6);

	//释放数组指针
	if(pArray != NULL){
		free(pArray);
		pArray = NULL;
	}
}

void test02()
{
	int * pArray[5] = {0};

	for (int i = 0; i < 5; ++i) {
		pArray[i] = malloc(4);
		*pArray[i] = 100 + i;
	}

	printArray(pArray, 5);

	//释放堆内存
	for (int i = 0; i < 5; ++i) {
		if(NULL != pArray[i]){
			free(pArray[i]);
			pArray[i] = NULL;
		}
	}

}

int main(int argc, char *argv[])
{
	//test01();
	test02();
	
	return 0;
}
