#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "ConfigFile.h"

void test01()
{
	char **fileData = NULL;
	int lines = 0;

	struct ConfigInfo *info = NULL;

	//加载配置文件
	loadFile_ConfigFile("./config.ini", &fileData, &lines);
	//解析配置文件
	parseFile_ConfigFile(fileData, lines, &info);

	printf("ip: %s\n", getInfo_ConfigFile("ip",info, lines));

	destroyInfo_ConfigFile(info);


	
}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
