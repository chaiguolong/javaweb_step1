#include <stdio.h>

//无参有返回值函数定义: //1.第一个int代表函数的返回类型,函数内部通过return返回
//2.return作用终止当前函数
//3.返回值可以是常量,变量,表达式
int fun(){

	return 10;	//返回常量
}

int fun1(){

	int a = 11;
	
	return a; //返回变量
}

int fun2(){
	int a = 10;
	int b = 20;

	return a > b ? a : b;	//返回表达式
}

//4.函数返回值只能返回一个,不能返回多个.

//5.如果return的类型和函数返回值不一致,以函数返回类型为准

int fun3(){

	return 10.11;
}


int main(int argc, char *argv[])
{

	//1.如果函数有返回值,这个函数的返回值可以不用
	fun();
	//2.如果使用返回值,最好要定义匹配类型的变量接收
	int a = fun();
	printf("a = %d\n", a);

	int b;
	b = fun();
	printf("b = %d\n", b);

	//int = fun();	//err

	printf("tmp = %d\n", fun());

	printf("fun3 = %d\n", fun3());
	
	return 0;
}
