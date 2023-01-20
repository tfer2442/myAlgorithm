#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	int N;
	int tmp;
	int min = 1000000, max = 2;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> tmp;
		if (tmp < min) min = tmp;
		if (tmp > max) max = tmp;
	}

	N = max * min;
	cout << N;
	return 0; 
}