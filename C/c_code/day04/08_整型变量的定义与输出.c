#include <stdio.h>

int main(int argc, char *argv[])
{
	//int 占4个字节
	int a;
	printf("请输入a: ");	//输出
	//scanf("请输入%d")		//err
	scanf("%d",&a);		//输入
	//scanf("%d\n",&a);  //err,没有\n;

	printf("a = %d\n", a);

	//short占2个字节
	short b;
	printf("请输入b: ");	//输出
	//%hd是短整型
	scanf("%hd",&b);		//输入
	printf("b = %hd\n", b);

	//long long 占8个字节
	long long int c;
	printf("请输入c: ");	//输出
	scanf("%lld",&c);		//输入
	printf("b = %lld\n", c);




	return 0;
}
