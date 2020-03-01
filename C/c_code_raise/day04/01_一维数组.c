#include<stdio.h>
#include<string.h>
#include<stdlib.h>


void printArray(int arr[], int len)
{
	for (int i = 0; i < len; ++i) {
		printf("arr[i] = %d ", arr[i]);
	}

	printf("\n");
}

void test01()
{
	int arr[] = {1, 2, 3, 4};

	//1.sizeof		2.对数组名取地址&arr
	//以上两种情况下,数组名不是指向首元素的地址
	//以上两种情况下,数组名是数组类型
	//!除了以上两点之外,数组名在其他任何情况都是指向首元素的地址

	printf("sizeof(arr) = %lu\n", sizeof(arr));

	printf("&arr = %d\n", &arr);
	printf("&arr + 1  = %d\n", &arr + 1 );

	//int *p = arr;

	//数组名是一个常量指针,不能修改
	//arr = NULL;
	
	printArray(arr,sizeof(arr)/sizeof(arr[0]));
}

//如何定义一个可以指向数组的指针
void test02()
{
	int arr[5] = {1, 2, 3, 4, 5};
	//我们先定义数组类型,在定义数组指针类型
	typedef int(ARRAY_TYPE)[5];		//typedef unsigned int u32;

	ARRAY_TYPE myarray;		//int myarray[5]

	for (int i = 0; i < 5; ++i) {
		myarray[i] = 100 + i;
	}

	for (int i = 0; i < 5; ++i) {
		printf("%d ", myarray[i]);
	}

	printf("\n");

	//对数组名取地址代表指向整个地址的指针
	ARRAY_TYPE *pArray = &myarray;
	pArray = &arr;

	//1.*pArray 表示拿到pArray指针指向的整个数组
	//2.*pArray类型就是数组名,指向首元素类型的指针
	
	printf("*(*pArray + 1) = %d\n", *(*pArray + 1));

	//2.直接定义数组指针类型
	typedef int(*ARRAY_POINTER)[5];
	ARRAY_POINTER pArr = &arr;

	//3.直接定义数组指针变量
	int(*pArrayParam)[5] = &arr;

}


int main(int argc, char *argv[])
{
	//test01();
	test02();
	
	return 0;
}
