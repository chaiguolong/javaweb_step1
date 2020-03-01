#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct Person {
	char *name;
	int age;
};

//分配内存
struct Person ** allocationSpace()
{
	struct Person  ** tmp = malloc(sizeof(struct Person *) * 3);
	for (int i = 0; i < 3; ++i) {
		tmp[i] = malloc(sizeof(struct Person));
		tmp[i]->name = malloc(64);
		sprintf(tmp[i]->name, "Name_%d", i+1);
		tmp[i]->age = 50 + i;
	}

	return tmp;

}

//打印结构体指针数组
void printStructArray(struct Person **arr)
{
	for (int i = 0; i < 3; ++i) {
		printf("Name: %s, Age: %d\n", arr[i]->name, arr[i]->age);
	}
	
}

//释放内存
void freeSpace(struct Person **arr)
{
	if(NULL == arr){
		return;
	}

	for (int i = 0; i < 3; ++i) {

		if(arr[i] == NULL){
			continue;
		}

		if(arr[i]->name != NULL){
			free(arr[i]->name);
			arr[i]->name = NULL;
		}

		if(arr[i] != NULL){
			free(arr[i]);
			arr[i] = NULL;
		}
	}

	free(arr);
	arr = NULL;
}

void test01()
{
	struct Person **person = NULL;
	person = allocationSpace();

	printStructArray(person);

	freeSpace(person);

}

int main(int argc, char *argv[])
{

	test01();
	
	return 0;
}
