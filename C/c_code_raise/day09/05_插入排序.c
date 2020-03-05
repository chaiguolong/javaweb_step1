#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void printArray(int arr[], int len){
	for (int i = 0; i < len; ++i) {
		printf("%d ", arr[i]);
	}
}

void InsertSort(int arr[], int len){
	for (int i = 1; i < len; ++i) {
		if(arr[i] < arr[i - 1]){
			int temp = arr[i];
			int j = i - 1;
			for (; j >= 0 && temp < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
}

void test(){
	int arr[] = {5, 3, 9, 2, 1, 3};
	int len = sizeof(arr) /sizeof(int);
	printArray(arr, len);
	InsertSort(arr, len);
	printf("\n");
	printArray(arr, len);
}

int main(int argc, char *argv[])
{
	test();

	
	return 0;
}
