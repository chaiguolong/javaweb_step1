#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	int b[10] = {0};

	//处理一些代码,把b内部元素改了
	
	//b[10] = {0};	//err
	
	int i = 0;

	int n = sizeof(b) / sizeof(b[0]);

	for (i = 0; i < n; ++i) {
		b[i] = 0;
	}


	memset(b,0,sizeof(b));

	char str[10];
	memset(str,'a',sizeof(str));

	for (i = 0; i < 10; ++i) {
		printf("%c,", str[i]);
	}

	printf("\n");





	return 0;
}

int main01(int argc, char *argv[])
{
	int a;

	memset(&a,0,sizeof(a));
	printf("a = %d\n", a);

	memset(&a,10,sizeof(a));
	printf("a1 = %d\n", a);
	
	memset(&a,97,sizeof(a));
	printf("a2 = %c\n", a);

	int b[10];
	memset(b,0,sizeof(b));
	memset(b,0,10*sizeof(int));

	return 0;
}
