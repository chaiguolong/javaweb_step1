#include <stdio.h>
#include <string.h>

struct Student{
	int age;
	char name[50];
	int score;
};	//有分号

int main(int argc, char *argv[])
{
	//struct Student a2[5] = {18, "mike", 59,19, "hello", 60,20, "xiaoming", 61,21, "xiaoqiang", 62,22, "jack", 63};



	/* struct Student a1[5] = { */
	/* 	18, "mike", 59, */
	/* 	19, "hello", 60, */
	/* 	20, "xiaoming", 61, */
	/* 	21, "xiaoqiang", 62, */
	/* 	22, "jack", 63 */
	/* }; */

	struct Student a[5] = {
		{18, "mike", 59},
		{19, "hello", 60},
		{20, "xiaoming", 61},
		{21, "xiaoqiang", 62},
		{22, "jack", 63}
	};

	//求平均分
	int i = 0;
	int n = sizeof(a) / sizeof(a[0]);
	int sum = 0;
	double ave = 0L;

	for (i = 0; i < n; ++i) {
		sum += a[i].score;
	}

	ave = sum * 1.0 / n;

	printf("ave = %lf\n", ave);
	
	return 0;
}

int main01(int argc, char *argv[])
{
	struct Student a[5];	//结构体数组

	a[0].age = 18;
	strcpy(a[0].name, "mike");
	a[0].score = 59;

	(a + 1)->age = 19;
	strcpy((a + 1)->name , "hello");
	(a + 1)->score = 60;

	(*(a + 2)).age = 20;
	strcpy((*(a + 2)).name, "jiang");
	(*(a + 2)).score = 61;

	struct Student *p;
	p = &a[0];
	p[3].age = 21;
	strcpy(p[3].name, "xiaoming");
	p[3].score = 62;

	(p + 4)->age = 22;
	strcpy((p + 4)->name, "xiaojiang");
	(p + 4)->score = 88;

	int i = 0;
	int n = sizeof(a) / sizeof(a[0]);
	for (i = 0; i < n; ++i) {
		printf("%d, %s, %d\n", a[i].age, a[i].name, a[i].score);
	}





	
	return 0;
}
