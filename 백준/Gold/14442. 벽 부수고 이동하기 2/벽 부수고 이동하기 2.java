import java.util.*;
import java.io.*;

/*
 * 1은 벽
 * K개만큼 벽을 깨는거 가능
 * 일단, 최단거리이므로 BFS임
 * 그런데, 벽을 부수는 상태를 저장해야하므로 3차원 visited를 사용
 * [i][j][3] -> i->j까지 벽 3개를 부수고 갔을 때의 최단거리
 */
public class Main {
	public static int N, M, K;
	public static int[][] board;
	public static int[][][] distance;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void bfs() {
		distance = new int[N][M][K+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k <= K; k++) {
					distance[i][j][k]= 1_000_000_000;
				}
			}
		}
		
		distance[0][0][0] = 1;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		// r, c, 부순벽 갯수
		dq.add(new int[] {0, 0, 0});
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			int r = node[0];
			int c = node[1];
			int wall = node[2];
			
			for (int[] curD : d) {
				int nextR = r + curD[0];
				int nextC = c + curD[1];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
				if (board[nextR][nextC] == 1 && wall >= K) continue; 
				
				if (distance[nextR][nextC][wall+board[nextR][nextC]] > distance[r][c][wall]+1) {
					distance[nextR][nextC][wall+board[nextR][nextC]] = distance[r][c][wall]+1;
					dq.add(new int[] {nextR, nextC, wall+board[nextR][nextC]});
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs();
		
		int answer = 1_000_000_000;
		for (int i = 0; i <= K; i++) {
			answer = Math.min(answer, distance[N-1][M-1][i]);
		}
		
		if (answer == 1_000_000_000) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
