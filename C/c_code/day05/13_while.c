#include <stdio.h>
int main(int argc, char *argv[])
{
	int num = 1;

	int sum = 0;

	while(num < 101)
	{
		sum += num;
		num++;
	}

	printf("1到100的和为: %d\n", sum);

	return 0;
}

int main01(int argc, char *argv[])
{
	int num = 1;

	while(num > 0){
		printf("请输入一个数(为负数时就退出):");
		scanf("%d",&num);
	}
	
	return 0;
}
