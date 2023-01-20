#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int num1, num2;
	int count = 0;

	cin >> num1;
	num2 = num1;
	if (num1 < 10) {
		num1 = num1 + num1 * 10;
		count++;
	}
	while (1) {
		num1 = (num1 % 10 * 10) + (num1 / 10 + num1 % 10)%10;
		count++;
		if (num1 == num2) break;
	}
	if (num2 == 0) count = 1;

	cout << count;
	return 0;
}
