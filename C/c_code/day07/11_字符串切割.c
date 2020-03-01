#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char buf[] = "abc,mike,jiang,250,hello,world";

	char tmp[100];	//把buf中的内容拷贝到tmp数组中

	strcpy(tmp,buf);

	char *p;

	//第一次调用
	p = strtok(tmp,",");

	while(p != NULL){//说明切割成功

		printf("p = %s\n", p);

		//第二次调用
		p = strtok(NULL,",");

	}


	return 0;
}

int main02(int argc, char *argv[])
{
	char buf[] = "abc,mike,jiang,250";

	char tmp[100];	//把buf中的内容拷贝到tmp数组中

	strcpy(tmp,buf);

	printf("before: buf[3] = %d\n", buf[3]);

	//第一次调用
	//第一个参数写原字符串,第二个参数写分割字符串
	//返回值就是切割后的字符串
	//在匹配切割字符串的地方,换成结束符
	//使用strtok会破坏原字符串结构
	char *p = strtok(buf,",");
	printf("p = %s\n", p);

	//第二次起,第一个参数需要写NULL
	p = strtok(NULL,",");
	printf("p2 = %s\n", p);

	return 0;
}

int main01(int argc, char *argv[])
{
	char buf[] = "abc,mike,jiang,250";

	char tmp[100];	//把buf中的内容拷贝到tmp数组中

	strcpy(tmp,buf);

	printf("before: buf[3] = %d\n", buf[3]);

	//第一次调用
	//第一个参数写原字符串,第二个参数写分割字符串
	//返回值就是切割后的字符串
	//在匹配切割字符串的地方,换成结束符
	//使用strtok会破坏原字符串结构
	char *p = strtok(buf,",");

	printf("p = %s\n", p);

	printf("buf = %s\n", buf);

	printf("buf[3] = %d\n", buf[3]);


	
	return 0;
}
