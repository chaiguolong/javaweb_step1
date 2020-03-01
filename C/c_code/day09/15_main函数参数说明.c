#include <stdio.h>

//argv[]:它是数组,数组每个元素都是char *,每个元素都是字符地址
//argc: argv[]元素个数
//main()函数参数,需要用户传递
int main(int argc, char *argv[])
{

	int i = 0;

	for (i = 0; i < argc; ++i) {
		printf("text = %s\n", argv[i]);
	}
	
	return 0;
}
