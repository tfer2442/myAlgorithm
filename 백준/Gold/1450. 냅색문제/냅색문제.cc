#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector <long long>  v;

void dfs1(int start, int end, vector <long long>&, long long);
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL), cout.tie(NULL);

	int N, C; 
	long long buf1;
	int buf2;

	vector <long long> left;
	vector <long long> right;

	cin >> N >> C;

	for (int i = 0; i < N; i++) {
		cin >> buf2;
		v.push_back(buf2);
	}

	dfs1(0, N / 2 - 1, left, 0);
	dfs1(N / 2, N - 1, right, 0);
	sort(right.begin(), right.end());
	int cnt = 0;
	for (int i = 0; i < left.size(); i++) {
		buf1 = C - left[i];
		cnt += upper_bound(right.begin(), right.end(), buf1) - right.begin();
	}
	cout << cnt;
}

void dfs1(int start, int end, vector <long long>& part, long long sum) {
	if (start > end) {
		part.push_back(sum);
		return;
	}
	else {
		dfs1(start + 1, end, part, sum);
		dfs1(start + 1, end, part, sum + v[start]);
	}
}