#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
 * 编写一个程序，输入a、b、c三个值，输出其中最大值。
 *	思路:通过循环调用2个数作比较
 *	1.如果a > = b,那么a是最大的
 *
 */


int maxVal(int a, int b){
	if(a >= b){
		return a;
	}
	return b;
}

int main(int argc, char *argv[])
{
	int a, b, c;
	printf("请输入3个整数:");
	scanf("%d %d %d", &a, &b, &c);
	int max = maxVal(a, b);
	max = maxVal(max, c);
	printf("%d\n", max);
	
	return 0;
}
