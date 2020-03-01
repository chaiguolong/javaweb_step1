#include <stdio.h>

void fun(char *tmp){

	*tmp = 'a';	//err

}

int main(int argc, char *argv[])
{
	char *p = NULL;	//p是变量

	"hello mike";	//字符串常量,首元素地址

	p = "hello mike";	//p指向字符串
	*p = 'a';	//err 指向文字常量区,文字常量区的内容只读

	p = NULL;	//ok
	p = "hello";	//ok

	char *p2 = "abc";

	fun(p2);	//p2的值,是"abc"首元素地址
	
	return 0;
}
