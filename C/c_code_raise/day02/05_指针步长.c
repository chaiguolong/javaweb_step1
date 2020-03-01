#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include <stddef.h>


struct Person {
	int a;
	char b;
	char buf[64];
	int d;
};

//指针步长: 指针变量+1, 要向后跳多少个字节
//指针的类型,不单单决定指针的步长,还决定解引用的时候从给定地址开始取类型大小的字节数

void test01()
{
	char *p = NULL;
	printf("p = %d\n", p);
	printf("p+1 = %d\n", p+1);

	printf("------------------\n");

	int *p1 = NULL;

	printf("p1 = %d\n", p1);
	printf("p1+1 = %d\n", p1+1);

	printf("------------------\n");

	char buf[1024] = {0};
	int a = 100;
	memcpy(buf + 1, &a, sizeof(int));

	char *p3 = buf;
	printf("*(int *)(p3 +1) = %d\n", *(int *)(p3 +1));
};

void test02()
{
	struct Person p = {10, 'a', "hello world", 100};
	char b;
	printf("a off: %d\n", offsetof(struct Person, b));

	printf("d = %d\n", *(int *)((char *)&p + offsetof(struct Person, d)));

}

int main(int argc, char *argv[])
{
	test01();
	
	test02();
	return 0;
}
