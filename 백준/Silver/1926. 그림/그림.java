import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int n, m;
	static int maxSize = 0;
	static int paintCnt = 0;
	static Deque<int[]> dq = new ArrayDeque<>();
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static int[][] board;
	
	static void bfs(int row, int col) {
		int size = 0;
		dq.add(new int[] {row, col});
		
		while(!dq.isEmpty()) {
			size++;
			int[] cntNode = dq.poll();
			int cntRow = cntNode[0];
			int cntCol = cntNode[1];
			
			for (int[] curD : d) {
				int nextRow = curD[0] + cntRow;
				int nextCol = curD[1] + cntCol;
				
				if (0 > nextRow || nextRow >= n || 0 > nextCol || nextCol >= m) continue;
				if (board[nextRow][nextCol] == 0) continue;
				if (visited[nextRow][nextCol]) continue;
				
				visited[nextRow][nextCol] = true;
				dq.add(new int[] {nextRow, nextCol});
			}
		}
		maxSize = Math.max(maxSize, size);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		
		visited = new boolean[n][m];
		board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					visited[i][j] = true;
					paintCnt++;
					bfs(i, j);
				}
				
			}
		}
		
		System.out.println(paintCnt);
		System.out.println(maxSize);
	}
}
