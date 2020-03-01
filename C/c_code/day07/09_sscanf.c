#include <stdio.h>

int main(int argc, char *argv[])
{
	char buf[] = "1 2 3";

	int a, b, c;

	sscanf(buf,"%d %d %d",&a,&b,&c);

	printf("a = %d, b = %d, c = %d\n", a,b,c);

	//提取整型变量是最方便的
	char str[] = "a = 1, b = 2, c = 3";

	a = 0;
	b = 0;
	c = 0;

	sscanf(str,"a = %d, b = %d, c = %d",&a,&b,&c);

	printf("a = %d, b = %d, c = %d\n", a,b,c);

	char str2[] = "1,2,3";

	a = 0;
	b = 0;
	c = 0;

	sscanf(str2,"%d,%d,%d",&a,&b,&c);

	printf("a = %d, b = %d, c = %d\n", a,b,c);


	char tmp[] = "abc mike 250";	//提取字符串,默认以空格分隔,可以提取

	char m[10],n[10],k[10];

	sscanf(tmp,"%s %s %s",m,n,k); //不用&,数组名就是首元素地址

	printf("m[10] = %s, n[10] = %s, k[10] = %s\n", m,n,k);

	
	char tmp1[] = "abc,mike,250";	//提取字符串

	char m1[10],n1[10],k1[10];

	sscanf(tmp1,"%s %s %s",m1,n1,k1); //不用&,数组名就是首元素地址

	printf("m1[10] = %s, n1[10] = %s, k1[10] = %s\n", m1,n1,k1);

	return 0;
}

int main01(int argc, char *argv[])
{
	int a,b,c;

	printf("请输入a, b, c:");

	scanf("%d %d %d", &a, &b, &c);//默认以空格标识

	printf("a = %d, b = %d, c = %d\n", a,b,c);
	
	return 0;
}
