#include <stdio.h>

int main(int argc, char *argv[])
{
	int a = 5;
	
	int b = 2;

	double c;

	c = a / b;

	printf("c1 = %lf\n", c);

	c = 1/2;

	printf("c2 = %lf\n", c);

	//两个数相除,想要得到小数,分子分母必须有一个是小数,否则会取整
	c = 1.0/2;

	printf("c3 = %lf\n", c);
	
	c = a * 1.0 / b;

	printf("c4 = %lf\n", c);

	return 0;
}
