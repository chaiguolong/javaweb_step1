#include <stdio.h>

typedef struct Student{
	int age;
	char name[50];
	int score;
}Student;

int main(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("7.txt", "r");
	//读文件
	Student a;
	//读取第四个结构体
	fseek(fp, 3*sizeof(Student),SEEK_SET);
	fread(&a,1,sizeof(Student),fp);
	printf("%d, %s, %d\n", a.age, a.name,a.score);

	//光标回到第一位
	fseek(fp, 0, SEEK_SET);
	fread(&a,1,sizeof(Student),fp);
	printf("%d, %s, %d\n", a.age, a.name,a.score);

	//光标移动到末尾
	fseek(fp, 0, SEEK_END);
	long size = ftell(fp);
	printf("size = %ld\n", size);
	
	//关闭文件
	fclose(fp);
	
	return 0;
}
