#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	
	char src[100] = "hello\0 mike"; //源字符串

	char dst[100]; //目的

	//把源字符串src的功能拷贝到dst数组内
	strncpy(dst,src,sizeof(src));

	printf("dst = %s\n", dst + strlen(src) + 1);

	return 0;
}

int main02(int argc, char *argv[])
{
	
	char src[100] = "hello mike"; //源字符串

	char dst[100] = "aaaaaaaaaaaaaaaaaaaa"; //目的

	//把源字符串src的功能拷贝到dst数组内
	//strncpy(dst,src,strlen(src)+1);
	strncpy(dst,src,strlen(src));

	printf("dst = %s\n", dst);

	return 0;
}

int main01(int argc, char *argv[])
{
	char src[100] = "hello mike"; //源字符串

	char dst[100]; //目的

	//把源字符串src的功能拷贝到dst数组内
	strcpy(dst,src);

	printf("dst = %s\n", dst);


	char src2[100] = "hello\0 mike"; //源字符串

	char dst2[100]; //目的

	//把源字符串src的功能拷贝到dst数组内
	//拷贝原理:从首元素开始,遇到结束符'\0'结束
	strcpy(dst2,src2);

	printf("dst2 = %s\n", dst2);

	
	return 0;
}
