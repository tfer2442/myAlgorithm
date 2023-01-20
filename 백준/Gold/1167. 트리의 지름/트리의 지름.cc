/*진지하게 3일동안 혼자 하루종일 생각했는데, 안 풀려서 속상했음.
V가 최대 10만이라서 모든 노드를 돌리면 N^2으로 시간초과 나옴.
!!어떤 노드에서 최대 거리의 노드를 찾고 그 노드에서 최대거리의 노드를 찾으면 된다!!
.*/

#include <iostream>
#include <algorithm>
#include <vector>
#define MAX_NUM 100001
using namespace std;

int visited[MAX_NUM];
vector<pair<int, int>> arr[MAX_NUM];

void dfs(int node, int r);
void visited_init(int);

int res = 0;
int longNode = 0;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int V;
	int a, b, dist;
	
	cin >> V;

	for (int i = 1; i <= V; i++) {
		cin >> a;
		while (1) {
			cin >> b;
			if (b == -1)break;
			cin >> dist;
			arr[a].push_back({b, dist});
		}
	}

	visited_init(V);
	dfs(1, 0);
	res = 0;
	visited_init(V);
	dfs(longNode, 0);
	
	cout << res;

	return 0;
}

void dfs(int node, int r) {
	if (visited[node] == true) return; // 종료조건
	int nextV;
	int nextR;

	if (res < r) {
		res = r;
		longNode = node;
	}
	visited[node] = true; // node 방문

	for (int i = 0; i < arr[node].size(); i++)
	{
		nextV = arr[node][i].first;
		nextR = arr[node][i].second + r;
		dfs(nextV, nextR);
	}
}

void visited_init(int V) {
	for (int i = 1; i <= V; i++) {
		visited[i] = false;
	}
}
