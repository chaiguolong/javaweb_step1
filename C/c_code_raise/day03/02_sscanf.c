#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//%*s或%*d	跳过数据
void test01()
{
#if 0
	char *str = "123456abcdef";
	char buf[1024] = {0};

	sscanf(str,"%*d%s", buf);

	printf("%s\n", buf);
#else
	//忽略字符串到空格或者\t
	char *str = "abcdef\t123456";
	char buf[1024] = {0};

	sscanf(str,"%*s%s", buf);

	printf("%s\n", buf);

#endif
}

void test02()
{
	//%[width]s 读取指定宽度的数据
	char *str = "123456abcdef";
	char buf[1024] = {0};

	sscanf(str,"%6s", buf);

	printf("%s\n", buf);
	
}

void test03()
{
	//%[a-z]	匹配a到z中任意字符(尽可能多的匹配)
	char *str = "123456abcdef";
	char buf[1024] = {0};

	sscanf(str,"%[a-z]", buf);

	printf("%s\n", buf);
}

//%[aBc]	匹配a,B,c中的一员,有贪婪性
void test04()
{
	char *str = "aBcbcdef";
	char buf[1024] = {0};
	sscanf(str,"%[aBC]", buf);
	printf("%s\n", buf);
}

void test05()
{
	//%[^a]	匹配非a的字符
	char *str = "aBcbcdef";
	char buf[1024] = {0};
	sscanf(str,"%[^d]", buf);
	printf("%s\n", buf);
}

void test06()
{
	//%[^a-z] 匹配非a-z的字符
	char *str = "aBcbcdef123456";
	char buf[1024] = {0};
	sscanf(str,"%[^0-9]", buf);
	printf("%s\n", buf);
}
void test07()
{
	char *ip = "127.0.0.1";
	int num1, num2, num3, num4;
	sscanf(ip, "%d.%d.%d.%d", &num1, &num2, &num3, &num4);

	printf("%d\n", num1);
	printf("%d\n", num2);
	printf("%d\n", num3);
	printf("%d\n", num4);
}

void test08()
{
	char *str = "abcde$hello world@sdfk23r";
	char buf[1024] = {0};
	sscanf(str, "%*[a-z]$%[^@]", buf);
	printf("%s\n", buf);
}


int main(int argc, char *argv[])
{
	//test01();
	//test02();
	//test03();
	//test04();
	//test05();
	//test06();
	//test07();
	test08();
	
	return 0;
}
