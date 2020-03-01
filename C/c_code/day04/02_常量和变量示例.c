#include <stdio.h>
//1.开头的语句是预处理语句,无需分号结束
//2.定义一个宏定义的标识符MAX,它代表100,是个常量
//3.宏定义以后的代码都可以使用MAX
//4.在后面出现的MAX,预处理都会替换为100

#define MAX 100

int main(int argc, char *argv[])
{
	/* 10 = MAX; */
	/* MAX = 1; */
	MAX;
	MAX;

	int b = MAX;
	
	return 0;
}
