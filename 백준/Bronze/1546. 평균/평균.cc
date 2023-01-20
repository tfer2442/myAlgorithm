#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int num;
	float score[1000] = { 0 };
	float max = 0;
	float sum = 0;
	cin >> num;
	cin >> score[0];
	
	max = score[0];
	for (int i = 1; i < num; i++) {
		cin >> score[i];

		if (score[i] > max) {
			max = score[i];
		}
	}

	for (int i = 0; i < num; i++) {
		score[i] = (score[i] / max) * 100;
		sum += score[i];
	}

	cout << sum / (float)num;

	return 0;
}