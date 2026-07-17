import java.util.*;
import java.io.*;

public class Solution {
	public static int T;
	public static char[][] board;
	
	public static boolean calculate(int L) {
		for (int k = 0; k < 100-L+1; k++) {
			int start = k;
			int end = k+L-1;
			
			// 가로 board[i][start] ~ board[i][end]
			for (int i = 0; i < 100; i++) {
				boolean flag = false;
				for (int j = 0; j < L/2; j++) {
					if (board[i][start+j] != board[i][end-j]) {
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					return true;
				}
			}
			
			// 세로 board[start][i] ~ board[end][i]
			for (int i = 0; i < 100; i++) {
				boolean flag = false;
				
				for (int j = 0; j < L/2; j++) {
					if (board[start+j][i] != board[end-j][i]) {
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			board = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				String tmp = br.readLine();
				
				for (int j = 0; j < 100; j++) {
					board[i][j] = tmp.charAt(j);
				}
			}
						
			for (int i = 100; i > 0; i--) {
				if (calculate(i)) {
					System.out.println("#" + T + " " + i);
					break;
				}
			}			
		}
	}

}
