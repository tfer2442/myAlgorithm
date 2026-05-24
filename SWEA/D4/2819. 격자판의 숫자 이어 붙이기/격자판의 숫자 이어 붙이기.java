import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N;
	public static char[][] board;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static HashSet<String> hs;
	
	public static void dfs(int depth, int r, int c, String num) {
		if (depth >= 7) {
			hs.add(num);
			return;
		}
		
		for (int[] dd : d) {
			int nextR = r + dd[0];
			int nextC = c + dd[1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
			
			dfs(depth+1, nextR, nextC, num + board[nextR][nextC]);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 1 ; t <= T; t++) {
			N = 4;
			board = new char[N][N];
			hs = new HashSet<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					board[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(1, i, j, String.valueOf(board[i][j]));
				}
			}
			
			System.out.println("#" + t + " " + hs.size());
		}
	}

}
