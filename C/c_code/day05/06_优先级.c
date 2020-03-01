#include <stdio.h>

int main(int argc, char *argv[])
{
	/*
	 * 短路规则(优化)
	 * ||,左边为真,右边不执行
	 * &&,左边为假,右边不执行
	 */

	int c = 0;

	printf("before c = %d\n", c);

	//||,左边为真,右边不执行
	//1.先算1 || 0,为真,结果为1
	//2.再算1 = 250,不符合语法,编译出错
	//1 || c = 250;
	
	//1 || (c = 250);

	0 || (c = 250);

	printf("after c = %d\n", c);

	
	return 0;
}
