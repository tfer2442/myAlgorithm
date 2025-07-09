import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int[][] board;
	public static boolean[][] visited;
	public static int myForce, enemyForce;
	public static int[][] d = {{-1 ,0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void bfs(int target, int r, int c) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		visited[r][c] = true;
		dq.offer(new int[] {r, c});
		int cnt = 1;
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
				if (visited[nextR][nextC]) continue;
				if (target != board[nextR][nextC]) continue;
				
				visited[nextR][nextC] = true;
				dq.offer(new int[] {nextR, nextC});
				cnt++;
			}	
		}
		
		if (target == 0) {
			myForce += cnt * cnt;
		} else {
			enemyForce += cnt * cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (tmp.charAt(j) == 'W') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
				}
			}
		}
		
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) continue;
				bfs(board[i][j], i, j);
			}
		}
		
		System.out.println(myForce + " " + enemyForce);
	}

}
