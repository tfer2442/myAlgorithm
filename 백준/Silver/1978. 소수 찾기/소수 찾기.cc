#include <iostream>
#include <vector>
using namespace std;

int main(void) {
	int N;
	vector <int>pF;
	int pN = 0;
	
	cin >> N;
	pF.resize(N);
	pN = N;
	for (int i = 0; i < N; i++) {
		cin >> pF[i];
	}

	for (int j = 0; j < N; j++) {
		if (pF[j] == 1) pN--;
		if (pF[j] == 2) continue;
		for (int i = 2; i * i <= pF[j]; i++) {
			if (pF[j] % i == 0) {
				pN--;
				break;
			}
		}
	}

	cout << pN;

	return 0;

}