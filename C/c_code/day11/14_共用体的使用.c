#include <stdio.h>

union Test{
	unsigned char a;
	unsigned short b;
	unsigned int c;
	//double d;
};

int main(int argc, char *argv[])
{
	//1.结构体大小可以简单认为成员大小的累加
	//2.共用体的大小最大成员的大小
	printf("%lu\n", sizeof(union Test));

	//3.共用体公用一块内存,所有成员的地址都一样
	union Test obj;

	printf("%p, %p, %p, %p\n", &obj, &obj.a, &obj.b, &obj.c);

	//4.给某个成员赋值,会影响到别的成员
	//左边是高位,右边是低位
	//高位放高地址,低位放低地址(小端)
	obj.c = 0x44332211;
	printf("obj.a = %x\n", obj.a);
	printf("obj.b = %x\n", obj.b);
	printf("obj.c = %x\n", obj.c);

	obj.a = 0xaa;
	printf("obj.a = %x\n", obj.a);
	printf("obj.b = %x\n", obj.b);
	printf("obj.c = %x\n", obj.c);
	
	obj.b = 0xccdd;
	printf("obj.a = %x\n", obj.a);
	printf("obj.b = %x\n", obj.b);
	printf("obj.c = %x\n", obj.c);

	return 0;
}
