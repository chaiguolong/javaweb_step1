#include<stdio.h>
#include<string.h>
#include<stdlib.h>


//主调函数分配内存,被调函数使用内存, 指针的输入特性
void printString(char *str)
{
	printf("打印输出: %s\n", str + 2);
}

void printStringArray(char **arr, int len)
{
	//arr[0]是char *类型的
	
	for (int i = 0; i < len; ++i) {
		printf("%s ", arr[i]);
	}

	printf("\n");
}

void test01()
{
	//堆上分配内存
	char *s = malloc(sizeof(char) * 100);
	memset(s, 0, 100);
	strcpy(s, "I am polly!");
	printString(s);

	double arr[] = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8};

	//栈上分配
	char * strs[] = {
		"aaaa",
		"bbbb",
		"cccc",
		"dddd"
	};

	int len = sizeof(strs)/sizeof(strs[0]);

	printStringArray(strs, len);
}

//输出特性 被调函数分配内存 主调函数使用内存

void allocateSpace(char **temp)
{
	char *p = malloc(100);
	memset(p, 0, 100);
	strcpy(p, "hello world");

	*temp = p;
}

void test02()
{
	char *p = NULL;
	allocateSpace(&p);

	printf("p = %s\n", p);

	if(p != NULL){
		free(p);
		p = NULL;
	}

}


int main(int argc, char *argv[])
{
	test02();
	
	return 0;
}
