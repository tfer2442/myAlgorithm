import java.util.*;
import java.io.*;


public class Main {
	public static int N, M, B;
	public static int[][] board;
	public static int answer = Integer.MAX_VALUE;
	public static int result = 0;
	
	public static void calculate(int value) {
		int curB = B;
		int sec = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] > value) {
					curB += (board[i][j] - value);
					sec += (board[i][j] - value) * 2;
				} else if(board[i][j] < value) {
					curB -= (value - board[i][j]);
					sec += (value - board[i][j]);
				}
			}
		}
		
		if (curB >= 0) {
			if (answer >= sec) {
				answer = sec;
				result = value;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <= 256; i++) {
			calculate(i);
		}
		
		System.out.println(answer + " " + result);
	}

}
