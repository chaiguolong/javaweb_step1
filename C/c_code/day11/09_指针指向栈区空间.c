#include <stdio.h>
#include <string.h>

struct Student{
	int age;
	char name[50];
	int score;
};	//有分号

int main(int argc, char *argv[])
{
	//在栈区定义一个结构体变量
	struct Student a;

	//定义一个结构体类型指针
	struct Student *p = &a;

	p->age = 18;
	strcpy(p->name, "mike");
	p->score = 59;

	printf("%d, %s, %d\n", p->age,p->name,p->score);
	printf("%d, %s, %d\n", a.age,a.name,a.score);
	
	return 0;
}
