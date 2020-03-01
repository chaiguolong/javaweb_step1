#include <stdio.h>

int main(int argc, char *argv[])
{
	int a[5][10];

	//1.数组名是常量,不能修改
	//a = 10;	//err
	
	//2.sizeof(数组名),测试数组的总大小: 5 * int[10] = 5 * 4 * 10 = 200;
	printf("sizeof(a) = %lu\n", sizeof(a));

	//3.sizeof(a[0]),测试的是第0个元素的大小: int[10] = 4 * 10 = 40;
	printf("sizeof(a[0]=%lu)\n", sizeof(a[0]));

	//4.sizeof(a[0][0]),测试的是第0行第0列元素的大小: int = 4;
	
	printf("sizeof(a[0][0])=%lu\n", sizeof(a[0][0]));

	//5.求行数(元素): 总大小/每个元素大小
	printf("n = %lu\n", sizeof(a)/sizeof(a[0]));

	//6.求列数: 第0个元素的大小/第0行第0列元素的大小
	printf("n1 = %lu\n", sizeof(a[0])/sizeof(a[0][0]));

	//7.求行*列:
	printf("n2 = %lu\n", sizeof(a) /sizeof(int));

	
	return 0;
}
