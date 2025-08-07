import java.util.*;
import java.io.*;

/*
 * 구현 문제, dfs
 * 1. 벽이 있으면 가지 못한다.
 * 2. 주어진 요구사항의 순서에 맞게 구현
 * 3. 바라본 방향대로 후진하지 못하면, 작동을 멈춘다!
 */
public class Main {
	public static int N, M, sr, sc, sd, answer;
	public static int[][] d = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static int[][] board;
	
	public static void dfs(int curR, int curC, int curD) {
		if (board[curR][curC] == 0) {
			board[curR][curC] = 2;
			answer++;			
		}
		
		for (int i = 0; i < 4; i++) {
			int nextD = (curD + 3 - i) % 4;
			int nextR = curR + d[nextD][0];
			int nextC = curC + d[nextD][1];
			
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
			if (board[nextR][nextC] == 1) continue;
			if (board[nextR][nextC] == 2) continue;
			dfs(nextR, nextC, nextD);
			return;
		}
		
		int backD = (curD + 2) % 4;
		int backR = curR + d[backD][0];
		int backC = curC + d[backD][1];
		
		if (backR < 0 || backR >= N || backC < 0 || backC >= M || board[backR][backC] == 1) {
			return;
		} else {
			dfs(backR, backC, curD);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(sr, sc, sd);
		System.out.println(answer);
	}
}
