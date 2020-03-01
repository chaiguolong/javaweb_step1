#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 10;

	if(1){
		int a = 11;
		//就近
		printf("a = %d\n", a);	//a = 11
	}
	
	//1.if()中的a只能在if{}中使用
	//2.离开if{},if中的a已经释放
	printf("a = %d\n", a);	//a = 10

	return 0;
}

int main01(int argc, char *argv[])
{
	//1.在{}内部定义的变量就是局部变量
	//2.只有执行到定义变量的这个语句,系统才会给这个变量分配空间
	//3.当离开{},这个非static局部自动释放
	//4.局部变量的作用域在当前的{},离开此{},无法使用此变量
	//5.{}的普通局部变量,加不加auto关键字等价,普通局部变量也加自动变量
	
	auto int tmp = 11;	//加不加auto关键字等价

	{
		int a = 10;

		{
			a = 11;	//ok,还在作用范围内
		}
	}

	//a = 11;	//err 离开作用域


	if(1){
		
		int b = 10;

	}

	//b = 11;	//err

	//for (int i = 0; int i < 10; ++i) {
		//i只属于for语句,离开for就不能使用
		
	//}

	//printf("i = %d\n", i);
	
	return 0;
}
