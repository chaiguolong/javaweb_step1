#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 10;

	char ch = 'd';

	char buf[] = "hello";

	char dst[100];

	//格式化一个字符串,把这个字符串输出到屏幕
	printf("a = %d,ch = %c,buf = %s\n", a,ch,buf);

	sprintf(dst,"a = %d,ch = %c,buf = %s", a,ch,buf);

	printf("dst = %s\n", dst);
	
	return 0;
}
