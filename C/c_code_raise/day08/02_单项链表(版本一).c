#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "LinkList.h"
struct Person {
	char name[64];
	int age;
};

void myPrint(void *data){
	struct Person *person = (struct Person *)data;
	printf("Name:%s Age:%d\n", person->name, person->age);
}

int myCompare(void* d1, void *d2){
	struct Person *p1 = (struct Person *) d1;
	struct Person *p2 = (struct Person *) d2;
#if 0
	if(strcmp(p1->name ,p2->name) == 0 && p1->age == p2->age){
		return 1;
	}
	return 0;

#endif
	return strcmp(p1->name ,p2->name) == 0 && p1->age == p2->age;
}

void test(){
	//创建链表
	LinkList list = Init_LinkList();

	//创建数据
	struct Person p1 = {"aaa", 10};
	struct Person p2 = {"bbb", 20};
	struct Person p3 = {"ccc", 30};
	struct Person p4 = {"ddd", 40};
	struct Person p5 = {"eee", 50};
	struct Person p6 = {"fff", 60};
	struct Person p7 = {"ggg", 70};

	//插入数据
	Insert_LinkList(list,0,&p1);
	Insert_LinkList(list,0,&p2);
	Insert_LinkList(list,1,&p3);
	Insert_LinkList(list,2,&p4);
	Insert_LinkList(list,20,&p5);
	Insert_LinkList(list,3,&p6);
	Insert_LinkList(list,6,&p7);

	Foreach_LinkList(list, myPrint);
	printf("--------------------\n");
	printf("List Size: %d\n", Size_LinkList(list));
	RemoveByPos_LinkList(list, 3);
	printf("--------------------\n");
	Foreach_LinkList(list, myPrint);

	struct Person pDelPerson = {"ggg", 70};
	RemoveByVal_LinkList(list, &pDelPerson, myCompare);
	printf("--------------------\n");
	Foreach_LinkList(list, myPrint);

	//清空列表
	Clear_LinkList(list);
	printf("--------------------\n");
	printf("List Size: %d\n", Size_LinkList(list));

	//销毁列表
	Destroy_LinkList(list);
}

int main(int argc, char *argv[])
{
	test();	
	return 0;
}
