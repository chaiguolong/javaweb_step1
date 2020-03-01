#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct Person{
	char name[64];
	int age;
};

struct Teacher {
	char *name;
	int age;
};

void test01()
{
	struct Person person1 = {"aaa", 20};
	struct Person person2 = {"bbb", 30};

	//赋值操作
	person2 = person1;

	printf("Name=%s, Age=%d\n", person1.name, person1.age);
	printf("Name=%s, Age=%d\n", person2.name, person2.age);

}

void test02()
{
	struct Teacher teacher1;
	struct Teacher teacher2;

	teacher1.name = malloc(64);
	strcpy(teacher1.name, "aaaaaa");
	teacher1.age = 30;

	teacher2.name = malloc(128);
	strcpy(teacher2.name, "bbbbbbbbbbbb");
	teacher2.age = 30;


	printf("Name=%s, Age=%d\n", teacher1.name, teacher1.age);
	printf("Name=%s, Age=%d\n", teacher2.name, teacher2.age);

	//赋值操作
	//不使用结构体默认的赋值行为
	//teacher1 = teacher1;
	//如果结构体内部有指针指向堆内存,那么就不能使用编译器默认的赋值行为,应该手动控制赋值行为

	printf("------------------------------------------------\n");

	if(teacher1.name != NULL){
		free(teacher1.name);
		teacher1.name = NULL;
	}

	teacher1.name = malloc(strlen(teacher2.name) + 1);

	strcpy(teacher1.name, teacher2.name);
	teacher1.age = teacher2.age;

	printf("Name=%s, Age=%d\n", teacher1.name, teacher1.age);
	printf("Name=%s, Age=%d\n", teacher2.name, teacher2.age);

	//释放内存空间
	if(teacher1.name != NULL){
		free(teacher1.name);
		teacher1.name = NULL;
	}


	if(teacher2.name != NULL){
		free(teacher2.name);
		teacher2.name = NULL;
	}
}

int main(int argc, char *argv[])
{
	//test01();
	test02();
	
	return 0;
}
