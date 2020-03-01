#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//1.calloc
void test01()
{
	int *p = calloc(10, sizeof(int));
	for (int i = 0; i < 10; ++i) {
		p[i] = i + 1;
	}

	for (int i = 0; i < 10; ++i) {
		printf("p[i] = %d ", p[i]);
	}

	printf("\n");

	//释放空间
	if(NULL != p){
		free(p);
		p = NULL;
	}

}

void test02()
{
	int *p = malloc(sizeof(int) * 10);

	for (int i = 0; i < 10; ++i) {
		p[i] = i + 1;
	}

	//打印
	for (int i = 0; i < 10; ++i) {
		printf("%d ", p[i]);
	}
	printf("\n");

	printf(" p = %d\n", p);
	p = realloc(p, sizeof(int) * 500);
	printf(" p = %d\n", p);

	//打印
	for (int i = 0; i < 10; ++i) {
		printf("%d ", p[i]);
	}
	printf("\n");
}

int main(int argc, char *argv[])
{
	//test01();

	test02();
	
	return 0;
}
