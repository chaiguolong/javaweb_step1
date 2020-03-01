#include <stdio.h>

int main(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("11.txt", "w");
	//写文件

	//char *p1 = "hello\n";
	//fputs(p1, fp);
	//
	//char *p2 = "mike\n";
	//fputs(p2, fp);
	//
	//char *p3 = "abc\n";
	//fputs(p3, fp);
	
	//指针数组,它是数组,每个元素都是指针
	char *p[] = {"hello\n", "mike\n", "abc\n"};
	int i = 0;
	int n1 = sizeof(p);
	int n2 = sizeof(p[0]);

	printf("n1 = %d\n", n1);
	printf("n2 = %d\n", n2);

	int n = n1 / n2;
	for (i = 0; i < n; ++i) {
		fputs(p[i], fp);
	}

	
	

	//关闭文件
	fclose(fp);
	
	return 0;
}
