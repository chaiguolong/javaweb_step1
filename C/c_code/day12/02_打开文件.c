#include <stdio.h>

int main(int argc, char *argv[])
{
	FILE *fp = NULL;

	fp = fopen("./02.txt", "w");

	if(fp == NULL){
		perror("fopen");
		return -1;
	}

	fclose(fp);
	fp = NULL;
	
	return 0;
}
