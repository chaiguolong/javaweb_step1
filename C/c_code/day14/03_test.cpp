#include <stdio.h>

struct Test{

	int a;

	void setA(int x){
		
		a = x;
	}

	int getA(){
		
		return a;
	}

	//函数的返回值是一个结构体类型的变量
	//行数的参数是一个结构体变量
	Test fun(Test obj){
		printf("fun\n");

		return obj;
	}


};

int main(int argc, char *argv[])
{
	//Test结构体,c++叫做类
	//obj结构体变量,c++中叫做对象
	Test obj;

	//调用完毕setA()函数,a变量不会释放,只有obj生命周期结束了,变量才会结束
	obj.setA(10);
	int tmp = obj.getA();
	printf("tmp %d\n", tmp);

	//obj.a;
	
	Test *p = &obj;
	int m = p ->getA();
	printf("m %d\n", m);


	//int n = (obj.fun(obj)).getA();
	int n = obj.fun(obj).getA();
	printf("n = %d\n", n);

	
	
	return 0;
}
