#include "SeqStack.h"
#include <stdbool.h>

struct BiNode {
	char ch;
	struct BiNode *lchild;
	struct BiNode *rchild;
};

struct Info {
	struct BiNode *node;
	bool flag;
};

//int num = 0;

void cuculateLeafNum(struct BiNode *root, int *p){
	if(NULL == root){
		return;
	}
	if(root->lchild == NULL && root->rchild == NULL){
		(*p)++;
	}
	cuculateLeafNum(root->lchild, p);
	cuculateLeafNum(root->rchild, p);
}

//二叉树递归遍历
void recursion(struct BiNode *root){
	if(NULL == root){
		return;
	}
	printf("%c ", root->ch);
	//递归遍历左子树
	recursion(root->lchild);
	//递归遍历右子树
	recursion(root->rchild);
}

int getTreeHeight(struct BiNode *root){
	if(NULL == root){
		return 0;
	}

	//求树的左子树高度
	int lheight = getTreeHeight(root->lchild);
	//求树的右子树高度
	int rheight = getTreeHeight(root->rchild);

	int height = lheight > rheight ? lheight + 1 : rheight + 1;
	return height;
}

struct BiNode *copyBiTree(struct BiNode *root){
	if(NULL == root){
		return NULL;
	}
	//先拷贝左子树
	struct BiNode *lchild = copyBiTree(root->lchild);
	//拷贝右子树
	struct BiNode *rchild = copyBiTree(root->rchild);

	struct BiNode *newnode = malloc(sizeof(struct BiNode));
	newnode->lchild = lchild;
	newnode->rchild = rchild;
	newnode->ch = root->ch;

	return newnode;
}

void showBiTree(struct BiNode *root){
	if(NULL == root){
		return;
	}
	printf("%c ", root->ch);
	showBiTree(root->lchild);
	showBiTree(root->rchild);
}

void freeSpace(struct BiNode *root){
	if(NULL == root){
		return;
	}

	//释放左子树内存
	freeSpace(root->lchild);
	//释放右子树内存
	freeSpace(root->rchild);
	
	printf("%c被释放\n", root->ch);

	free(root);
	root = NULL;

}

struct Info * createInfo(struct BiNode *node, bool flag){
	struct Info *info = malloc(sizeof(struct Info));
	info->flag = flag;
	info->node = node;

	return info;
}

void nonRecursion(struct BiNode *root){
	//初始化栈
	SeqStack stack = Init_SeqStack();
	//先把根节点压入栈中
	Push_SeqStack(stack, createInfo(root, false));
	while(Size_SeqStack(stack)){
		//获得栈顶元素
		struct Info *info = (struct Info *)Top_SeqStack(stack);
		//弹出栈顶元素
		Pop_SeqStack(stack);
		if(info->flag){
			printf("%c ", info->node->ch);
			free(info);
			continue;
		}

		//将右子树压入栈中
		if(info->node->rchild != NULL){
			Push_SeqStack(stack, createInfo(info->node->rchild, false));
		}
		//将左子树压入栈中
		if(info->node->lchild != NULL){
			Push_SeqStack(stack, createInfo(info->node->lchild, false));
		}

		//将根节点压入栈中
		info->flag = true;
		Push_SeqStack(stack, info);
	}
}

void test(){
	struct BiNode nodeA = {'A', NULL, NULL};
	struct BiNode nodeB = {'B', NULL, NULL};
	struct BiNode nodeC = {'C', NULL, NULL};
	struct BiNode nodeD = {'D', NULL, NULL};
	struct BiNode nodeE = {'E', NULL, NULL};
	struct BiNode nodeF = {'F', NULL, NULL};
	struct BiNode nodeG = {'G', NULL, NULL};
	struct BiNode nodeH = {'H', NULL, NULL};

	nodeA.lchild = &nodeB;
	nodeA.rchild = &nodeF;

	nodeB.rchild = &nodeC;
	
	nodeC.lchild = &nodeD;
	nodeC.rchild = &nodeE;

	nodeF.rchild = &nodeG;

	nodeG.lchild = &nodeH;

	nonRecursion(&nodeA);

}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
