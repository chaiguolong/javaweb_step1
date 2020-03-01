#include <stdio.h>

int main(int argc, char *argv[])
{
	int num;

	printf("请输入num:");
	scanf("%d",&num);

	//1.switch是关键字,switch()后没有冒号;
	//2.switch()中的()中只能放整型变量或字符型变量;
	//3.switch用法类似于电梯模型
	switch (num) {
		case 1:
			printf("我按下了一楼\n");
			break;
		case 2:
			printf("我按下了二楼\n");
			break;
		case 3:
			printf("我按下了三楼\n");
			break;
		default:
			printf("其他楼层\n");
	}
	
	return 0;
}
