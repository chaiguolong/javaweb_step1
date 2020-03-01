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
	Student stu[4]; 

	//stu,放置读取文件内容的变量地址
	//sizeof(Student),读取文件内容的块大小
	//4,读取文件内容的块数目,读取文件的大小为:块大小*块数目
	//fp,操作的文件
	//返回值:成功时值为读取文件内容的块数目,不是文件文件总大小
	//返回值:失败时返回0
	int ret = fread(stu, sizeof(Student), 4, fp);

	printf("ret = %d\n", ret);

	int i = 0;
	int n = 4;
	for (i = 0; i < n; ++i) {
		printf("%d, %s, %d\n", stu[i].age, stu[i].name, stu[i].score);
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
