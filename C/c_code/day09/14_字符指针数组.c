#include <stdio.h>

//void fun(int a[])
//void fun(int a[10])
void fun(int *a){

}

//void print_array(char *p[100], int n){
//void print_array(char *p[], int n)
void print_array(char * *p, int n){

	int i = 0;

	for (i = 0; i < n; ++i) {
		printf("%s\n", p[i]);
	}

}

int main(int argc, char *argv[])
{
	int a[10];

	fun(a);
	
	char *p[] = {"hello","mike","abc"};

	int n = sizeof(p) / sizeof(*p);

	print_array(p,n);


	return 0;
}

//int main01(int argc, char * *argv)
int main01(int argc, char *argv[])
{
	char *p1 = "hello";
	char *p2 = "mike";
	char *p3 = "abc";

	char *p[] = {"hello","mike","abc"};
	int n = sizeof(p) / sizeof(*p);
	int i = 0;

	for (i = 0; i < n; ++i) {
		printf("%s\n", p[i]);
	}




	return 0;
}
