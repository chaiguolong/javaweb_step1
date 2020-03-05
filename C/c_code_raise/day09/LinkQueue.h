#pragma once
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef __cplusplus
	extern "C"{
#endif
	struct QueueNode {
		struct QueueNode *next;
	};

	struct LQueue {
		struct QueueNode header;	//头节点
		int size;
		struct QueueNode *rear;		//尾指针,始终自行链表的最后一个节点
	};

	typedef void * LinkQueue;

	//初始化
	LinkQueue Init_LinkQueue();
	//入队
	void Push_LinkQueue(LinkQueue queue, void *data);
	//出队
	void Pop_LinkQueue(LinkQueue queue);
	//获得队头元素
	void * Front_LinkQueue(LinkQueue queue);
	//获得队尾元素
	void * Back_LinkQueue(LinkQueue queue);
	//大小
	int Size_LinkQueue(LinkQueue queue);
	//销毁队列
	void Destroy_LinkQueue(LinkQueue queue);
#ifdef __cplusplus
}
#endif
