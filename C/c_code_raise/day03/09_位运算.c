#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//按位取反 ~
void test01()
{
	int num = 2;
	printf("num=%d\n", ~num);
	
}

//位于 &
void test02()
{
	int num = 336;
	if((num & 1) == 0){
		printf("%d是偶数\n", num);
	}else{
		printf("%d是奇数\n", num);
	}

	//num = num & 0;
	num &= 0;
	printf("num = %d\n", num);
}

//3.位或
void test03()
{
	int num1 = 5;
	int num2 = 3;

	printf("num1 | num2 = %d\n", num1 | num2);
}

//4.位异或
void test04()
{
	int num1 = 5;
	int num2 = 9;

#if 0
	int tmp = num2;
	num2 = num1;
	num1 = tmp;

#endif
	printf("num1 = %d, num2 = %d\n", num1, num2);

	/*
	R = A ^ B;
	A = R ^ B;
	B = R ^ A;
	A = A ^ B ^ B
	*/

	num1 = num1 ^ num2;
	num2 = num1 ^ num2;
	num1 = num1 ^ num2;


	printf("num1 = %d, num2 = %d\n", num1, num2);
}

//左移运算符,左移几位就相当于乘以2的几次方
void test05()
{
	int number = 20;
	printf("number: %d\n", number <<= 2);
	printf("number: %d\n", number >>= 1);
	
}

int main(int argc, char *argv[])
{
	//test01();
	//test02();
	//test03();
	//test04();
	test05();
	
	return 0;
}
