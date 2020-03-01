#include <stdio.h>


int main(int argc, char *argv[])
{
	int i = 1;
	
	int sum = 0;

	//1.第一次无条件执行
	//2.从第二次开始和while循环一样
	do
	{
		sum += i;
		i++;
	}while(i <= 100);

	printf("sum = %d\n", sum);
	
	return 0;
}
