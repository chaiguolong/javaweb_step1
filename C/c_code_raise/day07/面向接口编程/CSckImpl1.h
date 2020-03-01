#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#ifdef __cplusplus
	extern "C"{
#endif

//初始化
void init_CSckImpl1(void **handle);
//发送接口
void send_CSckImpl1(void *handle, unsigned char * sendData, int sendLen);
//接收接口
void recv_CSckImpl1(void *handle, unsigned char* recvData, int *recvLen);
//关闭
void close_CSckImpl1(void *handle);


#ifdef __cplusplus
}
#endif
