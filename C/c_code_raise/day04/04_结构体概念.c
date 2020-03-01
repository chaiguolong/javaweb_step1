#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#if 0
	typedef struct Persion {
		char name[64];
		int age;
	} myPerson;

	typedef struct Person MyPerson;

#endif
struct Person {
	char name[64];
	int age;
}person = {"John", 100};

struct {
	char name[64];
	int age;
}obama = {"Edword", 99};



void test01()
{
	//strcpy(person.name, "Lily");
	//person.age = 30;
	printf("Name: %s, Age: %d\n", person.name, person.age);

	struct Person p;
}

//单个结构体变量
void test02()
{
	//在栈上分配结构体空间
	//struct Person person = {"Hanmeimei", 30};
	//printf("Name=%s, Age=%d\n", person.name, person.age);

	//在堆上分配结构体空间
	struct Person *person = malloc(sizeof(struct Person));
	strcpy(person->name, "LiLei");
	person->age = 30;
	printf("Name=%s, Age=%d\n", person->name, person->age);
}

void printfStruct(struct Person *persons, int len)
{
	for (int i = 0; i < len; ++i) {
		printf("Name=%s, Age=%d\n", persons[i].name, persons[i].age);
	}
}

//多个结构体变量
void test03()
{
	//在栈上分配结构体空间
	struct Person persons[] = {
		{"aaa", 20},
		{"bbb", 30},
		{"ccc", 40}
	};

	int len = sizeof(persons) / sizeof(struct Person);

	printfStruct(persons, len);

	//在堆上分配结构体空间
	struct Person *ps = malloc(sizeof(struct Person) * 3);
	//初始化结构体数组
	for (int i = 0; i < 3; ++i) {
		sprintf(ps[i].name, "name_%d", i + 1);
		ps[i].age = 100 + i;
	}


	printfStruct(ps, 3);

}
int main(int argc, char *argv[])
{
	//test01();
	//test02();
	test03();

	
	return 0;
}
