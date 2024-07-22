import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[] p = new int[4];
	static double result = 0;
	
	public static void dfs(int row, int col, int depth, double total) {
		if (depth == n) {
			result += total;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nextRow = d[i][0] + row;
			int nextCol = d[i][1] + col;
			
			if (visited[nextRow][nextCol]) continue;
			visited[nextRow][nextCol] = true;
			dfs(nextRow, nextCol, depth+1, total*(p[i]/100.0));
			visited[nextRow][nextCol] = false;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		board = new int[(n+1)*2+1][(n+1)*2+1];
		visited = new boolean[(n+1)*2+1][(n+1)*2+1];
		
		for (int i = 0; i < 4; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		visited[n+1][n+1] = true;
		dfs(n+1, n+1, 0, 1);
		System.out.println(result);
	}
}
