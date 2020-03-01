#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//查找子串第一次出现的地方
char * myStrStr(const char *str, const char *subStr){
	if(NULL == str || NULL == subStr){
		return NULL;
	}

	//接收参数
	const char *myStr = str;
	const char *mySubStr = subStr;

	while(*myStr != '\0'){
		if(*myStr != *mySubStr){
			++myStr;
			continue;
		}

		//定义临时指针变量
		char *tmp_myStr = myStr;
		char *tmp_mySubStr = mySubStr;

		while(*tmp_mySubStr != '\0'){

			if(*tmp_mySubStr != *tmp_myStr){
				++myStr;
				break;
			}
			++tmp_mySubStr;
			++tmp_myStr;
		}

		if(*tmp_mySubStr == '\0'){
			return (char *)myStr;
		}

		++myStr;
	}

	return NULL;
}

void test01()
{
	char *p = "abcdefg";
	char *sub = "cd";
	char *pos = myStrStr(p,sub);
	printf("%s\n", pos);

}


int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
