#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.p指针保存了"hello"的地址
	//2.指针所指向的内存不能修改
	char *p = "hello";

	//1.把"hello"一个一个字符放在buf数组中
	//2.数组的元素可以修改
	char buf[] = "hello";
	
	return 0;
}
