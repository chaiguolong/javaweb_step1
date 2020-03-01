#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include <iostream>

typedef struct Person{
	char name[64];
	int age;
}myPerson;

void test01(){
	myPerson p;
}

typedef char* PCHAR;

void test02(){
	PCHAR p1, p2;

	std::cout << typeid(p1).name() << std::endl;
	std::cout << typeid(p2).name() << std::endl;
}

typedef int mytype_t;
//有利于程序的一致性
void test03(){
	mytype_t a;
}

int main(int argc, char *argv[])
{
	test02();
	
	return 0;
}
