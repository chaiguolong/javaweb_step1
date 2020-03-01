#include <stdio.h>

//1.编译器很笨,在main函数调用其他函数,只会往前找函数的定义
//2.如果找不到函数的定义,找函数的声明,如果没有声明,C编译器会警告,C++编译器会报错
//3.如果没有定义,直接调用一个不存在的函数,会报错
//4.如果定义没有放在main函数的前面,那么在调用函数前,需要声明,声明不加extern是一样的
//5.一个函数只能定义一次,但是可以声明多次(注意)
//6.声明的形参变量名和定义的形参变量名可以不一样
//7.可以只声明,不定义函数(无意义),此函数不能调用


//函数的声明,告诉编译器,这个函数是有定义的,只是放在别的地方
extern int my_strlen(char str[]);
int my_strlen(char a[]);
int my_strlen(char b[]);
int my_strlen(char c[]);

//8.声明时,形参变量名可以不写,可以只写类型
void fun(int a, int b, int c);
int main(int argc, char *argv[])
{
	printf("len = %d\n", my_strlen("0123456789"));
	
	return 0;
}

int my_strlen(char str[]){
	int i = 0;
	while(str[i] != '\0'){
		i++;
	}
	return i;
}
