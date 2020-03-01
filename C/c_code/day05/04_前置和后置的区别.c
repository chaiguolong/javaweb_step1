#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 1;
	int b = 0;

	//后置++,先用后加
	//1.先把a的值赋给b
	//2.a在自身++
	b = a++;
	printf("a1 = %d,b1 = %d\n", a,b);


	a = 1;
	b = 0;

	//前置++,先加后用
	b = ++a;
	printf("a2 = %d,b2 = %d\n", a,b);

	a = 1;
	b = 0;

	a++;	//先执行完这语句,再执行下一句
	b = a;	//执行到此语句,a已经是2了
	printf("a3 = %d,b3 = %d\n", a,b);
	
	return 0;
}
