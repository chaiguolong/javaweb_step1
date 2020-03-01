#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("11.txt", "r");
	//读取文件
	char buf[100];

	while(1){

		fgets(buf, sizeof(buf), fp);

		if(feof(fp)){	//如果到文件结尾,跳出循环
			break;
		}

		printf("buf = %s\n", buf);

	}

	//关闭文件
	fclose(fp);
	
	return 0;
}

int main01(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("11.txt", "r");
	//读取文件
	char buf[100];
	//1.从fp所关联的文件读取内容,放到buf,一次最大读取为sizeof(buf) -1
	//2.遇到换行符,\0结束符或者出错,结束本次读取
	fgets(buf, sizeof(buf), fp);
	printf("buf = %s\n", buf);

	fgets(buf, sizeof(buf), fp);
	printf("buf = %s\n", buf);

	fgets(buf, sizeof(buf), fp);
	printf("buf = %s\n", buf);

	memset(buf, 0, sizeof(buf));

	fgets(buf, sizeof(buf), fp);
	printf("buf = %s\n", buf);

	fgets(buf, sizeof(buf), fp);
	printf("buf = %s\n", buf);

	//关闭文件
	fclose(fp);
	
	return 0;
}
