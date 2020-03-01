#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = fopen("7.txt", "r");
	
	//2.读区文件
	while(1){
		printf("文件没有结尾\n");
		int ch = fgetc(fp);	//读取的目的是为了判断文件是否结尾
		printf("ch = %d\n", ch);

		if(feof(fp)){	//如果文件结尾,跳出循环
			break;
		}
	}

	//3.关闭文件
	fclose(fp);
	fp = NULL;
	
	return 0;
}
