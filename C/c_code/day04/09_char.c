#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.内存中没有字符,只有数字
	//2.一个数字对应一个字符,这种叫做ascii码
	//3.使用字符或数字给字符变量赋值是等价的
	//4.字符类型本质上就是一个字节大小的整型
	
	//字符: '一个字符'
	char ch = 'a';
	printf("ch1 = %c,ch = %d\n", ch,ch);

	ch = 97;
	printf("ch2 = %c\n", ch);

	//小写字母比大写字母大32
	char a = 'A';
	char b = 'a';
	printf("A = %d,a = %d\n", a,b);

	//小写转大写,小写字母-32
	printf("小写转大写: %c\n", 'a'-32);

	//大写转小写,大写字母+32
	printf("大写转小写:%c\n", 'A'+32);

	char temp;
	printf("请输入字符:\n");
	scanf("%c",&temp);
	printf("temp=%c\n", temp);

	
	return 0;
}
