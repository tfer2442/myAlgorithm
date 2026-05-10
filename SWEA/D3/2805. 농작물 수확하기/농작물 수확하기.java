import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N;
	public static int[][] board;
	public static boolean[][] visited;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void bfs() {
		int g = N / 2;
		int answer = 0;
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {0, g, g});
		visited[g][g] = true;
		answer += board[g][g];
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			int value = node[0];
			int r = node[1];
			int c = node[2];
			
			if (value == g) continue;
			
			for (int i = 0; i < 4; i++) {
				int nextR = r + d[i][0];
				int nextC = c + d[i][1];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				if (visited[nextR][nextC]) continue;
				
				dq.add(new int[] {value+1, nextR, nextC});
				visited[nextR][nextC] = true;
				answer += board[nextR][nextC];
			}
		}
		
		System.out.println(answer);		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				
				for (int j = 0; j < N; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}
			
			System.out.printf("#" + t + " ");
			bfs();
		}
	}

}
