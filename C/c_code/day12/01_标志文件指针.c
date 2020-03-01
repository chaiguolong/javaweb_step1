#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(int argc, char *argv[])
{
	//printf函数的内部实现,往标准输出设备(1)写内容
	printf("before aaaaaaaaaaaa\n");
	//fclose(stdout);
	close(1);	//1代表是标准输出设备,关闭了,1就是空闲的数字

	int fd = open("01.txt", O_WRONLY, 0777);

	//printf函数的内部实现,往(1)写内容,但是1和现在的01.txt关联,printf的内容写到01.txt里面
	printf("fd = %d\n", fd);

	printf("after bbbbbbbbbb\n");
	printf("after cccccccccc\n");
	printf("after dddddddddd\n");

	return 0;
}

int main01(int argc, char *argv[])
{
	printf("aaaaaaaaaaaaaa\n");

	//fclose(stdout);	//关闭标准输出文件指针

	printf("bbbbbbbbbbbbbb\n");

	//打印库函数调用失败原因
	perror("mike");
	
	//fclose(stderr);//
	
	perror("jiang");

	int a = 10;

	fclose(stdin);

	printf("请输入a:");

	scanf("%d", &a);

	printf("a = %d\n", a);


	return 0;
}
