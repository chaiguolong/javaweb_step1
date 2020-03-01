#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Person {
	char name[64];
	int age;
};

void test01()
{
	struct Person person = {"john", 20};
	printf("Name: %s Age: %d\n", person.name, person.age);
}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}

