#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct BiNode {
	char ch;
	struct BiNode *lchild;
	struct BiNode *rchild;
};

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

	recursion(&nodeA);
}

int main(int argc, char *argv[])
{
	test();

	
	return 0;
}
