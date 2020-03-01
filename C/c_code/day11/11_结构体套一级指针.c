#include <stdio.h>
#include <string.h>
#include <stdlib.h>
struct Student{
	int age;
	char *name;		
	int score;
};	//有分号


//成员变量指针指向堆区空间
int main(int argc, char *argv[])
{
	struct Student s;
	s.age = 18;

	s.name = (char *)malloc(sizeof(char) * strlen("mikeabchello") + 1);

	strcpy(s.name, "mikeabchello");
	s.score = 59;

	printf("%d, %s, %d\n", s.age,s.name,s.score);

	if(s.name != NULL){
		free(s.name);
		s.name = NULL;
	}

	
	return 0;
}

//成员变量指针指向栈区空间
int main02(int argc, char *argv[])
{
	struct Student s;
	s.age = 18;

	char buf[100];
	s.name = buf;	//指向栈区空间
	strcpy(s.name, "mike");

	s.score = 59;

	printf("buf = %s\n", buf);
	
	return 0;
}


//成员变量指针指向文字常量区的字符串
int main01(int argc, char *argv[])
{
	struct Student s;
	s.age = 18;
	s.name = "mike";	//指针变量保存字符串常量的首地址
	s.score = 59;
	
	return 0;
}
