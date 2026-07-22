import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N;
	public static char[][] board;
	public static boolean[][] visited;
	public static int[][] d = {{-1, 0}, {-1, 1}, {-1, -1},{0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};

	
	public static void bfs(int r, int c) {
		visited[r][c] = true;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {r, c});
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			boolean flag = false;
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				
				if (board[nextR][nextC] != '.') {
					flag = true;
					break;
				}
			}
			
			if (flag) continue;
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				if (visited[nextR][nextC]) continue;
				if (board[nextR][nextC] != '.') continue;
				
				visited[nextR][nextC] = true;
				dq.add(new int[] {nextR, nextC});
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				
				for (int j = 0; j < N; j++) {
					board[i][j] = tmp.charAt(j);
				}
			}
			
			// 8방이 0인 것들부터 bfs를 통해서 visited를 채우자
			
			int answer = 0;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					if (board[i][j] != '.') continue;
					
					boolean flag = false;
					
					for (int[] dd : d) {
						int nextR = i + dd[0];
						int nextC = j + dd[1];
						
						if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
						
						if (board[nextR][nextC] != '.') {
							flag = true;
							break;
						}
					}
					
					if (!flag) {
						bfs(i, j);
						answer++;
					}					
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
			        if (!visited[i][j] && board[i][j] == '.') answer++;
				}
			}
			
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
