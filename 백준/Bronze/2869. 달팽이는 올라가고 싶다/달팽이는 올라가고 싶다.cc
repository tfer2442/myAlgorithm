#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int A, B, V;
	int m;
	int days;

	cin >> A >> B >> V;
	V = V - A;
	m = A - B;

	if (V % m == 0) {
		days = V / m + 1;
	}
	else {
		days = V / m + 2;
	}
	cout << days;

	return 0;
}