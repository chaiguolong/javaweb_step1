#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct LinkNode {
	struct LinkNode *next;
};

struct Person {
	struct LinkNode node;
	char name[64];
	int age;
};

void test(){
	struct Person p1 = {{NULL}, "aaa", 10};
	struct Person p2 = {{NULL}, "bbb", 20};
	struct Person p3 = {{NULL}, "ccc", 30};
	struct Person p4 = {{NULL}, "ddd", 40};
	struct Person p5 = {{NULL}, "eee", 50};

	struct LinkNode *pp1 =(struct LinkNode *) &p1;
	struct LinkNode *pp2 =(struct LinkNode *) &p2;
	struct LinkNode *pp3 =(struct LinkNode *) &p3;
	struct LinkNode *pp4 =(struct LinkNode *) &p4;
	struct LinkNode *pp5 =(struct LinkNode *) &p5;

	pp1->next = pp2;
	pp2->next = pp3;
	pp3->next = pp4;
	pp4->next = pp5;
	pp5->next = NULL;

	struct LinkNode *pCurrent = pp1;
	while(pCurrent != NULL){
		struct Person *person = (struct Person *)pCurrent;
		printf("Name: %s Age: %d\n", person->name, person->age);
		pCurrent = pCurrent->next;
	}

}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
