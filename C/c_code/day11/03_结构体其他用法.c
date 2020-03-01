#include <stdio.h>

struct Student{
	int age;
	char name[50];
	int score;
}s1 ={18, "mike", 59}, s2;

struct {
	int age;
	char name[50];
	int score;
}s3, s4;

int main(int argc, char *argv[])
{
	printf("%d, %s, %d\n", s1.age, s1.name, s1.score);
	
	return 0;
}
