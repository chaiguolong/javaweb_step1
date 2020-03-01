#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char buf[] = "hello";

	//strlen需要返回值,返回值就是字符串的长度
	//从首元素开始,到结束符为止的长度,结束符不算(遇到'\0'结束)
	int len = strlen(buf);

	printf("len = %d\n", len);

	printf("sizeof(buf) = %lu\n", sizeof(buf)); //多了一个'\0';


	char buf2[] = "\0hello";

	len = strlen(buf2);
	
	printf("len = %d\n",len);

	//sizeof()测数据类型的长度,不会因为遇到'\0'而提前结束
	printf("sizeof(buf2) = %lu\n",sizeof(buf2));

	
	return 0;
}
