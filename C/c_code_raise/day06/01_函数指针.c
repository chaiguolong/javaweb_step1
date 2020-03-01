#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void func()
{
	printf("hello world!\n");
}

int myfunc(int a, char b)
{
	printf("int myfunc(int a, char b) !\n");

	return 0;
}

void test01()
{
	//1.定义函数类型,通过类型来定义函数指针
	typedef int(FUN_TYPE)(int a, char b);
	FUN_TYPE *pFunc = myfunc;
	myfunc(10, 'a');
	(*pFunc)(20, 'b');
	myfunc(30, 'c');

	//2.直接定义函数指针类型
	typedef int(*FUN_P)(int a, char b);
	FUN_P pFunc2 = myfunc;
	pFunc2(40, 'd');

	//函数指针指向同类型
	//pFunc2 = func;
	
	//3.直接定义函数指针变量
	
	//把指针转换为函数类型指针的写法
	int(*pFunc3)(int, char) = (int(*)(int, char))NULL;
	pFunc3 = myfunc;

	pFunc3(50, 'd');
	printf("pFunc3 size: %d\n", sizeof(pFunc3));
}

//func函数名其实代表函数的入口地址
//如何去定义一个指向函数的指针

int con1(int a, int b)
{
	return a + b;
}

int con2(int a, int b)
{
	return a + b + 10;
}
int con3(int a, int b)
{
	return a + b -10;
}
int con4(int a, int b)
{
	return a * b -10;
}
int con5(int a, int b)
{
	return a + b - 3 + 100 * 2;
}

//函数就可以作为另外一个函数的参数了
void doLogic(int(*pFunc4)(int, int))
{
	int a = 10;
	int b = 20;
	int ret = pFunc4(a, b);
	printf("ret: %d\n", ret);
}

void test02()
{
	doLogic(con5);
}

//函数指针数组
void func1()
{
	printf("func1\n");
}
void func2()
{
	printf("func2\n");
}
void func3()
{
	printf("func3\n");
}

void test03()
{
	void(*func_array[3])();
	func_array[0] = func1;
	func_array[1] = func2;
	func_array[2] = func3;

	for (int i = 0; i < 3; ++i) {
		func_array[i]();
	}
}

//函数指针做函数参数
void printAllArray(void* array, int elesize, int len, void(*print)(void *))
{
	char * start = (char *)array;

	for (int i = 0; i < len; ++i) {
		//printf("array[%d]: %d\n", i, start + i * elesize);
		char* eleAddr = start + i * elesize; 
		print(eleAddr);

	}
}

void myPrint(void *data){
	int *p = (int *) data;
	printf("%d ", *p);
}

struct Person {
	char name[64];
	int age;
};

void myPrintPerson(void *data){
	struct Person *p = (struct Person *) data;
	printf("Name: %s Age: %d\n", p->name ,p->age );
}

void test04()
{
	int arr[5]  = {1, 2, 3, 4, 5};
	printAllArray(arr, sizeof(int), 5, myPrint);
	printf("\n");

	struct Person persons[] = {
		{"aaa", 10},
		{"bbb", 20},
		{"ccc", 30},
		{"ddd", 40},
		{"eee", 50}
	};

	printAllArray(persons, sizeof(struct Person), 5, myPrintPerson);
}





int main(int argc, char *argv[])
{
	//test01();
	//test02();
	//test03();
	test04();
	
	return 0;
}
