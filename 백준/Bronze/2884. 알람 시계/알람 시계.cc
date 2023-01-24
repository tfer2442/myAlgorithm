#include <iostream>
using namespace std;

int main(void) {
	int num1, num2;
	
	cin >> num1 >> num2;

	if (num2 >= 45) {
		num2 -= 45;
	}
	else {
		if (num1 < 1) {
			num1 = 23;
		}
		else {
			num1 -= 1;
		}
		num2 = num2 + 15;
	}
	cout << num1 << " " << num2;
	return 0;
}