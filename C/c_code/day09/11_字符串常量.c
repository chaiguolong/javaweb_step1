#include <stdio.h>
#include <string.h>


int main(int argc, char *argv[])
{
	//1.字符串常量就是此字符串的首元素地址
	printf("s1 = %s\n", "hello mike");

	char *p1 = "hello mike";
	printf("p1 = %p\n", p1);

	char *p2 = "hello mike";
	printf("p2 = %p\n", p2);

	//2.字符串常量,文字常量区的字符串,只读,不能修改
	printf("p1 = %c\n", *p1);//读 ok

	//3.p1指向字符串常量,字符串常量为只读,不能修改
	//*p1 = 'a';	//修改	err

	char *p3 = "hello";
	
	//4.p3指向文字常量区内存,不能改
	//strcpy(p3,"abc");	//err


	
	return 0;
}

void fun(){
	
	printf("s3 = %p\n", "hello mike");
}

int main01(int argc, char *argv[])
{
	//1.每个字符串都是一个地址,这个地址是指字符串首元素地址
	//2.字符串常量放在data区,文字常量区
	printf("s1 = %s\n", "hello mike");

	printf("s2 = %p\n", "hello mike");

	fun();

	
	printf("s4 = %s\n", "hello mike" + 1);
	
	return 0;
}
