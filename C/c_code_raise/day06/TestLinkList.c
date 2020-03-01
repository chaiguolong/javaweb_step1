#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "LinkList.h"

void test(){
	//初始化链表 100 200 300 666 400 500 600
	struct LinkNode *header = Init_LinkList();
	//打印链表
	Foreach_LinkList(header);
	//插入新的节点
	InsertByValue_LinkList(header, 300, 666);
	//打印链表
	printf("\n--------------------\n");
	Foreach_LinkList(header);
	//清空链表
	Clear_LinkList(header);
	//插入新的节点
	InsertByValue_LinkList(header, 300, 666);
	InsertByValue_LinkList(header, 300, 777);
	InsertByValue_LinkList(header, 300, 888);
	InsertByValue_LinkList(header, 300, 999);
	//打印链表
	printf("\n--------------------\n");
	Foreach_LinkList(header);

	Inverse_LinkList(header);
	//逆序链表
	printf("\n---------逆序链表-----------\n");
	Foreach_LinkList(header);

	RemoveByValue_LinkList(header, 777);
	printf("\n--------------------\n");
	Foreach_LinkList(header);

	RemoveByValue_LinkList(header, 888);
	printf("\n--------------------\n");
	Foreach_LinkList(header);

	//销毁链表
	Destroy_LinkList(header);
}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
