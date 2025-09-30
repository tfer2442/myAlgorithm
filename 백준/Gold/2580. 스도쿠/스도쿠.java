import java.util.*;
import java.io.*;


public class Main {
	public static int[][] board;
	public static ArrayList<int[]> zeros;
	public static int cnt;
	
	public static boolean isPlaceable(int a, int b, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[i][b] == num) return false;
			if (board[a][i] == num) return false;
		}
		
		for (int i = a/3*3; i < a/3*3+3; i++) {
			for (int j = b/3*3; j < b/3*3+3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean calculate(int depth) {
		if (depth == cnt) {
			
			return true;
		}
		
		for (int i = 1; i <= 9; i++) {
			int a = zeros.get(depth)[0];
			int b = zeros.get(depth)[1];
			
			if(isPlaceable(a, b, i)) {
				board[a][b] = i;
				if (calculate(depth+1)) {
					return true;
				}
				board[a][b] = 0;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[9][9];
		zeros = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				board[i][j] = tmp;
				
				if (tmp == 0) {
					cnt++;
					zeros.add(new int[] {i, j});
				}
			}
		}
		
		calculate(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
