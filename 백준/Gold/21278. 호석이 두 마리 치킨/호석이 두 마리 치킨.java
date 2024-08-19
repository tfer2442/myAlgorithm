import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] board;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];
		
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				if (i == j) {
					board[i][j] = 0;
					continue;
				}
				board[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			board[start][end] = 1;
			board[end][start] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (board[i][k] == Integer.MAX_VALUE) continue;
				for (int j = 1; j <= N; j++) {
					if (board[k][j] == Integer.MAX_VALUE) continue;
					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
				}
			}
		}
		
		int answerNode1 = 1;
		int answerNode2 = 2;
		int answer = Integer.MAX_VALUE;
		
		for (int i = 1; i < N; i++) {
			for (int j = i+1; j <= N; j++) {
				int sum = 0;
				for (int k = 1; k <= N; k++) {
					if (k == i || k == j) continue;
					sum += Math.min(board[i][k], board[j][k]);
				}
				if (answer > sum) {
					answer = sum;
					answerNode1 = i;
					answerNode2 = j;
				}
			}
		}
		System.out.println(answerNode1 + " " + answerNode2 + " " + (answer*2));
	}

}
