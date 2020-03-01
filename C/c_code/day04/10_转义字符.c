#include <stdio.h>

int main(int argc, char *argv[])
{
	//字符,原则上'',内部只有一个字符,转义字符除外
	//char a = 'abc';	//不合理
	//printf("a = %c\n", a);
	
	//转义字符,由反斜杠\组成多个字符
	char ch = '\n';
	printf("fff%c", ch);

	ch = '\r';	//句首
	printf("abcdddefg\n");
	printf("abcddd%cefg\n",ch);

	ch = '\b';	//退格
	printf("123456\n");
	printf("123%c456\n", ch);



	
	return 0;
}
