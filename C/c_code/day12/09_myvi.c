#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	//打开文件

	FILE *fp = fopen(argv[1], "w");

	//从键盘读取内容fgets(),放在字符数组
	//字符数组内容,一个一个字符往文件写
	char buf[1024];

	while(1){
		//默认遇到换行符,此处结束读取,换行符都放在buf
		//fgets()按行读取
		fgets(buf, sizeof(buf), stdin);
		//如果输入内容为:wq,结束,保存内容
		if(strncmp(buf, ":wq", 3) == 0){
			break;
		}

		int i = 0;

		while(buf[i] != '\0'){	//读取的内容没有到结束符,读取到的内容写入文件
			fputc(buf[i], fp);
			i++;
		}


	}
	
	//关闭文件
	fclose(fp);
	
	return 0;
}
