#include <stdio.h>

int main(int argc, char *argv[])
{
	char str[] = "hello";

	str[0] = '1';

	*(str+1) = '2';

	printf("str = %s\n", str);	//12llo

	//定义一个指针,指向首元素
	char *p = NULL;

	p = &str[0];
	p = str;	//数组名就是首元素地址

	*p = 'a';

	p++;

	*p = 'b';

	printf("str = %s\n", str);	//abllo

	printf("p = %s\n", p);	//bllo
	
	return 0;
}
