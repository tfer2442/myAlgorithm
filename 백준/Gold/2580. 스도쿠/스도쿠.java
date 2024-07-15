import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	static int board[][];
	static int n = 9;
	static ArrayList<int[]> arr = new ArrayList<>();
	
	
	private static boolean isPossibleNum(int num, int row, int col) {
		
		for (int i = 0; i < n; i++) {
			if (row != i && board[i][col] == num) {
				return false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (col != i && board[row][i] == num) {
				return false;
			}
		}
		
		for (int i = (row/3)*3; i < (row/3)*3+3; i++) {
			for (int j = (col/3)*3; j < (col/3)*3+3; j++) {
				if (row == i && col == j) {
					continue;
				}
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	private static void backtracking(int cur, int row, int col) {
		
		for (int i = 1; i <= 9; i++) {
			if (isPossibleNum(i, row, col)) {
				board[row][col] = i;
				if (cur+1 >= arr.size()) {
					printBoard();
					System.exit(0);
				}
				backtracking(cur+1, arr.get(cur+1)[0], arr.get(cur+1)[1]);
				board[row][col] = 0;
			}
		}
	}
	
	
	private static void printBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d ", board[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
		
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
				if (board[i][j] == 0) {
					arr.add(new int[] {i, j});
				}
			}
		}
		
		backtracking(0, arr.get(0)[0], arr.get(0)[1]);
	}
}
