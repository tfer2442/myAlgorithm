#include <iostream>
#include <string>
#define MAX_STACK_SIZE 101
using namespace std;

char stack[MAX_STACK_SIZE];
int top = -1;

void push(char item);
char pop();
int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	char str1[101] = "\0";
	int str2[101] = { 0 };
	int i = 0;
	int j = 0;

	while (1) {
		cin.getline(str1, MAX_STACK_SIZE);
		if (str1[0] == '.') break;

		for (i = 0; str1[i] != '.'; i++) {
			if (str1[i] == '(' || str1[i] == '[') push(str1[i]);
			else if (str1[i] == ')') {
				if (top == -1) {
					cout << "no\n";
					break;
				}
				else if (pop() != '(') {
					//str2[j++] = 0;
					cout << "no\n";
					break;
				}
			}
			else if (str1[i] == ']') {
				if (top == -1) {
					cout << "no\n";
					break;
				}
				else if (pop() != '[') {
					//str2[j++] = 0;
					cout << "no\n";
					break;
				}
			}
		}

		if (top == -1 && str1[i] == '.') {
			//str2[j++] = 1;
			cout << "yes\n";
		}
		else if (str1[i] == '.' && top != -1){
			cout << "no\n";
		}
		top = -1;
	}

	//for (int i = 0; i < j; i++) {
	//	if (str2[i] == 0) {
	//		cout << "no";
	//	}
	//	else if (str2[i] == 1) {
	//		cout << "yes";
	//	}
	//}
	return 0;
}

void push(char item){
	if (top >= MAX_STACK_SIZE) {
		exit(-1);
	}
	stack[++top] = item;
}

char pop() {
	if (top < 0) {
		exit(-1);
	}
	return stack[top--];
}