#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#ifdef __cplusplus
	extern "C"{
#endif

//初始化
void init_CSocketProtocol(void **handle);
//发送接口
void send_CSocketProtocol(void *handle, unsigned char * sendData, int sendLen);
//接收接口
void recv_CSocketProtocol(void *handle, unsigned char* recvData, int *recvLen);
//关闭
void close_CSocketProtocol(void *handle);


#ifdef __cplusplus
}
#endif
