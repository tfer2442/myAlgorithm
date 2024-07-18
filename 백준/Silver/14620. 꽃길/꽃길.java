import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] board; 
	static boolean[][] visited;
	static int n;
	static int[][] d = {{0, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static int minValue = Integer.MAX_VALUE;
	
	static boolean isPossible(int row, int col) {
		for (int[] curD : d) {
			int curRow = curD[0] + row;
			int curCol = curD[1] + col;
			
			if (visited[curRow][curCol]) {
				return false;
			}
		}
		return true;
	}
	
	
	static void backtracking(int cnt) {
		if (cnt == 3) {
			int total = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						total += board[i][j];
					}
				}
			}
			minValue = Math.min(minValue, total);
			return;
		}
		
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (isPossible(i, j)) {
					visited[i][j] = true;
					visited[i-1][j] = true;
					visited[i][j-1] = true;
					visited[i+1][j] = true;
					visited[i][j+1] = true;			
					backtracking(cnt+1);
					visited[i][j] = false;
					visited[i-1][j] = false;
					visited[i][j-1] = false;
					visited[i+1][j] = false;
					visited[i][j+1] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] str1 = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(str1[j]);
			}
		}
		
		backtracking(0);
		System.out.println(minValue);
	}
}
