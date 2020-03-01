#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct Person {
	char name[64];
	int age;
	int ID;
	double score;
};

//规避地址传递的副作用(在使用对象指针的情况下,有可能意外修改数据)
void printPerson(const struct Person *person)
{
	//person->ID = 128;

	//主观故意修改数据
	//struct Person *p = (struct Person *) person; 
	//p->ID = 128;


	printf("Name: %s, Age:%d, ID:%d, Score:%f\n", person->name, person->age, person->ID, person->score);
	
}

void test01()
{
	struct Person person = {"Trump", 40, 250, 59.5};
	printPerson(&person);

}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
