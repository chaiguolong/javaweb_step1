#include <stdio.h>

int main(int argc, char *argv[])
{
	//因为4 == 3条件为假,所以结果为0;
	printf("4 == 3 的结果为:%d\n", 4 == 3);

	//因为4 > 3条件为真,所以结果为1;
	printf("4 > 3 的结果为:%d\n", 4 > 3);

	printf("!(4 == 3) 的结果为:%d\n", !(4 == 3));

	//&&,左右结果都为真,整体才为真
	printf("1 && -1 的结果为:%d\n", 1 && -1);

	printf("0 && -1 的结果为:%d\n", 0 && -1);
	
	//||,只要有一边为真,整体结果就为真
	printf("0 || -1 的结果为:%d\n", 0 || -1);

	printf("0 || 0 的结果为:%d\n", 0 || 0);

	return 0;
}
