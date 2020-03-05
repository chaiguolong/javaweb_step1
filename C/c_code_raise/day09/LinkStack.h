#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#ifdef __cplusplus
	extern "C"{
#endif

	struct StackNode{
		struct StackNode *next;
	};

	struct LStack{
		struct StackNode header;	//头节点
		int size;
	};

	typedef void * LinkStack;

	//初始化
	LinkStack Init_LinkStack();
	//入栈
	void Push_LinkStack(LinkStack stack, void *data);
	//出栈
	void Pop_LinkStack(LinkStack stack);
	//获得栈顶元素
	void * Top_LinkStack(LinkStack stack);
	//获得大小
	int Size_LinkStack(LinkStack stack);
	//销毁栈
	void Destroy_LinkStack(LinkStack stack);


#ifdef __cplusplus
}
#endif
