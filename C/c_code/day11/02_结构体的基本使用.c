#include <stdio.h>
#include <string.h>

//定义一个结构体类型
//1.struct是关键字
//2.struct Student合起来才是结构体类型
//3.结构体内部定义的变量不能直接赋值
//4.结构体只是一个类型,没有定义变量前,是没有分配空间,没有空间,就不能赋值

struct Student{
	int age;
	char name[50];
	int score;
};	//有分号

int main(int argc, char *argv[])
{
	//定义结构体变量
	//1.类型名 变量名
	struct Student stu;	//别忘了struct关键字

	//1.结构体变量初始化,和数组一样,要使用大括号
	//2.只有在定义时,才能初始化
	struct Student stu2 = {18, "mike", 59};

	//使用结构体成员,不能直接使用,需要借助结构体变量来引用
	struct Student tmp;

	//如果是普通变量,使用.点运算符
	tmp.age = 18;
	//tmp.name = "mike";	//name成员是数组名,数组名是常量,不能修改
	strcpy(tmp.name,"mike");
	tmp.score = 59;

	//如果是指针变量,使用->
	//如果是指针,指针有合法指向,才能操作结构体成员
	struct Student *p;
	p = &tmp;
	p->age = 18;
	strcpy(p->name, "mike");
	p->score = 59;

	//任何结构体变量都可以用. 和 -> 操作成员
	(&tmp)->age = 18;
	//.点的优先级高于*
	(*p).age = 18;
	p[0].age = 18;

	int age;

	int score;

	age = 18;

	
	return 0;
}
