#include <stdio.h>

int main(int argc, char *argv[])
{
	int a;
	a = 12;//以十进制方式赋值
	//%d以十进制方式打印
	printf("[10] a = %d\n", a);
	//%o,字母o以8进制方式打印
	printf("[8] a = %o\n", a);
	//%x,%X,字母o以16进制方式打印
	printf("[16] a = %x\n", a);
	printf("[16] a = %X\n", a);

	a = 0123; //以8进制方式赋值
	a = 0x1ab; //以16进制方式赋值
	return 0;
}
