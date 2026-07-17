import java.util.*;
import java.io.*;


public class Solution {
	public static int T;
	public static int[][] board;
	public static boolean[][] visited;
	public static int cnt, answer;
	public static int[][] d = {{0, -1}, {0, 1}, {1, 0}};
	
	public static void dfs(int r, int c) {
		if (r == 99) {
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nextR = r + d[i][0];
			int nextC = c + d[i][1];
			
			if (nextR >= 100 || nextR < 0 || nextC >= 100 || nextC < 0) continue;
			if (visited[nextR][nextC] || board[nextR][nextC] == 0) continue;
			visited[nextR][nextC] = true;
			cnt++;
			
			if (cnt > answer) {
				return;
			}
			
			dfs(nextR, nextC);
			
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			String tmp = br.readLine();
			board = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
				}			
			}
			
			/*
			 * [0][i] 가 1인 경우에 출발점이 될 수 있다.
			 * [99][i]에 도착하면 종료
			 * dfs를 통해서 왼, 오, 아래 순으로 탐색한다
			 * visited 사용
			 */
			
			answer = Integer.MAX_VALUE;
			int answerX = -1;
			
			for (int i = 0; i < 100; i++) {
				visited = new boolean[100][100];
				
				if (board[0][i] == 1) {
					cnt = 1;
					visited[0][i] = true;
					visited[1][i] = true;
					dfs(1, i);

					if (cnt <= answer) {
						answer = cnt;
						answerX = i;
					}
				}
			}
			
			System.out.println("#" + t + " " + answerX);
		}
	}
}
