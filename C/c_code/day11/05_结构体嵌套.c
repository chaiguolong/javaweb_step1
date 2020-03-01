#include <stdio.h>
#include <string.h>

struct Info{
	int age;
	char name[50];
};

struct Student{
	struct Info info;
	int score;
};

int main(int argc, char *argv[])
{
	struct Student s;
	s.info.age = 18;
	strcpy(s.info.name, "mike");
	s.score = 59;

	struct Student *p = &s;
	p->info.age = 19;
	strcpy(p->info.name, "jack");
	p->score = 60;


	struct Student tmp = {
		{18, "mike"}, 
		88
	};

	printf("%d, %s, %d\n", tmp.info.age, tmp.info.name, tmp.score);




	
	return 0;
}
