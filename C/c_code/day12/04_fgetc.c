#include <stdio.h>
#include <string.h>

void write_file(){
	//1.打开文件
	FILE *fp = fopen("4.txt", "w");

	if(fp == NULL){
		perror("write_file fopen");
		return;
	}
	//2.写文件
	char buf[] = "abcdef";
	int i = 0;
	int n = strlen(buf);
	for (i = 0; i < n; ++i) {
		fputc(buf[i], fp);
	}
	//3.关闭文件
	fclose(fp);
}

void read_file(){
	//1.打开文件
	FILE *fp = fopen("4.txt", "r");

	if(fp == NULL){
		perror("write_file fopen");
		return;
	}
	//2.读文件
	char ch;
	
	ch = fgetc(fp);
	printf("ch = %c\n", ch);
	
	ch = fgetc(fp);
	printf("ch = %c\n", ch);

	ch = fgetc(fp);
	printf("ch = %c\n", ch);

	//3.关闭文件
	fclose(fp);

}

int main(int argc, char *argv[])
{
	write_file();
	
	read_file();
	return 0;
}
