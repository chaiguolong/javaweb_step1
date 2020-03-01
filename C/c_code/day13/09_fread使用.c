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

	int ret = 0;

	int i = 0;

	while(1){
		ret = fread(&s[i], 1,sizeof(Student), fp);

		printf("ret = %d\n", ret);

		if(ret == 0){	//读取结束
			break;
		}
		i++;
	}

	printf("i = %d\n", i);	//i就是读取元素的个数

	int n = i;
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
