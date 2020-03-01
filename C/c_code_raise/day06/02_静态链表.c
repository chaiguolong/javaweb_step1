#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct LinkNode {
	int data;
	struct LinkNode *next;
};

void test01()
{
	struct LinkNode node1 = {10, NULL};
	struct LinkNode node2 = {20, NULL};
	struct LinkNode node3 = {30, NULL};
	struct LinkNode node4 = {40, NULL};
	struct LinkNode node5 = {50, NULL};
	struct LinkNode node6 = {60, NULL};

	node1.next = &node2;
	node2.next = &node3;
	node3.next = &node4;
	node4.next = &node5;
	node5.next = &node6;

	//如何遍历一个链表
	//先定义一个辅助指针变量
	struct LinkNode *pCurrent = NULL;
	pCurrent = &node1;
	while(pCurrent != NULL){
		printf("data: %d \n", pCurrent->data);
		pCurrent = pCurrent->next;
	}
}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
