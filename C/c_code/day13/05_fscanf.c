#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("4.txt", "r");
	//读文件

	int i = 0;
	//int num = 0;
	char buf[100];

	while(1){

		//fscanf(fp, "%d\n", &num);
		//printf("%d\n", num);
		memset(buf, 0, sizeof(buf));
		fgets(buf, sizeof(buf), fp);
		printf("buf = %d\n", buf[0]);

		
		if(feof(fp)){
			break;
		}

		i++;
	}

	//关闭文件
	fclose(fp);
	
	return 0;
}

int main01(int argc, char *argv[])
{
	//打开文件
	FILE *fp = fopen("4.txt", "r");
	//读文件
	int num = 0;
	fscanf(fp, "%d\n", &num);
	printf("%d\n", num);
	
	fscanf(fp, "%d\n", &num);
	printf("%d\n", num);

	fscanf(fp, "%d\n", &num);
	printf("%d\n", num);

	fscanf(fp, "%d\n", &num);
	printf("%d\n", num);

	//关闭文件
	fclose(fp);
	
	return 0;
}
