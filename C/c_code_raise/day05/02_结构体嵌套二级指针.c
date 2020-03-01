#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct Teacher {
	char *name;
	char **students;
};

int allocationSpace(struct Teacher ***temp)
{
	if(NULL == temp){

		//错误码,不同错误码表示不同错误
		return -1;
	}

	struct Teacher **ts = malloc(sizeof(struct Teacher *)  * 3 );

	for ( int i = 0; i < 3; ++i) {

		//给老师结构体指针分配空间
		ts[i] = malloc(sizeof(struct Teacher));
		ts[i]->name = malloc(sizeof(char) *64);
		sprintf(ts[i]->name, "Teacher_%d", i + 1);
		ts[i]->students = malloc(sizeof(char *) * 4 );
		for (int j = 0; j < 4; ++j) {
			ts[i]->students[j] = malloc(sizeof(char) * 64 );
			sprintf(ts[i]->students[j], "%s_Stu_%d", ts[i]->name, j + 1);
		}
	}

	*temp = ts;

	return 0;
	
}

void printStructTeacher(struct Teacher **temp){

	if(NULL == temp){
		return ;
	}

	for (int i = 0; i < 3; ++i) {
		printf("%s\n", temp[i]->name);

		for (int j = 0; j < 4; ++j) {
			printf("	%s\n", temp[i]->students[j]);
			
		}
	}
}

void freeSpace(struct Teacher **temp)
{
	if(NULL == temp){
		return;
	}

	for (int i = 0; i < 3; ++i) {
		if(temp[i] == NULL){
			continue;
		}

		if(temp[i]->name != NULL){
			free(temp[i]->name);
			temp[i]->name = NULL;
		}

		for (int j = 0; j < 4; ++j) {
			if(temp[i]->students[j] != NULL){
				free(temp[i]->students[j]);
				temp[i]->students[j] = NULL;
			}
		}

		free(temp[i]->students);
		temp[i]->students = NULL;

		if(temp[i] != NULL){
			free(temp[i]);
			temp[i] = NULL;
		}


	}

	free(temp);
	temp = NULL;
}



int main(int argc, char *argv[])
{
	struct Teacher **teacher = NULL;

	allocationSpace(&teacher);
	printStructTeacher(teacher);
	freeSpace(teacher);
	
	return 0;
}
