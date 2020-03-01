#include <stdio.h>

int main(int argc, char *argv[])
{
	
	int a;
	
	printf("请输入一个数字:");

	scanf("%d",&a);

	if(a > 0 && a < 10){

		printf("a是个位数\n");

	}else if(a < 100){

		printf("a是十位数\n");

	}else if(a < 1000){

		printf("a是百位数\n");

	}else if(a < 10000){

		printf("a是千位数\n");

	}else{

		printf("其他\n");

	}
	return 0;
}


int main01(int argc, char *argv[])
{
	int a;
	
	printf("请输入一个数字\n");

	scanf("%d",&a);

	if(a > 0 && a < 10){

		printf("a是个位数\n");

	}else if(a > 9 && a < 100){

		printf("a是十位数\n");

	}else if(a > 99 && a < 1000){

		printf("a是百位数\n");

	}else if(a > 999 && a < 10000){

		printf("a是千位数\n");

	}else{

		printf("其他\n");

	}
	
	return 0;
}
