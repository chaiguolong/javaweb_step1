#include <stdio.h>
int main(int argc, char *argv[])
{
	int a[3] = {0,1,2};

	//指针数组,它是数组,每个元素都是指针
	int *p[3];

	p[0] = &a[0];
	p[0] = a;

	p[1] = &a[1];
	p[1] = a + 1;

	p[2] = &a[2];
	p[2] = a + 2;

	int n = sizeof(p) / sizeof(p[0]);

	int i = 0;

	for (i = 0; i < n; ++i) {
		p[i] = &a[i];
	}

	for (i = 0; i < n; ++i) {
		printf("%d,", *p[i]);
	}

	printf("\n");
	

	return 0;
}

int main01(int argc, char *argv[])
{
	int a = 10;

	int b = 20;

	int c = 30;

	int *p1 = &a;

	int *p2 = &b;

	int *p3 = &c;
	
	return 0;
}
