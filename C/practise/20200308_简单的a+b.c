#include <stdio.h>
#include <string.h>
#include <stdlib.h>

	//输入两个整数a和b，计算a+b的和

int add(int a, int b){
	return a + b;
}

int main(int argc, char *argv[])
{
	printf("请输入两个数字,并用空格隔开:");
	int a;
	int b;
	int sum;
	scanf("%d %d", &a, &b);
	sum = add(a,b);
	printf("%d\n", sum);
	
	return 0;
}
