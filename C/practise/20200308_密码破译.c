#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
 * 要将"China"译成密码，译码规律是：用原来字母后面的第4个字母代替原来的字母．
 *
 * 例如，字母"A"后面第4个字母是"E"．"E"代替"A"。因此，"China"应译为"Glmre"。
 *
 * 请编一程序，用赋初值的方法使cl、c2、c3、c4、c5五个变量的值分别为，’C’、’h’、’i’、’n’、’a’，经过运算，
 *
 * 使c1、c2、c3、c4、c5分别变为’G’、’l’、’m’、’r’、’e’，并输出
 */

//1.算法:每个字母+4;


int main(int argc, char *argv[])
{
	char c1, c2, c3, c4, c5;
	printf("请输入4个字符用空格隔开:");
	scanf("%c%c%c%c%c", &c1,&c2,&c3,&c4,&c5);
	c1 = c1 + 4;
	c2 = c2 + 4;
	c3 = c3 + 4;
	c4 = c4 + 4;
	c5 = c5 + 4;
	printf("%c%c%c%c%c\n", c1, c2, c3, c4, c5);

	
	return 0;
}
