#include <iostream>
using namespace std;
int digitSum(int n);
int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cout << fixed;
	cout.precision(3);

	int i, j;
	int sum = 0;

	for (i = 1; i < 10000; i++) {
		for (j = i-1; j > 0; j--) {
			if (i == j + digitSum(j)) break;
		}
		if (j == 0) cout << i << endl;
	}

	return 0;
}

int digitSum(int n) {
	if (n <= 0) {
		return 0;
	}

	return n%10 + digitSum(n / 10);
}
