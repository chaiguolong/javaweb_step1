#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int getFileLines(FILE *file){
	if(NULL == file){
		return -1;
	}

	int lines = 0;
	char buf[1024] = {0};

	while(fgets(buf, 1024, file) != NULL){
		++lines;
	}

	//将文件指针恢复到起始位置
	fseek(file, 0, SEEK_SET);

	return lines;
}

void readFileData(FILE *file, int lines, char **contents)
{
	if(NULL == file){
		return;
	}
	if(NULL == contents){
		return;
	}
	if(lines < 0){
		return;
	}
	
	//创建缓冲区
	char buf[1024] = {0};

	int index = 0;

	while(fgets(buf, 1024, file) != NULL){
		//printf("%s", buf);

		//获取文件长度
		int curLineLen = strlen(buf) + 1;
		//根据文件长度,分配指定长度的内存
		char *content = malloc(sizeof(char) * curLineLen);
		//将文件内容拷贝到指定内存
		strcpy(content, buf);
		//将文件写入5个数组
		contents[index++] = content;

		memset(buf, 0 , 1024);
	}
	
}

void showLinesContents(char **contents, int lines)
{
	if(NULL == contents){
		return;
	}

	if(lines < 0 ){
		return;
	}

	for (int i = 0; i < lines; ++i) {
		printf("%d行: %s", lines, contents[i]);
	}
}

void freeSpace(char **contents, int lines)
{
	if(NULL == contents){
		return;
	}

	if(lines < 0 ){
		return;
	}

	for (int i = 0; i < lines; ++i) {
		if(NULL != contents[i]){
			free(contents[i]);
			contents[i] = NULL;
		}
	}

	free(contents);
	contents = NULL;
	
}

void test01()
{
	//打开文件
	FILE *file = fopen("./test.txt", "r");
	if(NULL == file){
		printf("文件打开失败!\n");
	}

	//统计文件行数
	int lines = getFileLines(file);

	printf("lines: %d\n", lines);

	char **pContents = malloc(sizeof(char *) * lines);

	//读取文件
	readFileData(file, lines, pContents);
	
	//关闭文件
	fclose(file);

	//打印文件
	showLinesContents(pContents, lines);

	//释放内存
	freeSpace(pContents, lines);
}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
