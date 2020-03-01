#include <stdio.h>

int main(int argc, char *argv[])
{
	
	char buf[1024];

	while(1){
		fgets(buf, sizeof(buf), stdin);
		printf("$%s$\n", buf);
	}

	return 0;
}
