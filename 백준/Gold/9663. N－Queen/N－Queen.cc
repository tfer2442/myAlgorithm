#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
vector<pair<int, int>> v1;
int visited[15][15];

int N;
int cnt;

void btk(int, int, int);
//void visited_func(int, int);
//void init_visited();
int visited_func(int, int);

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N;

	btk(1, 1, 0);
	cout << cnt;

	return 0;
}

void btk(int a, int b, int cur_cnt) {
	if (cur_cnt >= N) {
		cnt++;
		return;
	}

	//for (int i = a; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if(!visited_func(a, j)){
				v1.push_back({ a, j });
				//visited_func(a, j);
				btk(a+1, j, cur_cnt+1);
				v1.pop_back();
				//init_visited();
			}
		}
	//}
}

//void visited_func(int a, int b) {
//	for (int i = 1; i <= N; i++) {
//		visited[a][i] = true;
//		visited[i][b] = true;
//	}
//
//	for (int i = a, j = b; i >= 1 && j >= 1; i--, j--) visited[i][j] = true;
//	for (int i = a, j = b; i <= N && j <= N; i++, j++) visited[i][j] = true;
//	for (int i = a, j = b; i >= 1 && j <= N; i--, j++) visited[i][j] = true;
//	for (int i = a, j = b; i <= N && j >= 1; i++, j--) visited[i][j] = true;
//}
//
//void init_visited() {
//	for (int i = 1; i <= N; i++) {
//		for (int j = 1; j <= N; j++) {
//			visited[i][j] = false;
//		}
//	}
//
//	for (int i = 0; i < v1.size(); i++) {
//		visited_func(v1[i].first, v1[i].second);
//	}
//}

int visited_func(int a, int b) {
	for (int i = 0; i < v1.size(); i++) {
		if ((a - b == v1[i].first - v1[i].second) || (a + b == v1[i].first + v1[i].second) || a == v1[i].first || b == v1[i].second) return 1;
	}

	return 0;
}