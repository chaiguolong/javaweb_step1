#include <stdio.h>

int main(int argc, char *argv[])
{
	int j = 0;

	for (j = 0; j < 10; ++j) {
		if(5 == j){
			//break; //跳出真个循环,不再执行循环
			continue;//跳出的是本次循环,下次继续
		}
		printf("j = %d\n", j);
	}

	return 0;
}
