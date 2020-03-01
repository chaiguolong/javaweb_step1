#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void test01()
{
	//char *arr[] = {"aaa", "bbb", "ccc"};

#if 0
	char *p1 = "aaa";
	char *p2 = "bbb";
	char *p3 = "ccc";
	char *arr[] = {p1, p2, p3};
#endif

	//返回的是首元素的地址
	char **arr = malloc(sizeof(char *) * 6);

	//错误写法
	//char **arr = {"aaa", "bbb", "ccc"};
}

void printArray01(int *arr, int len){}
void printArray02(int(*arr)[3], int len){}
void printArray03(char *arr, int len){}

void test02()
{
	//除了sizeof 对数组名取地址这两种情况下,其他任何情况下数组名都是指向首元素的指针
	int arr1[10];	//arr1是int*类型
	printArray01(arr1, 10);

	int arr2[3][3] = {
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}
	};		//arr2是什么类型? int(*)[3]

	printArray02(arr2, 10);

	char *arr3[] = {"aaa", "bbb", "ccc"};
	//arr3是什么类型? char*类型
	
	printArray03(arr3, 10);

	char **arr4[3];	//arr4是什么类型? char***类型
}

void test03()
{
	typedef int(ARRAY_TYPE)[10];
	typedef int(*ARRAY_POINTER_TYPE)[10];

	int arr[10];
	int arr2[11];
	ARRAY_TYPE *p1 = &arr;
	ARRAY_POINTER_TYPE p2 = &arr;

	//p2和&arr2的类型不一致,所以有警告
	//p2 = &arr2;
	int(*p)[10] = &arr;
}

struct Teacher {
	char name[64];
	int age;
};

//只要结构体内部不涉及到指针,并且指针指向堆内存,那么使用默认操作是没有问题的
void test04()
{
	//结构体赋值
	struct Teacher p1, p2;
	//p1 = p2;
}

int main(int argc, char *argv[])
{
	
	return 0;
}
