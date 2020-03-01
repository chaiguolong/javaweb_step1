#include <stdio.h>

typedef struct Student {
	int age;
	char name[50];
	int score;
}Student;

int main(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = fopen("7.txt", "r");
	//2.写文件
	Student s[10]; 

	//1.如果文件内容大小 > 用户指定的读取大小,返回值为用户指定的块数目
	//文件的大小为:数目*块的大小
	//int ret = fread(s, sizeof(Student), 2, fp);

	//1.如果文件内容大小 < 用户指定的读取大小,返回值为实际读取的块数目
	//实际读取的块数目 < 用户指定的读取大小,也可能为0
	//int ret = fread(s, sizeof(Student), 10, fp);

	//用户指定要10 * sizeof(s)的大小,文件只有0.4个sizeof(s),返回值为0
	//int ret = fread(s, sizeof(s), 10, fp);

	//如果把块大小指定为1,返回值就是读取文件的总大小
	int ret = fread(s, 1, sizeof(Student)*10, fp);


	printf("ret = %d\n", ret);

	int i = 0;
	int n = 4;
	for (i = 0; i < n; ++i) {
		printf("%d, %s, %d\n", s[i].age, s[i].name, s[i].score);
	}



	//3.关闭文件
	fclose(fp);
	
	return 0;
}

int main02(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = fopen("7.txt", "w");
	//2.写文件
	Student stu[4] = {
		{18, "mike", 59},
		{20, "john", 98},
		{23, "lucy", 79},
		{30, "Lily", 69}
	};
	//stu,需要往文件写内容的变量首地址
	//sizeof(Student),往文件写入内容的块大小
	//4,往文件写入内容的块数目
	//fp,操作的文件写入内容的块数目,失败时为0
	//返回值,成功时,
	int ret = fwrite(stu, sizeof(Student), 4, fp);
	printf("ret = %d\n", ret);

	//3.关闭文件
	fclose(fp);
	
	return 0;
}


int main01(int argc, char *argv[])
{
	//1.打开文件
	FILE *fp = fopen("7.txt", "w");
	//2.写文件
	Student stu = {18, "mike", 59};
	//int ret = fwrite(&stu, sizeof(Student), 1, fp);
	//int ret = fwrite(&stu, 1, sizeof(Student), fp);
	//&stu,需要往文件写内容的变量首地址
	//15,往文件写入内容的块大小
	//4,往文件写入内容的块数目
	//fp,操作的文件写入内容的块数目,失败时为0
	//返回值,成功时,
	int ret = fwrite(&stu, 15, 4, fp);
	printf("ret = %d\n", ret);

	//3.关闭文件
	fclose(fp);
	
	return 0;
}
