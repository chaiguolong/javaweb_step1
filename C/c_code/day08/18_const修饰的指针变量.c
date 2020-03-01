#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.指针变量
	//2.指针所指向的变量
	
	int a = 10;

	int *p1 = &a;

	*p1 = 100;	//等价于操作a,*p1操作指针所指向的空间

	p1 = NULL;	//操作指针变量

	//const修饰*,代表指针所指向的内存是只读
	const int *p2 = &a;
	//*p2 = 100;	//err
	p2 = NULL;	//ok
	
	//const修饰*,代表指针所指向的内存是只读
	int const *p3 = &a;
	//*p3 = 100		//err
	p3 = NULL;	//ok

	//const修饰指针变量,代表指针变量的值为只读
	int * const p4  = &a;
	*p4 = 100;	//ok
	//p4 = NULL;	//err
	
	const int * const p5 = &a;
	





	

	return 0;
}
