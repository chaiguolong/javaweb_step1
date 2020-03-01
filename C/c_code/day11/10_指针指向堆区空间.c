#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Student{
	int age;
	char name[50];
	int score;
};	//有分号

int main(int argc, char *argv[])
{

	//定义一个结构体类型指针
	struct Student *p;

	p = (struct Student *)malloc(sizeof(struct Student));
	if(p == NULL){
		printf("分配失败\n");
		return -1;
	}

	p->age = 18;
	strcpy(p->name, "mike");
	p->score = 59;

	printf("sizeof(struct Student) = %lu\n", sizeof(struct Student));
	printf("%d, %s, %d\n", p->age,p->name,p->score);
	
	if(p != NULL){
		free(p);
		p = NULL;
	}

	return 0;
}
