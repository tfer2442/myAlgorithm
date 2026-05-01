import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N;
	public static int[][] d = {{0, -1}, {0, 1}, {1, 0}};
	public static int[][] board;
	public static boolean[][] visited;
	
	public static void solution(int t) {
		for (int x = 0; x < N; x++) {
			if (board[0][x] == 0) continue;
			
			// r, c
			ArrayDeque<int[]> dq = new ArrayDeque<>();
			
			visited = new boolean[N][N];
			
			visited[0][x] = true;
			visited[1][x] = true;
			dq.add(new int[] {1, x});

			
			while (!dq.isEmpty()) {
				int[] node = dq.poll();
				int r = node[0];
				int c = node[1];
				
				if (board[r][c] == 2) {
					System.out.println("#" + t + " " + x);
					return;
				}
				
				if (r == N-1) break;
				
				for (int i = 0; i < 3; i++) {
					int nr = d[i][0] + r;
					int nc = d[i][1] + c;
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (board[nr][nc] == 0) continue;
					if (visited[nr][nc]) continue;
					
					dq.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					break;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = 100;
		
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solution(t);
		}
	}

}
