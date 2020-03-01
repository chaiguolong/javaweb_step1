#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX 3


struct dict{
	char *key;
	char *content;
};

void get_dict(struct dict **tmp){

	*tmp = (struct dict *)malloc(MAX * sizeof(struct dict));

	if(*tmp == NULL){
		return;
	}

	//需要给每个结构体设置内容
	
	//第0个机构体,放第0个单词
	(*tmp +0)->key = (char *)malloc(sizeof(strlen("a") + 1));
	strcpy((*tmp + 0)->key, "a");

	//第0个单词的解析
	(*tmp +0)->content = (char *)malloc(sizeof(strlen("art. 一;字母A") + 1));
	strcpy((*tmp + 0)->content, "art. 一;字母A");
	
	//第1个机构体,放第1个单词
	(*tmp)[1].key = (char *)malloc(sizeof(strlen("a.m.") + 1));
	strcpy((*tmp)[1].key, "a.m.");

	//第1个单词的解析
	(*tmp)[1].content = (char *)malloc(sizeof(strlen("上午") + 1));
	strcpy((*tmp)[1].content, "上午");

	//第2个机构体,放第2个单词
	(*tmp)[2].key = (char *)malloc(sizeof(strlen("abandon") + 1));
	strcpy((*tmp)[2].key, "abandon");

	//第2个单词的解析
	(*tmp)[2].content = (char *)malloc(sizeof(strlen("v. 放弃；抛弃；放纵 n. 放纵") + 1));
	strcpy((*tmp)[2].content, "v. 放弃；抛弃；放纵 n. 放纵");
}

void print_dict(struct dict *p){

	int i = 0;

	for (i = 0; i < MAX; ++i) {

		printf("[%s]%s\n", p[i].key, p[i].content);
		
	}

}

int search_dict(struct dict *p, char *key, char *content){

	int i = 0;
	for (i = 0; i < MAX; ++i) {
		
		if(strcmp(key, p[i].key) ==  0){

			strcpy(content, p[i].content);

			return 1;
		}

	}

	return 0;
}

void free_dict(struct dict *p){
	int i = 0;
	//先释放子节点
	for (i = 0; i < MAX; ++i) {
		if(p[i].key != NULL){
			free(p[i].key);
			p[i].key = NULL;
		}

		if(p[i].content != NULL){
			free(p[i].content);
			p[i].content = NULL;
		}
	}

	//在释放结构体指针变量
	/* free(p); */
	/* p = NULL; */
}

int main(int argc, char *argv[])
{
	struct dict *p = NULL;

	//1.给p分配空间,分配完空间,需要设置内容
	get_dict(&p);

	//2.遍历单词
	print_dict(p);

	//3.查询功能
	char key[1024];	//单词

	char content[1024];	//解释

	while(1){
		printf("请输入要查询的单词:");
		scanf("%s", key);

		if(strcmp(key, "break") == 0){
			break;
		}

		//如果有返回值,则为真,没有返回值,则为假
		int ret = search_dict(p, key, content);

		if(ret == 0){
			printf("没有此单词%s\n", key);
		}else{
			printf("[%s]的解释为%s\n", key, content);
		}


	}


	//4.释放空间
	free_dict(p);

	return 0;
}
