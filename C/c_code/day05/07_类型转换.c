#include <stdio.h>

int main(int argc, char *argv[])
{
	//强制类型转换原则,数据类型小的往大的转
	int a = 129;

	char b = 111;

	//小的往大的转
	//a = (int)b;
	
	//printf("a = %d\n", a);
	
	b = (char)a;

	printf("b = %d\n",b);

	return 0;
}

//关于浮点型打印说明
int main03(int argc, char *argv[])
{
	int a = 10;

	//整型变量不要用%lf打印,除非用强制类型转换
	printf("a = %lf\n", (double)a);

	double b = 88.14;

	//浮点型变量不要用%d打印,除非强制类型转换
	printf("b = %d\n", (int)b);
	
	return 0;
}

//强制类型转换: (类型)需要转换的变量名
int main02(int argc, char *argv[])
{
	double a;

	//把1强制转换为浮点型后,再运算
	a = (double)1/2;

	printf("a = %lf\n", a);

	//64位
	printf("sizeof(int) = %u\n", (unsigned)sizeof(int));
	
	return 0;
}

//隐式转换
int main01(int argc, char *argv[])
{
	double a;

	int b = 10;

	//隐式转换,编译器内容自动转换
	//b自动转换为double,再给a赋值,在11行自动转换,其他地方,b还是整型
	a = b;

	printf("a = %lf\n", a);
	
	return 0;
}
