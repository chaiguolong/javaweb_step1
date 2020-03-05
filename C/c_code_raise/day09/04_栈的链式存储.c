#include "LinkStack.h"

struct Person {
	struct StackNode node;
	char name[64];
	int age;
};

void test(){
	//初始化栈
	LinkStack stack = Init_LinkStack();


	//创建数据
	struct Person p1 = {{NULL}, "aaa", 10};
	struct Person p2 = {{NULL}, "bbb", 20};
	struct Person p3 = {{NULL}, "ccc", 30};
	struct Person p4 = {{NULL}, "ddd", 40};
	struct Person p5 = {{NULL}, "eee", 50};
	struct Person p6 = {{NULL}, "fff", 60};

	//数据入栈
	Push_LinkStack(stack, &p1);
	Push_LinkStack(stack, &p2);
	Push_LinkStack(stack, &p3);
	Push_LinkStack(stack, &p4);
	Push_LinkStack(stack, &p5);
	Push_LinkStack(stack, &p6);


	//输出栈中所有元素
	while(Size_LinkStack(stack) > 0){
		//获得栈顶元素
		struct Person *person = (struct Person *)Top_LinkStack(stack);
		//打印
		printf("Name:%s Age: %d\n", person->name, person->age);
		//弹出栈顶元素
		Pop_LinkStack(stack);

	}
	printf("Size: %d\n", Size_LinkStack(stack));


	//销毁栈
	Destroy_LinkStack(stack);
	stack = NULL;

}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
