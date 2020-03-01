#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = fopen(argv[1], "r");
	//2.读取文件,将内容显示到屏幕
	
	while(1){
		char ch = fgetc(fp);
		printf("%c", ch);

		if(feof(fp)){	//如果文件到结尾,跳出循环
			break;
		}
	}

	//3.关闭文件
	fclose(fp);
	
	return 0;
}
