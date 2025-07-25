import java.util.*;
import java.io.*;

/*
 * 거리가 2이내의 친구가 가장 많은 사람이 정답
 * 플로이드-와샬을 이용해 모든 사람들 간의 최단거리를 구하면 된다.
 * O(N^3), 1 <= N <= 50 : 가능
 */
public class Main {
	public static int N;
	public static int[][] board;

	public static void floydWarshall() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (board[i][k] == Integer.MAX_VALUE) continue;
				
				for (int j = 0; j < N; j++) {
					if (board[k][j] == Integer.MAX_VALUE) continue;
					
					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (tmp.charAt(j) == 'N') {
					board[i][j] = Integer.MAX_VALUE;
				} else {
					board[i][j] = 1;
				}
				
			}
		}
		
		floydWarshall();
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				if (board[i][j] <= 2) {
					cnt++;
				}
			}
			
			answer = Math.max(answer, cnt-1);
		}
		
		System.out.println(answer);
	}
}
