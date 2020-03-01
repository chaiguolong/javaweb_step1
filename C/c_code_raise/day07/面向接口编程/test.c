#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "CSckImpl1.h"


//初始化
typedef void(*init_CSocketProtocol)(void **handle);
//发送接口
typedef void(*send_CSocketProtocol)(void *handle, unsigned char * sendData, int sendLen);
//接收接口
typedef void(*recv_CSocketProtocol)(void *handle, unsigned char* recvData, int *recvLen);
//关闭
typedef void(*close_CSocketProtocol)(void *handle);

//业务代码
void FrameWork(init_CSocketProtocol init,
		send_CSocketProtocol send,
		recv_CSocketProtocol recv,
		close_CSocketProtocol close)
{
	//初始化连接
	void *handle = NULL;
	init(&handle);

	//发送数据
	char buf[] = "Hello world!";
	int len = strlen(buf);
	send(handle, buf, len);

	//接收数据
	char recvBuf[1024] = {0};
	int recvLen = 0;
	recv(handle, recvBuf, &recvLen);
	printf("接收到的数据: %s\n", recvBuf);
	printf("接收到的数据长度: %d\n", recvLen);

	//关闭链接
	close(handle);
	handle = NULL;


}

void test()
{
	FrameWork(init_CSckImpl1, send_CSckImpl1, recv_CSckImpl1, close_CSckImpl1);
}

int main(int argc, char *argv[])
{
	test();
	
	return 0;
}
