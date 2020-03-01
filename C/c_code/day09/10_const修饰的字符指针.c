#include <stdio.h>

int main(int argc, char *argv[])
{
	char buf[] = "hello";

	char *p = buf;

	*p = 'a';

	printf("buf = %s\n", buf);

	const char *p2 = buf;

	//*p2 = 'a';	//err

	p = NULL;	//ok
	
	return 0;
}
