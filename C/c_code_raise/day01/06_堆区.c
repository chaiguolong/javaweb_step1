#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//1.堆得内存手动申请,手动释放
int* getSpace()
{
	int *p = malloc(sizeof(int) * 5);

	int i = 0;

	for (i = 0; i < 5; ++i) {
		p[i] = 100 + i;
	}

	return p;
}

void test01()
{
	int *ret = getSpace();


	for (int i = 0; i < 5; ++i) {
		printf("ret[%d] = %d ", i,ret[i]);
	}

	printf("\n");

	//用完堆内存一定要释放
	free(ret);
	ret = NULL;

}

void allocateSpace(char *p)
{
	p = malloc(100);
	memset(p, 0, 100);
	strcpy(p, "hello world!");
}


void test02()
{
	int *p = NULL;
	allocateSpace(p);
	printf("p: %s\n", p);
}

void allocateSpace2(char **p)
{
	char *temp = malloc(100);
	memset(temp, 0, 100);
	strcpy(temp, "hello world!");

	*p = temp;
}


void test03()
{
	int *p = NULL;
	allocateSpace2(&p);
	printf("p: %s\n", p);
}

int main(int argc, char *argv[])
{
	test01();
	//test02();
	test03();
	
	return 0;
}
