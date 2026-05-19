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
			
			int answer = 0;
			for (int j = 0; j < N; j++) {
				int value = 0;

				for (int i = 0; i < N; i++) {
					value += board[i][j];
					
					if (value == 2) {
						if (board[i][j] == 2)  {
							value = 0;
						} else if (board[i][j] == 1) {
							value = 1;
						}
						continue;
					}
					
					if (value == 3) {
						answer++;
						value = 0;
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
