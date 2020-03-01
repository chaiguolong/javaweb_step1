#include <stdio.h>
#include <string.h>

void write_file(){
	//打开文件
	FILE *fp = fopen("1.txt", "w");
	//写文件
	/* fputs("10+10=\n", fp); */
	/* fputs("10-10=\n", fp); */
	/* fputs("10*10=\n", fp); */
	/* fputs("10/10=\n", fp); */
	/* fputs("10+5=\n", fp); */
	/* fputs("10-5=\n", fp); */
	/* fputs("10*5=\n", fp); */
	/* fputs("10/5=", fp); */
	//关闭文件
	fclose(fp);
}

int calc(a, b, ch){
	switch (ch) {
		case '+':
			return a+b;
			
		case '-':
			return a-b;

		case '*':
			return a*b;

		case '/':
			return a/b;

		default:
			return 0;
			
	}

	return 0;
}

void read_file(){
	//打开文件
	FILE *fp = fopen("1.txt", "r");
	//读文件
	char buf[1024];
	char tmp[1024];
	while(1){
		
		memset(buf, 0, sizeof(buf));
		//遇到\n,文件结束符,出错,结束本次读取
		fgets(buf, sizeof(buf), fp);

		if(strlen(buf) > 0){

			int a, b;
			char ch;

			/* printf("buf = %s", buf); */

			sscanf(buf, "%d%c%d=\n" ,&a, &ch, &b);
			sprintf(buf, "%d%c%d=%d\n" ,a, ch, b, calc(a, b, ch));
			strcat(tmp, buf);
		}

		if(feof(fp)){
			break;
		}
	}

	/* printf("%s", tmp); */

	//关闭文件
	fclose(fp);

	//重新打开文件,是为了将文件清0
	
	fp = fopen("1.txt", "w");

	/* fputs("hello",  fp); */
	printf("%s\n", tmp);
	fputs(tmp, fp);

	//关闭文件
	fclose(fp);
}

int main(int argc, char *argv[])
{
	write_file();
	read_file();
	
	return 0;
}
