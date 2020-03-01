#include <stdio.h>

int main(int argc, char *argv[])
{
	char buf[] = "hello";

	//网stdout(代表屏幕,标准输出)输出buf
	fputs(buf,stdout);
	
	return 0;
}

int main01(int argc, char *argv[])
{
	char buf[] = "hello";

	puts(buf);	//把buf内容输出到屏幕,自动在屏幕上换行,是在屏幕加,字符串本身没有变化
	printf("buf = %s", buf);
	
	return 0;
}
