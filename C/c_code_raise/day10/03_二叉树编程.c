#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct BiNode {
	char ch;
	struct BiNode *lchild;
	struct BiNode *rchild;
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

	int num = 0;

	//1.求二叉树的叶子节点数目
	cuculateLeafNum(&nodeA, &num);
	printf("叶子节点数目: %d\n", num);

	//2.求二叉树的高度
	int height = getTreeHeight(&nodeA);
	printf("树的高度: %d\n", height);

	//3.拷贝二叉树
	struct BiNode *root = copyBiTree(&nodeA);
	showBiTree(root);
	printf("\n");
	showBiTree(&nodeA);

	freeSpace(root);
}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
