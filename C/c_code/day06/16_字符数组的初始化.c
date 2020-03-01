#include <stdio.h>

int main(int argc, char *argv[])
{
	char a1[] = {'a','b','c'};//字符数组
	printf("a1 = %s\n", a1);//乱码,因为没有结束符

	char a2[] = {'a','b','c','\n'};//字符串
	printf("a2 = %s\n", a2);//"abc"

	char a3[] = {'a','b','c',0};//字符串
	printf("a3 = %s\n", a3);//"abc"

	char a4[] = {'a','b','c','h','e','\0'};
	printf("a4 = %s\n", a4);//"abche"

	char a5[] = {'a','b','c','\0','h','e','\0'};
	printf("a5 = %s\n", a5);//"abc"

	char a6[10] = {'a','b','c'};//前3个字符赋值为a,b,c,后面自动赋值为0;
	printf("a6 = %s\n", a6);//"abc"

	//1.常用的初始化,使用字符串初始化,在字符串结尾自动加结束符数字0
	//2.这个结束符,用户看不到(隐藏),但是是存在的
	char a7[10] = "abc";
	printf("a7 = %s\n", a7);

	char a8[] = "abc";
	printf("sizeof(a8) = %lu\n",sizeof(a8));//字符串自动隐藏了一个结束符

	char a9[] = "\0abc";
	printf("a9 = %s\n", a9);

	//\0后面最好不要跟数字,有可能组成一个转义字符
	char a10[] = "\012abc";
	printf("a10 = %s\n", a10);



	
	return 0;
}
