#include <stdio.h>

struct Test{
	int a;
};

typedef struct Test2{
	int a;
}Test2;

Test2 tmp;


int main(int argc, char *argv[])
{
	//1.typedef给一个已存在的类型,起一个别名
	//2.typedef不能创建新的类型
	
	//给int起一个别名叫int64
	typedef int int64;	//有分号

	int64 a;//int a;	//宏定义发生在预处理
						//typedef是编译阶段
	
	return 0;
}
