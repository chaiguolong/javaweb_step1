#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[10] = {1,2,3,4,5,6,7,8,9,10};

	int *p = a;
	p = &a[0];

	int n = sizeof(a) / sizeof(*a);

	int i = 0;

	for (i = 0; i < n; ++i) {
		printf("%d,", *p);
		p++;
	}

	printf("\n");

	//定义一个指针,指向尾元素
	int *q = &a[n-1];
	q = a + n -1;

	for (i = 0; i < n; ++i) {
		printf("%d,", *q);
		q--;
	}

	printf("\n");

	
	return 0;
}
