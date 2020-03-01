#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Student{
	int age;
	char *name;
	int score;
};	//有分号

int main(int argc, char *argv[])
{
	struct Student *p;

	p = (struct Student *) malloc(sizeof(struct Student));

	if(p == NULL){
		printf("分配失败\n");
		return 0;
	}

	p->age = 18;

	p->name = (char *)malloc(strlen("mike") + 1);

	if(p->name == NULL){
		printf("分配失败\n");
		return 0;
	}

	strcpy(p->name, "mike");

	p->score = 59;

	printf("%d, %s, %d\n", p->age, p->name, p->score);

	//先释放name
	if(NULL != p->name){
		free(p->name);
		p->name = NULL;
	}


	//再释放p
	if(NULL != p){
		free(p);
		p = NULL;
	}

	
	return 0;
}
