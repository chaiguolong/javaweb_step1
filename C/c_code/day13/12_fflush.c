#include <stdio.h>

int main(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("12.txt", "w");
	fputs("今天是最后一天,好开心", fp);

	//1.默认情况,程序没有结束,也没有关闭,缓冲区满,自动刷新缓冲区
	
	//2.文件正常关闭,缓冲区的内容也会写入文件
	//fclose(fp);

	//3.文件不关闭,程序没有结束,实时刷新,调用fflush(fp);
	//fflush(fp);
	
	//4.程序正常关闭,缓冲区的内容也会写入文件
	
	while(1){
		NULL;	//目的不让程序结束
	}


	
	return 0;
}
