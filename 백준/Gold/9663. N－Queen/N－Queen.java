import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int total = 0;
	static boolean[][] board;
	
	private static boolean isPossiblePosition(int row, int col) {
		// 왼쪽 위
		for (int i = 1; i < n; i++) {
			int dRow = row - i;
			int dCol = col - i;
			
			if (dRow < 0 || dCol < 0) {
				break;
			}
			
			if (board[dRow][dCol]) {
				return false;
			}
		}
		
		// 오른쪽 위
		for (int i = 1; i < n; i++) {
			int dRow = row - i;
			int dCol = col + i;
			
			if (dRow < 0 || dCol >= n) {
				break;
			}
			
			if (board[dRow][dCol]) {
				return false;
			}
		}
		
		// 위
		for (int i = 1; i < n; i++) {
			int dRow = row - i;
			
			if (dRow < 0) {
				break;
			}
			
			if (board[dRow][col]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void backtracking(int row) {
		if (row == n) {
			total += 1;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isPossiblePosition(row, i)) {
				board[row][i] = true;
				backtracking(row+1);
				board[row][i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];
		
		backtracking(0);
		System.out.println(total);
	}
}
