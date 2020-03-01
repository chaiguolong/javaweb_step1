#include <stdio.h>

int main(int argc, char *argv[])
{
	printf("%d\n", 0x8000007b);

	printf("%u\n", 0x8000007b);

	//等价于int a = -10;
	signed int a = -10;

	unsigned int b = 10;

	unsigned int c = 0x8000007b;

	printf("c = %d\n", c);	//输出结果以%d为准,%d以有符号方式输出

	printf("c = %u\n", c);


	
	return 0;
}
