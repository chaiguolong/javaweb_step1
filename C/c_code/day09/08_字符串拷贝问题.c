#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char buf[100];

	//1.p指向buf的首元素
	//2.strcpy()是给p所指向的内容拷贝内容,字符串拷给buf
	char *p = buf;

	strcpy(p,"hello mike abc");

	printf("buf = %s\n", buf);

	printf("p = %s\n",p);
	
	return 0;
}

int main01(int argc, char *argv[])
{
	char *p;

	//1.不是给p变量拷贝内容
	//2.给p所指向的内容拷贝内容
	//3.p是野指针,给野指针所指向的内容拷贝内容,结果导致段错误
	strcpy(p,"hello mike abc");


	
	return 0;
}
