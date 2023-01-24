#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int>> v1;


int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n = 0;
	int buf1, buf2;
	cin >> n;
	vector<int> v2(n, 1);


	for (int i = 0; i < n; i++) { // 전봇대 연결 위치 번호 한 쌍으로 입력 받기
		cin >> buf1 >> buf2;
		v1.push_back({ buf1, buf2 });
	} 

	sort(v1.begin(), v1.end()); // A전봇대 기준으로 정렬

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (v1[i].second > v1[j].second) {
				v2[i] = max(v2[i], v2[j] + 1);
			}
		}
	}

	cout << n - *max_element(v2.begin(), v2.end());
	return 0;
}