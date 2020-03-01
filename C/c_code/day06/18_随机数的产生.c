#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[])
{
	//先设置种子,种子设置一次即可
	//如果srand()的参数一样,随机数就一样
	//srand(100);

	//time(NULL)功能获取系统当前时间,由于时间会变,srand也会改变
	srand((unsigned int)time(NULL));

	int i;
	
	int num;

	for (i = 0; i < 10; ++i) {
		num = rand();
		printf("num = %d\n", num);
		
	}
	
	return 0;
}
