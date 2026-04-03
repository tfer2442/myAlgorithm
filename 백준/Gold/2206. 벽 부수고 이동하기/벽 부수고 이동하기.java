import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int[][] board;
	public static int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		int[][][] visited = new int[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
			
				for (int k = 0; k < 2; k++) {
					visited[i][j][k] = 1_000_000_000;
				}
			}
		}
				
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		visited[0][0][0] = 1;
		dq.add(new int[] {0, 0, 0});
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];

				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
					continue;
				}

				if (board[nextR][nextC] == 1 && node[2] == 1) continue;

				if (visited[nextR][nextC][board[nextR][nextC]+node[2]] > visited[node[0]][node[1]][node[2]] + 1) {
					visited[nextR][nextC][board[nextR][nextC]+node[2]] = visited[node[0]][node[1]][node[2]] + 1;
					dq.add(new int[] {nextR, nextC, node[2]+board[nextR][nextC]});
				}
			}
		}	
		
		if (visited[N-1][M-1][0] == 1_000_000_000 && visited[N-1][M-1][1] == 1_000_000_000) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]));
		}
		
	}
}
