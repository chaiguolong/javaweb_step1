#include <stdio.h>

int main(int argc, char *argv[])
{
	char str[] = "hello mike";

	//1.%s 从首元素开始打印,直到结束符位置
	//2.%s 操作的是指针所指向的内容
	//printf("str = %s\n", str);
	
	//2.str是首元素地址,如果想打印首元素本身的值,%p,%x,%d,%o
	printf("str = %p\n", str);

	//3.*str代表第0个元素,它是char
	//printf("str3 = %s\n", *str);	//err
	printf("str3 = %c\n", *str);


	int i = 0;

	while( str[i] != '\0' ){	//while( *(str+i) != '\0')

		printf("%c", str[i]);	//str[i] 和 *(str+i)等价

		i++;

	}

	printf("\n");

	return 0;
}
