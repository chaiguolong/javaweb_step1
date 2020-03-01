#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void test01()
{
	char str1[] = {'h', 'e', 'l', 'l', 'o'};
	printf("%s\n", str1);

}

void copyString01(char *dsc, char *source)
{
	int len = strlen(source);
	for (int i = 0; i < len; ++i) {
		dsc[i] = source[i];
	}

	dsc[len] = '\0';
}


void copyString02(char *dsc, char *source)
{
	while(*source != '\0'){
		*dsc = *source;
		++dsc;
		++source;
	}

	*dsc = '\0';
}

void copyString03(char *dsc, char *source){
	while(*dsc++ = *source++);
}

//字符串拷贝
void test02()
{
	char *source = "hello world!";
	//char buf[1024];
	char buf[1024] = {0};

	//copyString01(buf, source);
	//copyString02(buf, source);
	copyString03(buf, source);
	printf("%s\n", buf);

}

void reverseString(char *str)
{
	if(NULL == str){
		return;
	}

	int len = strlen(str);

#if 0
	int start = 0;
	int end = len -1;

	while(start < end){
		char temp = str[start];
		str[start] = str[end];
		str[end] = temp;
		++start;
		--end;
	}
	
#else

	char  *pStart = str;
	char  *pEnd = str + len -1;

	while(*pStart < *pEnd){
		char temp = *pStart;
		*pStart = *pEnd;
		*pEnd = temp;
		++pStart;
		--pEnd;
	}

#endif
}

//字符串反转
void test03()
{
	char p[] = "abc";
	reverseString(p);
	printf("p = %s\n", p);

}

int main(int argc, char *argv[])
{
	test03();
	
	return 0;
}
