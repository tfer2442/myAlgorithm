#include <iostream>
#include <cstring>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	char croatia[8][4] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
	char text[101] = "\0";
	int count = 0;

	cin >> text;

	for (int i = 0; i < strlen(text); i++) {
		if (text[i] == 'c') {
			if (text[i + 1] == '=' || text[i + 1] == '-') i++;
			count++;
		}
		else if (text[i] == 'd') {
			if (text[i + 1] == 'z' && text[i + 2] == '=') i = i + 2;
			else if (text[i + 1] == '-') i++;
			count++;
		}
		else if (text[i] == 'l') {
			if (text[i + 1] == 'j') i++;
			count++;
		}
		else if (text[i] == 'n') {
			if (text[i + 1] == 'j') i++;
			count++;
		}
		else if (text[i] == 's') {
			if (text[i + 1] == '=') i++;
			count++;
		}
		else if (text[i] == 'z') {
			if (text[i + 1] == '=') i++;
			count++;
		}
		else count++;
	}
	cout << count;
	return 0;
}