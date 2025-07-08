import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int[][] board;
	public static boolean[][] visited;
	public static int[][] d = {{-1 ,0}, {0, -1}, {0, 1}, {1, 0}};
	public static int pCount;
	public static int pMax;
	public static int curSize;
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int[] dd : d) {
			int nextR = r + dd[0];
			int nextC = c + dd[1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
			if (visited[nextR][nextC]) continue;
			if (board[nextR][nextC] == 1) {
				dfs(nextR, nextC);
				curSize++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					curSize = 1;
					pCount++;
					dfs(i, j);	
					pMax = Math.max(pMax, curSize);
				}
			}
		}
		
		System.out.println(pCount);
		System.out.println(pMax);
	}

}
