#pragma once
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef __cplusplus
	extern "C"{
#endif

//1.先把所需要的数据信息结构定义下来
struct DynamicArray {
	//输出数据元素的空间首地址
	void **addr;
	//存储数据的内存中最大能够容纳多少元素
	int capacity;
	//当前存储数据的内存中有多少个元素
	int size;
};

//初始化数组
struct DynamicArray *Init_DynamicArray(int capacity);
//插入元素
void Insert_DynamicArray(struct DynamicArray *arr, int pos, void *data);
//遍历
void Foreach_DynamicArray(struct DynamicArray *arr, void(*_callback)(void *));

//按位置删除
void RemoveByPos_DynamicArray(struct DynamicArray *arr, int pos);

//按值删除
void RemoveByValue(struct DynamicArray *arr, void *data, int(*compare)(void*, void*));

//销毁数组
void Destroy_DynamicArray(struct DynamicArray *arr);

#ifdef __cplusplus
}
#endif
