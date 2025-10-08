import java.util.*;
import java.io.*;


public class Main {
	public static int N, M;
	public static int[][] board;
	public static int[][] distance;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void bfs() {
		distance[0][0] = 0;
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.addFirst(new int[] {0, 0});
		
		while (!dq.isEmpty()) {
			int[] node = dq.pollFirst();
			
			if (node[0] == N-1 && node[1] == M-1) return;
			
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
				if (distance[nextR][nextC] > distance[node[0]][node[1]] + board[nextR][nextC]) {
					distance[nextR][nextC] = distance[node[0]][node[1]] + board[nextR][nextC];
					
					if (board[nextR][nextC] == 1) {
						dq.addLast(new int[] {nextR, nextC});						
					} else {
						dq.addFirst(new int[] {nextR, nextC});						
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		distance = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp.charAt(j) - '0';
			}
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		bfs();
		System.out.println(distance[N-1][M-1]);
	}
}
