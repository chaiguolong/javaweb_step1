#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char s1[] = "abc";
	
	char s2[] = "Abcd";

	//int flag = strcmp(s1,s2);
	int flag = strncmp(s1,s2,3); //指定比较前3个字符

	if(flag > 0){

		printf("[%s] > [%s]\n", s1,s2);

	}else if(flag < 0){

		printf("[%s] < [%s]\n", s1,s2);

	}else{

		printf("[%s] == [%s]\n", s1,s2);

	}
	
	return 0;
	
}

int main01(int argc, char *argv[])
{
	char s1[] = "abc";
	
	char s2[] = "abcd";

	//int flag = strcmp(s1,s2);
	int flag = strncmp(s1,s2,3);//指定比较前3个字符

	if(flag > 0){

		printf("[%s] > [%s]\n", s1,s2);

	}else if(flag < 0){

		printf("[%s] < [%s]\n", s1,s2);

	}else{

		printf("[%s] == [%s]\n", s1,s2);

	}
	
	return 0;
}
