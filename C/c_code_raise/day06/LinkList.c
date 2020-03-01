#include "LinkList.h"

//初始化链表
struct LinkNode *Init_LinkList(){
	//创建头节点
	struct LinkNode *header = malloc(sizeof(struct LinkNode));
	header->data = -1;
	header->next = NULL;

	//尾部指针
	struct LinkNode *pRear = header;

	int val = -1;
	while(true){
		printf("输入插入的数据:\n");
		scanf("%d", &val);
		if(val == -1){
			break;
		}
		//先创建新节点
		struct LinkNode *newNode = malloc(sizeof(struct LinkNode));
		newNode->data = val;
		newNode->next = NULL;

		//新节点插入链表
		pRear->next = newNode;
		//更新尾部节点
		pRear = newNode;
	}
	return header;
}
//在值为oldval后面插入一个新的数据newval
void InsertByValue_LinkList(struct LinkNode *header, int oldval, int newval){
	if(NULL == header){
		return;
	}
	//定义两个辅助指针变量
	struct LinkNode *pPrev = header;
	struct LinkNode *pCurrent = header->next;

	while(pCurrent != NULL){
		if(pCurrent->data == oldval){
			break;
		}
		pPrev = pCurrent;
		pCurrent = pCurrent->next;
	}

	//如果pCurrent为空,说明链表不存在oldVal,注释掉下面代码表示不存在就直接添加到尾部
	//if(pCurrent == NULL){
	//	return;
	//}

	//先创建新节点
	struct LinkNode *newNode = malloc(sizeof(struct LinkNode));
	newNode->data = newval;
	newNode->next = NULL;

	//新节点插入链表中
	newNode->next = pCurrent;
	pPrev->next = newNode;
}
//删除值为val的节点
void RemoveByValue_LinkList(struct LinkNode *header, int delValue){
	if(NULL == header){
		return;
	}

	//两个辅助指针变量
	struct LinkNode *pPrev = header;
	struct LinkNode *pCurrent = header->next;

	while(pCurrent != NULL){
		if(pCurrent->data == delValue){
			break;
		}
		pPrev = pCurrent;
		pCurrent = pCurrent->next;
	}

	if(NULL == pCurrent){
		return;
	}

	//重新建立待删除节点的前驱和后继节点关系
	pPrev->next = pCurrent->next;
	//释放删除节点内存
	free(pCurrent);
	pCurrent = NULL;

}
//遍历
void Foreach_LinkList(struct LinkNode *header){
	if(NULL == header){
		return;
	}
	//辅助指针变量
	struct LinkNode *pCurrent = header->next;

	while(pCurrent != NULL){
		printf("%d ", pCurrent->data);
		pCurrent = pCurrent->next;
	}

}

//逆序
void Inverse_LinkList(struct LinkNode *header){
	if(NULL == header){
		return;
	}
	//定义辅助指针
	struct LinkNode *pPrev = NULL;
	struct LinkNode *pCurrent = header->next;
	struct LinkNode *pNext = NULL;
	//遍历链表,改变next指向
	while(pCurrent != NULL){
		pNext = pCurrent->next;
		pCurrent->next = pPrev;

		pPrev = pCurrent;
		pCurrent = pNext;
	}
	//将pCurrent挂载到header.next上
	header->next = pPrev;
}

//销毁
void Destroy_LinkList(struct LinkNode *header){
	if(NULL == header){
		return;
	}

	//定义辅助指针
	struct LinkNode *pCurrent = header;
	while(pCurrent != NULL){
		//先保存下当前节点的下一个节点地址
		struct LinkNode *pNext = pCurrent->next;
		//释放当前节点地址
		free(pCurrent);
		//当前节点指针后移
		pCurrent = pNext;
	}
}
//清空
void Clear_LinkList(struct LinkNode *header){
	if(NULL == header){
		return;
	}
	
	//辅助指针变量
	struct LinkNode *pCurrent = header->next;
	while(pCurrent != NULL){
		//先保存下当前节点的下一个节点地址
		struct LinkNode *pNext = pCurrent->next;
		//释放当前节点内存
		free(pCurrent);
		//指向下一个节点
		pCurrent = pNext;
	}
	header->next = NULL;
}

