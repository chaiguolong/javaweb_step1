#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[10] = {1,2,3,4,5,6,7,8,9,10};

	int *p = NULL;

	//p指针变量指向首元素
	p = &a[0];
	p = a;

	int i = 0;

	for (i = 0; i < 10; ++i) {
		//printf("%d,", a[i]);
		printf("%d,", *(p + i));
		//printf("%d,", p[i]);
	}

	printf("\n");

	
	return 0;
}
