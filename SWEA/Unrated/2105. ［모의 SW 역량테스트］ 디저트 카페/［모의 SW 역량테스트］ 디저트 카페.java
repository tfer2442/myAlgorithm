import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int T, N;
	public static int[][] board;
	public static boolean[] visited;
	public static int[][] d = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
	public static int a;
	public static int b;
	public static int answer;

	public static void dfs(int row, int col, int dir, int cnt) {
		
		if (row == a && col == b && cnt >= 4) { // 다시 되돌아 왔을 때 & 한바퀴 빙 도는 것의 최소값이 4
			answer = Math.max(answer, cnt);
			return;
		}
		
		for (int i = dir; i < 4; i++) { // 넘겨 받은 탐색 방향 순서대로 탐색
			if (cnt == 0 && i >= 1) return; // 대각선 오른쪽 위로 탐색하지 못한다면 실행 안함
			int nextRow = row + d[i][0];
			int nextCol = col + d[i][1];
			if (0 > nextRow || nextRow >= N || 0 > nextCol || nextCol >= N || visited[board[nextRow][nextCol]]) continue; // 범위 초과 처리
			if (i == 2 && nextRow-a > nextCol-b) continue; // 대각선 왼쪽 아래로 더 내려갈 필요 없을 때 실행 안함
			
			visited[board[nextRow][nextCol]] = true;
			dfs(nextRow, nextCol, i, cnt+1); // 현재 탐색하는 방향을 그대로 넘겨줌
			visited[board[nextRow][nextCol]] = false;

		}		
 	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			answer = -1;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 0; j < N-2; j++) {
					visited = new boolean[101];
					a = i;
					b = j;
					dfs(i, j, 0, 0);
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
