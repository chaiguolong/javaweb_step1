#include <stdio.h>

int main(int argc, char *argv[])
{
	printf("Mike\n");
	printf("      'aaa     '\n");
	
	return 0;
}

int main03(int argc, char *argv[])
{
	char a;
	printf("请输入字符:");
	/* scanf("%c",&a); */
	a = getchar();	//读取键盘输入的字符,放入a变量
	printf("a = '%c'\n", a);


	//吃掉上一步的\n,不做处理
	char b;
	/* scanf("%c",&b); */
	b = getchar();
	
	char c;
	printf("请输入字符:");
	/* scanf("%c",&c); */
	c = getchar();
	printf("c = '%c'\n", c);

	return 0;
}

//字符输入
int main02(int argc, char *argv[])
{
	char a;
	printf("请输入字符:");
	scanf("%c",&a);
	printf("a = '%c'\n", a);


	char b;
	printf("请输入字符:");
	scanf("%c",&b);
	printf("b = '%d'\n", b);
	
	char c;
	printf("请输入字符:");
	scanf("%c",&c);
	printf("c = '%c'\n", c);

	return 0;
}

//整型输入
int main01(int argc, char *argv[])
{
	int a;
	printf("请输入a:");
	scanf("%d",&a);
	printf("a = %d\n", a);

	int b;
	int c;
	printf("请输入b,c:");
	scanf("%d %d",&b,&c);
	printf("b = %d,c = %d\n", b,c);
	
	return 0;
}
