import java.util.*;
import java.io.*;


public class Solution {
	public static int T, N;
	public static int[][] board;
	public static int answer, depth;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void dfs(int r, int c) {
		depth++;
		
		for (int[] dd : d) {
			int nextR = r + dd[0];
			int nextC = c + dd[1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
			if (board[r][c] == board[nextR][nextC]-1) {
				dfs(nextR, nextC);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());			
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 1;
			int start = board[0][0];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					depth = 0;
					dfs(i, j);
					
					if (depth > answer) {
						answer = depth;
						start = board[i][j];
					} else if (depth == answer) {
						if (start > board[i][j]) {
							start = board[i][j];
						}
					}
				}
			}
						
			System.out.println("#" + t + " " + start + " " + answer);
		}
	}

}
