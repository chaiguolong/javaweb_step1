#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void test01()
{
	FILE *file = fopen("./test.txt", "r");

	if(NULL == file){
		printf("打开文件失败!\n");
		return;
	}

	char ch;
#if 0
	while(!feof(file)){
		ch = fgetc(file);
		if(feof(file)){
			break;
		}
		printf("%c", ch);
	}

#endif
	while((ch = fgetc(file)) != EOF){
		printf("%c", ch);
	}

	//关闭文件
	fclose(file);
	file = NULL;
}

struct Person {
	char *name;
	int age;
};

void test02()
{
	struct Person p1 = {"aaa", 20};
	
}



int main(int argc, char *argv[])
{
	test01();
	//printf("%c\n", EOF);
	
	return 0;
}
