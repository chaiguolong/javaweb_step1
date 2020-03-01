#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("4.txt", "w");
	//写文件
	//设置随机种子

	srand((unsigned int)time(NULL));
	
	int i = 0;
	int n = 10;
	int num = 0;
	for (i = 0; i < 3; ++i) {
		num = rand() % 100;
		fprintf(fp,"%d\n", num);
	}
	//关闭文件
	fclose(fp);
	
	return 0;
}
