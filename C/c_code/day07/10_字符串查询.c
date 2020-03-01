#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char buf[] = "abcdefg";

	//在buf中查询字串"cde",如果找到返回匹配字符串所在位置的地址
	//如果查询失败,返回NULL
	char *p = strstr(buf,"cde");

	if(p == NULL){

		printf("查询失败\n");

	}else{
		printf("p = %s\n", p);
	}
	
	return 0;
}

int main01(int argc, char *argv[])
{
	char buf[] = "abcdefg";

	//在buf中查询字符d,如果找到返回d所在位置的地址
	//如果查询失败,返回NULL
	char *p = strchr(buf,'d');

	if(p == NULL){

		printf("查询失败\n");

	}else{
		printf("p = %s\n", p);
	}


	
	return 0;
}
