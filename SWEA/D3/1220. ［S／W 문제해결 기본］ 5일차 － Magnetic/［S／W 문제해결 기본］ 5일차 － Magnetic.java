import java.util.*;
import java.io.*;

public class Solution {
	public static int[][] board;
	public static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1이 N극 2가 S극
			// j는 열
			// N 자성체부터 아래로 쭉 내리기
			for (int j = 0; j < N; j++) {
				for (int i = N-1; i >= 0; i--) {
					if (board[i][j] != 1) continue;
					
					// 만약 1이라면? 그 위치부터 쭉 떨어트려야 함
					
					boolean flag = false;
					for (int k = i+1; k < N; k++) {
						if (board[k][j] != 0) {
						    if (k - 1 != i) {
						        board[k-1][j] = 1;
						        board[i][j] = 0;
						    }
							flag = true;
							break;
						}
					}
					
					if (!flag) {
						board[i][j] = 0;
					}
				}
			}
			
			// S자성체 위로 올리기
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (board[i][j] != 2) continue;
					
					// 만약 2이라면? 그 위치부터 쭉 올려야 함
					
					boolean flag = false;
					for (int k = i-1; k >= 0; k--) {
						if (board[k][j] != 0) {
						    if (k + 1 != i) {
						        board[k+1][j] = 2;
						        board[i][j] = 0;
						    }
							flag = true;
							break;
						}
					}
					
					if (!flag) {
						board[i][j] = 0;
					}
				}

			}
			
			int answer = 0;
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N-1; i++) {
					if (board[i][j] == 1 && board[i+1][j] == 2) {
						answer++;
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
