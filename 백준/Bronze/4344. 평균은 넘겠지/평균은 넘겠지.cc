#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int num = 0;
	int arr[1000] = { 0 };
	float sum = 0;
	float avg = 0;
	float count = 0;
	float percent = 0;

	cin >> num;
	cout << fixed;
	cout.precision(3);

	for (int i = 0; i < num; i++) {
		cin >> arr[0];
		for (int j = 1; j <= arr[0]; j++) {
			cin >> arr[j];
			sum += arr[j];
		}
		avg = sum / arr[0];
		for (int j = 1; j <= arr[0]; j++) {
			if (avg < arr[j]) count++;
		}
		percent = count / arr[0] * 100;
		count = 0;
		sum = 0;
		cout << percent << "%\n";
	}
	
	return 0;
} 