#include <stdio.h>

int main(int argc, char *argv[])
{
	char buf[10];

	fgets(buf,sizeof(buf),stdin);

	printf("buf = $%s$\n", buf);
	
	return 0;
}

int main02(int argc, char *argv[])
{
	char buf[100];

	//gets从键盘读取字符串,放在指定的数组
	//gets允许有空格,不做越界检查,此函数不安全
	gets(buf);

	printf("buf = %s\n", buf);
	
	return 0;
}


int main01(int argc, char *argv[])
{
	char buf[100] = {0};
	printf("请输入字符串buf:");
	scanf("%s",buf);//不需要&,默认空格隔开
	printf("buf = %s\n", buf);

	char tmp[100] = {0};
	printf("请输入字符串tmp:");
	scanf("%s",tmp);//不需要&,默认空格隔开
	printf("tmp = %s\n", tmp);


	//scanf的缺点,不做越界检查
	char str[10] = {0};
	printf("请输入字符串str:");
	scanf("%s",str);//不需要&,默认空格隔开
	printf("str = %s\n", str);
	
	return 0;
}
