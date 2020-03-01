#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 4;
	if(3 == a){
		printf("a == 3\n");
	}else if(3 < a){
		printf("a > 3\n");
	}else if(3 > a){
		printf("a < 3\n");
	}else{
		printf("这是不可能\n");
	}
	
	return 0;
}

int main01(int argc, char *argv[])
{
	int a = 4;
	if(3 == a){//如果3和a相等,执行if语句
		printf("a和3相等\n");
	}
	//1.if else结构,这个else可以不写,else不是必须的
	//2.else后面不要接条件
	else
	{
		printf("a和3相等\n");
	}
	
	return 0;
}
