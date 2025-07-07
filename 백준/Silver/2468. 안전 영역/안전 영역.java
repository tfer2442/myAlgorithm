import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int answer;
	public static int[][] board;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void dfs(boolean[][] visited, int r, int c, int h) {
		visited[r][c] = true;
		
		for (int[] dd : d) {
			int nextR = r + dd[0];
			int nextC = c + dd[1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
			if (visited[nextR][nextC]) continue;
			if (board[nextR][nextC] <= h) continue;
			
			dfs(visited, nextR, nextC, h);
		}
	}
	
	public static void calculate(int h) {
		boolean[][] visited = new boolean[N][N];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] > h) {
					dfs(visited, i, j, h);
					result++;
				}
			}
		}
		answer = Math.max(answer, result);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 100; i++) {
			calculate(i);
		}
		
		System.out.println(answer);
	}
} 
