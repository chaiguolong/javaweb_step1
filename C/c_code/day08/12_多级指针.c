#include <stdio.h>

int main(int argc, char *argv[])
{
	//如何定义一个合适类型的变量保存另一个变量的地址
	//在需要保存变量地址的类型上加一个*
	
	int a = 10;

	int *p = &a;

	int **q = &p;

	int ***t = &q;

	int ****m = &t;


	*m;
	**m;
	***m;
	****m;

	
	return 0;
}
