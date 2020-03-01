#include <stdio.h>

int main(int argc, char *argv[])
{

	printf("%s, %s, %s\n", argv[0], argv[1], argv[2]);


	if(argc != 3){
		printf("error: ./aout src dst \n");
		return 0;
	}

	//打开源文件
	FILE *sfp = fopen(argv[1], "r");
	//打开目的文件
	FILE *dfp = fopen(argv[2], "w");
	
	//循环复制拷贝
	//从源文件读取内容,再把内容写入到目的文件,读多少写多少
	char buf[4*1024];

	int len = 0;

	int i = 0;
	
	while(1){

		len = fread(buf, 1, sizeof(buf), sfp);

		if(len == 0){
			break;
		}

		fwrite(buf, 1, len, dfp);

		i++;
	}
	
	//关闭源文件
	fclose(sfp);
	//关闭目的文件
	fclose(dfp);
	
	return 0;
}
