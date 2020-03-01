#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = NULL;
	//以写的方式打开文件
	fp = fopen("03.txt","w");
	
	if(fp == NULL){
		perror("fopen");
		return -1;
	}
	//2.写文件fputc(),一次只能写一个字符
	
	fputc(1, fp);
	fputc(-1, fp);
	fputc(2, fp);
	fputc(-2, fp);
	fputc(97, fp);
	

	//3.关闭文件
	fclose(fp);
	fp = NULL;
	
	return 0;
}

int main02(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = NULL;
	//以写的方式打开文件
	fp = fopen("03.txt","w");
	
	if(fp == NULL){
		perror("fopen");
		return -1;
	}
	//2.写文件fputc(),一次只能写一个字符
	
	char ch = 'a';
	while(ch <= 'z'){
		fputc(ch, fp);
		ch++;
	}

	char buf[] = "abcdefg";
	int i = 0;
	int n = strlen(buf);
	for (i = 0; i < n; ++i) {
		fputc(buf[i], fp);
	}
	

	//3.关闭文件
	fclose(fp);
	fp = NULL;
	
	return 0;
}

int main01(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = NULL;
	//以写的方式打开文件
	fp = fopen("03.txt","w");
	
	if(fp == NULL){
		perror("fopen");
		return -1;
	}
	//2.写文件fputc(),一次只能写一个字符
	
	//fputc('a',fp);
	//fputc('b',fp);
	//fputc('c',fp);
	//fputc('d',fp);

	fputc('a', stdout);
	fputc('b', stdout);
	fputc('c', stdout);
	fputc('d', stdout);

	//3.关闭文件
	fclose(fp);
	fp = NULL;
	
	return 0;
}
