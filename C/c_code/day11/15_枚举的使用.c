#include <stdio.h>

//#define pink 0;
//#define red 1;
//#define green 2;
//#define white 3;
//#define blue 4;
//#define yellow 5;

/*! \enum Color
 *
 *  Detailed description
 */
//枚举类型enum Color
//成员:枚举成员,枚举常量
enum Color { pink, red, green, white, blue, yellow };

int main(int argc, char *argv[])
{
	int flag = 1;

	if(flag == red){
		printf("red\n");
	}

	//枚举变量flag2
	enum Color flag2;

	flag2 = pink;//等价于flag2 = 0;

	//也可以使用常量给flag2赋值,不推荐
	flag2 = 3;
	
	return 0;
}
