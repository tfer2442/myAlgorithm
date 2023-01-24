//트리의 갯수를 구하는 문제
//싸이클이 형성된 집합을 제외한 집합의 갯수를 세면 된다.
//입력 받은대로 다 연결 시킨 후에 n번째까지 반복문을 돌려서
//각자의 부모가 무엇인지 0으로 초기화 한 다른 배열에 저장 하고, 
//사이클을 만들지 않는 부모를 제외한 배열에 0이 아닌 인덱스의 갯수를 구하면 됨


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int parent[501];

int find_parent(int);
bool is_union_user(int, int);
void merge_parent(int, int);
void init_parent(int);

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n, m, x, y;
	int ver1, ver2;
	int parent_count[501] = { 0 };
	int tree_num = 0;
	int case_num = 0;
	while (true) {
		cin >> n >> m;
		if (n == 0 && m == 0) break;
		case_num++;

		if (m == 0) {
			if (n == 1) cout << "Case " << case_num << ": There is one tree.\n";
			else cout << "Case " << case_num << ": A forest of " << n << " trees.\n";

			continue;
		}

		vector<int> v1;
		init_parent(n);
		tree_num = 0;
		for (int i = 1; i <= n; i++) parent_count[i] = 0; // 초기화

		for (int i = 1; i <= m; i++) {
			cin >> ver1 >> ver2;
			if (is_union_user(ver1, ver2)) v1.push_back(find_parent(ver1)); // 사이클이 되는 부모 저장
			merge_parent(ver1, ver2);
		} // 입력받은 vertex 합치기

		int cycle_size = v1.size();
		for (int i = 0; i < cycle_size; i++) {
			v1.push_back(find_parent(v1[i]));
		}

		sort(v1.begin(), v1.end()); 
		unique(v1.begin(), v1.end());

		for (int i = 1; i <= n; i++) {
			int j = find_parent(i);
			parent_count[j] += 1;
		} // 공통 부모의 갯수 세기

		for (int i = 0; i < v1.size(); i++) {
			parent_count[v1[i]] = 0;
		} // 사이클 있는 부모는 그래프 아니므로 0으로 만들어주기

		for (int i = 1; i <= n; i++) {
			if (parent_count[i] != 0) {
				tree_num += 1;
			}
		} // 트리의 갯수 세기

		if (tree_num == 0) cout << "Case " << case_num << ": No trees.\n";
		else if (tree_num == 1) cout << "Case " << case_num << ": There is one tree.\n";
		else cout << "Case " << case_num << ": A forest of " << tree_num << " trees.\n";
	}

	return 0;
}

void init_parent(int n) {
	for (int i = 0; i <= n; i++) {
		parent[i] = i;
	}
}

int find_parent(int x) {
	if (x == parent[x]) return x;
	parent[x] = find_parent(parent[x]);

	return parent[x];
}

bool is_union_user(int x, int y) {
	x = find_parent(x);
	y = find_parent(y);

	if (x == y) return true;
	else return false;
}
void merge_parent(int x, int y) {
	x = find_parent(x);
	y = find_parent(y);

	if (y > x) parent[y] = x;
	else parent[x] = y;
}