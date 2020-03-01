#include <stdio.h>
#include <string.h>

struct Student{
	int age;
	char name[50];
	int score;
};	//有分号

void setStu(struct Student tmp){
	tmp.age = 22;
	strcpy(tmp.name, "john");
	tmp.score = 77;
	printf("%d, %s, %d\n", tmp.age, tmp.name, tmp.score);
}

int main(int argc, char *argv[])
{
	struct Student s = {18, "mike", 59};

	setStu(s);

	printf("%d, %s, %d\n", s.age, s.name, s.score);

	
	return 0;
}
