#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{

	char *p = "abcdlsjflkdabcdlkjdfklabcdkjsdlabcd23rlkdflsj";

	int i = 0;

	char *tmp = NULL;

	while(1){

		//查找匹配字符串,如果找到,返回字符串的地址,如果没有找到,返回NULL
		tmp = strstr(p,"abcd");

		if(tmp == NULL){	//没有找到

			break;	//跳出循环

		}else{	//找到
			i++;	//累加
			p = tmp + strlen("abcd");	//重新设置寻找的起点
		}

	}

	printf("abcd在str中出现的次数: %d\n", i);
	
	return 0;
}
