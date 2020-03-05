#include "SeqStack.h"

int IsLeft(char ch){
	return ch == '(';
}

int IsRight(char ch){
	return ch == ')';
}

void printError(const char *str, char *errMsg, char *pos){
	printf("错误信息: %s\n", errMsg);
	printf("%s\n", str);
	int dis = pos -str;
	for (int i = 0; i < dis; ++i) {
		printf(" ");
	}
	printf("A\n");
}

void test(){
	const char *str = "5+5*(6)+9/3*1)-(1+3(";
	char *p = (char *)str;

	//初始化栈
	SeqStack stack = Init_SeqStack();

	while(*p != '\0'){
		//判断当前字符是否是左括号
		if(IsLeft(*p)){
			Push_SeqStack(stack, p);
		}

		//判断当前字符是否是右括号
		if(IsRight(*p)){
			if(Size_SeqStack(stack) > 0){

				//弹出栈顶元素
				Pop_SeqStack(stack);
			}else{
				printError(str,"右括号没有匹配的左括号!",p);
			}
		}

		p++;
	}

	while(Size_SeqStack(stack) > 0){
		printError(str,"没有匹配的右括号!",Top_SeqStack(stack));
		//弹出栈顶元素
		Pop_SeqStack(stack);
	}

	//销毁栈
	Destroy_SeqStack(stack);
	stack = NULL;
}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
