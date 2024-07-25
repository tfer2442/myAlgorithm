import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int n, m;
	static char[][] board;
	static int myTeam;
	static int enemy;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	static void bfs(int row, int col, char point) {
		Deque<int[]> dq = new ArrayDeque<>();
		int size = 0;
		dq.add(new int[] {row, col});
		
		while (!dq.isEmpty()) {
			size++;
			int[] node = dq.poll();
			int cntRow = node[0];
			int cntCol = node[1];
			
			for (int[] curD : d) {
				int nextRow = curD[0] + cntRow;
				int nextCol = curD[1] + cntCol;
				
				if (0 > nextRow || nextRow >= n || 0 > nextCol || nextCol >= m) continue;
				if (visited[nextRow][nextCol]) continue;
				if (board[nextRow][nextCol] == point) {
					visited[nextRow][nextCol] = true;
					dq.add(new int[] {nextRow, nextCol});
				}
			}
		}
		
		if (point == 'W') {
			myTeam += size*size;
		} else {
			enemy += size*size;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		m = Integer.parseInt(tmp[0]);
		n = Integer.parseInt(tmp[1]);
		board = new char[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = tmp[j].charAt(0);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					char point = (board[i][j] == 'W' ? 'W' : 'B');
					bfs(i, j, point);
				}
			}
		}
		System.out.println(myTeam + " " + enemy);
	}

}
