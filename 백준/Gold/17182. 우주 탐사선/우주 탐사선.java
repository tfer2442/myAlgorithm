import java.util.*;
import java.io.*;


public class Main {
	public static int N, K, answer;
	public static int[][] board;
	public static boolean[] visited;
	
	public static void dfs(int depth, int cur, int sum) {
		if (answer <= sum) {
			return;
		}
		if (depth == N) {
			answer = sum;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i == cur) continue;
			if (visited[i]) continue;
			visited[i] = true;
			dfs(depth+1, i, sum+board[cur][i]);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0 ; j < N; j++) {
					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
				}
			}
		}
		
		visited = new boolean[N];
		visited[K] = true;
		answer = Integer.MAX_VALUE;
		dfs(1, K, 0);
		System.out.println(answer);
	}

}
