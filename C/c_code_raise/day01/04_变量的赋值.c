#include<stdio.h>
#include<string.h>
#include<stdlib.h>


struct Person {
	char a;
	int b;
	char c;
	int d;
};

void test01()
{
	int a = 10;
	//直接赋值
	a = 100;

	int *p = &a;
	*p = 200;
}

void test02()
{
	struct Person p = {'a', 100, 'b', 200};

	printf("p.d:%d\n", p.d);

	p.d = 1000;

	printf("sizeof(struct Person): %lu\n", sizeof(struct Person));

	printf("%d\n", *(int *)((char *)&p + 12));

	printf("p.d:%d\n", p.d);

	//printf("%d\n", (char *)&p + 6);

	//printf("%d\n", &p.d);

	printf("----------------\n");

	//double *pp = NULL;

	//printf("pp:%d\n", pp);

	//printf("pp+1:%d\n", pp+1);
}

int main(int argc, char *argv[])
{
	test02();
	
	return 0;
}
