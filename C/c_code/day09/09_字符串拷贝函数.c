#include <stdio.h>

void my_strcpy(char *dsc, char *src){
	int i = 0;

	while(*(src+i) != '\0'){

		*(dsc+i) = *(src+i);

		i++;
	}

	*(dsc + i) = '\0';
}

int main(int argc, char *argv[])
{
	char src[] = "hello mike";

	char dsc[100];

	my_strcpy(dsc,src);	//自定义拷贝函数

	printf("dsc = %s\n", dsc);

	
	return 0;
}
