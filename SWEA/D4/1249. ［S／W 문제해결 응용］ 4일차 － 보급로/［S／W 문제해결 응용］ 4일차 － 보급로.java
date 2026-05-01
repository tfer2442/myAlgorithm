import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N;
	public static int[][] board, distance;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void solution(int t) throws Exception {		
		distance[0][0] = 0;
		
		// value, r, c
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
			return o1[0]-o2[0];
		});
		
		pq.add(new int[] {0, 0, 0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int value = node[0];
			int r = node[1];
			int c = node[2];
			
			if (value > distance[r][c]) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = d[i][0] + r;
				int nc = d[i][1] + c;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if (distance[nr][nc] > board[nr][nc] + value) {
					distance[nr][nc] = board[nr][nc] + value;
					pq.add(new int[] {distance[nr][nc], nr, nc});
				}
			}
		}		
		
		System.out.println("#" + t + " " + distance[N-1][N-1]);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				
				for (int j = 0; j < N; j++) {
					board[i][j] = line.charAt(j) - '0';
					distance[i][j] = 1_000_000_000;
				}
			}
			
			solution(t);
		}
	}

}
