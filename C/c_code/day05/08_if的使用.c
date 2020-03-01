#include <stdio.h>

int main(int argc, char *argv[])
{
	//1.if是个关键字,if后面有(),if()后面没有;
	//2.()里写的是条件,条件为真,执行if语句,条件为假,不执行if语句
	//if(1)
	//if(-1)
	//if(0)
	if(4>3)
	{
		printf("满足条件\n");
	}

	//3.if后面最好加{},{}代表if语句;
	//4.如果不加,只有第一句是if语句;
	if(1)
		printf("测试语句111111111111111\n");
		printf("测试语句222222222222222\n");
	

	//5.if()后面没有分号,切记
	if(0);	//if后面有分号
	{
		printf("aaaaaaaaaaa\n");
	}

	//等价于下面
	if(0)
		;
	{
		printf("aaaaaaaaaaa\n");//此语句和if没有关系,无条件顺序执行
	}

	int a = 3;
	//if(a = 4)
	if(4 == a)
	{
		printf("a等于4\n");
	}

	//if(a == 4)
	//if(4 == a)//建议写这种,常量放在前面


	
	return 0;
}
