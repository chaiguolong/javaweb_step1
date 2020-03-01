#include <stdio.h>
#include <string.h>

struct Student{
	int age;
	char name[50];
	int score;
};	//有分号

void fun(struct Student tmp){
	printf("%d, %s, %d\n", tmp.age, tmp.name, tmp.score);
}

void fun2(const struct Student *p){

	//*p = 22;	//err

	printf("%d, %s, %d\n", p->age, p->name, p->score);

	//p = NULL;	//ok
}

int main(int argc, char *argv[])
{
	struct Student s = {18, "mike", 59};

	//fun(s);
	
	fun2(&s);
	
	return 0;
}
