#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void test01()
{
	//1.格式化字符串
	char buf[1024] = {0};
	sprintf(buf, "Hello %s !", "obama");
	printf("buf: %s\n", buf);

	//2.拼接字符串
	char *s1 = "hello";
	char *s2 = "world";
	memset(buf, 0, 1024);
	sprintf(buf, "%s %s", s1, s2);
	printf("buf: %s\n", buf);
	
	//3.数字转字符串格式
	int number = 666;
	memset(buf, 0, 1024);
	sprintf(buf, "%d", number);
	printf("buf: %s\n", buf);

	//4.格式化数字八进制,十六进制
	memset(buf, 0, 1024);
	sprintf(buf, "%o", number);
	printf("八进制: %s\n", buf);
	
	memset(buf, 0, 1024);
	sprintf(buf, "%x", number);
	printf("十六进制: %s\n", buf);


	char **p = malloc(sizeof(char *) * 5);
	for (int i = 0; i < 5; ++i) {
		p[i] = malloc(64);
		memset(p[i], 0, 64);
		sprintf(p[i], "name_%d", i+1);
	}

	//打印字符串
	for (int i = 0; i < 5; ++i) {
		printf("p[i]=%s ", p[i]);
	}

	printf("\n");

	//释放内存
	for (int i = 0; i < 5; ++i) {
		if(NULL != p[i]){
			free(p[i]);
			p[i] = NULL;
		}
	}

	if(NULL != p){
		free(p);
		p = NULL;
	}
}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
