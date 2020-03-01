#include <stdio.h>
#include <string.h>

void write_file(){
	//1.打开文件
	FILE *fp = fopen("6.txt", "w");

	if(fp == NULL){
		perror("write_file fopen");
		return;
	}
	//2.写文件
	fputc('a',fp);
	fputc('b',fp);
	fputc('c',fp);
	fputc(-1,fp);
	fputc('d',fp);
	fputc(-1,fp);
	fputc('e',fp);
	//3.关闭文件
	fclose(fp);
}

void read_file(){
	//1.打开文件
	FILE *fp = fopen("6.txt", "r");

	if(fp == NULL){
		perror("write_file fopen");
		return;
	}
	//2.读文件
	char ch;
	
	while(1){

		ch = fgetc(fp);

		if(feof(fp)){
			break;
		}

		printf("ch = %d\n", ch);

	}
	
	//3.关闭文件
	fclose(fp);

}

int main(int argc, char *argv[])
{
	write_file();
	
	read_file();
	return 0;
}
