#include <iostream>
using namespace std;

bool countOneNum(int n);

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int n = 0;
	int count = 0;

	cin >> n;

	
	for (int i = 1; i <= n; i++) {
		if (i < 100) count++;
		else {
			if (countOneNum(i) == true) count++;
		}
	}

	cout << count;


	return 0;
}

bool countOneNum(int n) {
	int d = 0;
	if (n / 10 % 10 == ((n / 100) + (n % 10)) / 2.0) return true;
	return false;
}