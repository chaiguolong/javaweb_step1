#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//1.sizeof返回的是变量实际占用的空间大小,单位是字节
//#pragma pack(1)
struct Person {
	char a;
	int b;
};

//2.sizeof返回结果是unsigned int;
void test02()
{
	unsigned int a = 10;

	if(a - 20 > 0){
		printf("大于0\n");
	}else{
		printf("小于0\n");
	}

	if(sizeof(int) -5){
		printf(">0\n");
	}else{
		printf("<0\n");
	}
}

unsigned long caculateArraySize(int arr[])
{
	return sizeof(arr);
}

//1.sizeof计算数组
//数组作为函数参数,会退化为指向数组首元素的指针
void test03()
{
	int arr[] = {1,2,3,4,5,6,7,8,9};

	printf("sizeof(arr) = %lu\n", sizeof(arr));
	
	printf("sizeof(arr) = %lu\n", caculateArraySize(arr));
}

void test01()
{
	printf("int sizeof: %lu\n", sizeof(int));

	double a = 3.14;

	printf("a sizeof: %lu\n", sizeof(a));

	printf("Person sizeof: %lu\n", sizeof(struct Person));
}

int main(int argc, char *argv[])
{
	test01();
	
	test02();

	test03();

	return 0;
}
