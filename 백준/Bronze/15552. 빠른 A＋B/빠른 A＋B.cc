#include <iostream>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int num;
	int a, b;

	cin >> num;

	for (int i = 0; i < num; i++) {
		cin >> a >> b;
		cout << a + b << '\n';
	}
	return 0;
}