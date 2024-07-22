import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

	public static void bfs(int sRow, int sCol) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[]{sRow, sCol});
		visited[sRow][sCol] = true;
		
		while (!deque.isEmpty()) {
			int[] cur = deque.removeFirst();
						
			for (int[] nextD : d) {
				int nextRow = cur[0] + nextD[0];
				int nextCol = cur[1] + nextD[1];
				
				if (nextRow >= n || nextRow < 0 || nextCol >= n || nextCol < 0) continue;
			
				if (visited[nextRow][nextCol]) continue;
				
				visited[nextRow][nextCol] = true;
				deque.addLast(new int[]{nextRow, nextCol});	
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		int MAX_VALUE = -1;
		
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
				MAX_VALUE = Math.max(MAX_VALUE, board[i][j]);
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < MAX_VALUE; i++) {
			visited = new boolean[n][n];
			int cnt = 0;
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (board[j][k] <= i) {
						visited[j][k] = true;
					}
				}
			}
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (visited[j][k] == false) {
						bfs(j, k);
						cnt++;
					}
				}
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
}
