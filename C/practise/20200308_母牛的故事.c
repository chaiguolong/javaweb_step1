#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
 * 有一头母牛，它每年年初生一头小母牛。
 * 每头小母牛从第四个年头开始，每年年初也生一头小母牛。
 * 请编程实现在第n年的时候，共有多少头母牛？
 *
 * 思路: 总共的牛 = 去年的牛 + 新生的牛
 * F[n] = F[n-1] + F[n-3]
 *
 *
 *
 *
 *
 */

int countCow(int year){
	int a[year];
	a[0] = 1;
	a[1] = 1;
	a[2] = 2;
	a[3] = 3;
	for (int i=4; i<=year; i++) {  
			a[i]=a[year-1]+a[i-3];  
		}  
	return a[year];
}

int main(int argc, char *argv[])
{
	int count;
	int year;
	printf("请输入你要计算的年数:");
	scanf("%d", &year);
	count = countCow(year);
	printf("%d\n", count);
	return 0;
}
