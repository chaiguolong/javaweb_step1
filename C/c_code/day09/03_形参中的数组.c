#include <stdio.h>

//1.形参中的数组不是数组,它是普通的指针变量
//2.形参数组:int a[1000],int a[],int *a对编译器而言,没有任何区别
//3.编译器都是当int *处理
//4.形参中的数组和非形参中的数组的区别:形参中的数组时指针变量,非形参中的数组是数组
//void print_array(int a[10000])
//void print_array(int a[])
void print_array(int *a){
	int i = 0;
	int n = sizeof(a)/ sizeof(a[0]);
	printf("sizeof(a) = %d\n", sizeof(a));
	printf("sizeof(a[0]) = %d\n", sizeof(a[0]));

	for (i = 0; i < n; ++i) {
		printf("%d,", a[i]);
	}

	printf("\n");
}


void print_array2(int *a,int n){
	int i = 0;

	for (i = 0; i < n; ++i) {
		printf("%d,", a[i]);
	}

	printf("\n");
}

int main(int argc, char *argv[])
{
	int a[] = {1,-2,3,-4,5,-6,7,-8,9};

	//print_array(a);	//传递的是,数组的首元素地址,&a[0]
	
	int n = sizeof(a) / sizeof(a[0]);

	print_array2(a,n);	//应该把数组元素个数传过去


	
	return 0;
}
