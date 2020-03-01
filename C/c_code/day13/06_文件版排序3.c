#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
/* #define MAX 500; */

void write_file(){
	
	FILE *fp = NULL;
	//以写的方式打开文件
	fp = fopen("6.txt", "w");
	if(fp == NULL){
		perror("write_file fopen");
		return;
	}

	//设置随机种子
	srand((unsigned int) time (NULL));

	int i = 0;
	int num;

	for(i = 0; i < 500; i++) {
		num = rand() % 100; //随机数控制在100以内

		//格式化一个字符串
		fprintf(fp, "%d\n", num);
	}

	//关闭文件
	fclose(fp);
	fp = NULL;
}



void read_file(){
	FILE *fp = NULL;
	//以读的方式打开文件
	fp = fopen("6.txt", "r");
	if(fp == NULL){
		perror("read_file fopen");
		return;
	}

	int a[1024];
	int i = 0;
	int num;

	while(1){
		fscanf(fp, "%d\n", &num);
		a[i] = num;
		i++;

		if(feof(fp)){
			break;
		}

	}

	int n = i;
	int j = 0;
	printf("n = %d\n", n);

	//数组排序
	int tmp;
	for (i = 0; i < n-1; ++i) {
		for (j = 0; j < n-1-i; ++j) {
			if(a[j] > a[j+1]){
				tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
	}


	//关闭文件
	fclose(fp);
	fp = NULL;


	//关闭文件,重新写文件
	fp = fopen("6.txt", "w");

	/* char dst[4 * 1024] = {0}; */
	for (i = 0; i < n; ++i) {
		fprintf(fp, "%d\n", a[i]);
	}

	fclose(fp);



}

int main(int argc, char *argv[])
{
	write_file();
	read_file();
	return 0;
}
