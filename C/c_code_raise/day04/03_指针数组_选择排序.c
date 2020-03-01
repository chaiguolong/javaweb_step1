#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void selectSort(char **arr, int len)
{
	for (int i = 0; i < len; ++i) {
		int min = i;
		int j = 0;
		for (j = i + 1; j < len; ++j) {
			if(strcmp(arr[j], arr[min]) < 0){
				min = j;
			}
		}

		if(min != i){
			char *tmp = arr[min];
			arr[min] = arr[i];
			arr[i] = tmp;
		}
	}
}

void printArray(char **arr, int len)
{
	for (int i = 0; i < len; ++i) {
		printf("%s ", arr[i]);
	}
	printf("\n");
}

void test01()
{
	char *pArr[] = {"nnn", "hhh", "bbb", "aaa", "ppp", "ccc", "mmm"};

	int len = sizeof(pArr)/sizeof(pArr[0]);

	printArray(pArr, len);

	selectSort(pArr, len);

	printf("---------------------------\n");

	printArray(pArr, len);

}

int main(int argc, char *argv[])
{
	test01();
	
	return 0;
}
