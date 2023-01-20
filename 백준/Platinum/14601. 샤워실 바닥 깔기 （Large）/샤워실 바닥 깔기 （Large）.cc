#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int** arr;
int n;
int x, y;
int cnt = 1;

void init_arr(int, int, int);
void print_arr();
void divide_matrix(int, int, int);
void fill_matrix(int, int, int);

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	cin >> x >> y;
	n = pow(2, n);
	init_arr(n, x, y);

	divide_matrix(n, 1, 1);
	print_arr();

	return 0;
}
void divide_matrix(int n, int sX, int sY) {
	if (n == 2) {
		for (int i = sY; i < sY + n; i++) {
			for (int j = sX; j < sX + n; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = cnt;
				}
			}
		}
		cnt++;
		return;
	}
	else {
		fill_matrix(n, sX, sY);
	}

	divide_matrix(n / 2, sX, sY);
	divide_matrix(n / 2, sX + n / 2, sY);
	divide_matrix(n / 2, sX, sY + n / 2);
	divide_matrix(n / 2, sX + n / 2, sY + n / 2);
}

void fill_matrix(int k, int sX, int sY) {
	int i, j;
	int a, b;
	for (i = sY; i < sY + k; i++) {
		for (j = sX; j < sX + k; j++) {
			if (arr[i][j] != 0) {
				a = i;
				b = j;
			}
		}
	}

	i = a;
	j = b;

	if (i < sY + k / 2 && j < sX + k / 2) {
		arr[k / 2 + sY - 1][k / 2 + sX] = cnt; // 2사
		arr[k / 2 + sY][k / 2 + sX - 1] = cnt; // 3사
		arr[k / 2 + sY][k / 2 + sX] = cnt; // 4사
	}
	else if (i < sY + k / 2 && j >= sX + k / 2) {
		arr[k / 2 + sY - 1][k / 2 + sX - 1] = cnt; // 1사
		arr[k / 2 + sY][k / 2 + sX - 1] = cnt; // 3사
		arr[k / 2 + sY][k / 2 + sX] = cnt; // 4사
	}
	else if (i >= sY + k / 2 && j < sX + k / 2) {
		arr[k / 2 + sY - 1][k / 2 + sX - 1] = cnt; // 1사
		arr[k / 2 + sY - 1][k / 2 + sX] = cnt; // 2사
		arr[k / 2 + sY][k / 2 + sX] = cnt; // 4사
	}
	else if (i >= sY + k / 2 && j >= sX + k / 2) {
		arr[k / 2 + sY - 1][k / 2 + sX - 1] = cnt; // 1사
		arr[k / 2 + sY][k / 2 + sX - 1] = cnt; // 3사
		arr[k / 2 + sY - 1][k / 2 + sX] = cnt; // 2사
	}

	cnt++;
}


void init_arr(int n, int x, int y) {
	arr = new int* [n+1];

	for (int i = 0; i < n + 1; i++) {
		arr[i] = new int[n+1];
	}

	for (int i = 0; i < n+1; i++) {
		for (int j = 0; j < n+1; j++) {
			arr[i][j] = 0;
		}
	}

	arr[n-y+1][x] = -1;
}

void print_arr() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			//cout.width(3);
			//cout << std::right << arr[i][j] << ' ';
			cout << arr[i][j] << ' ';
		}

		cout << '\n';
	}
}
