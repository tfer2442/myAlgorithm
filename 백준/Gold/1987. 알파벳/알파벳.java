import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] board;
	public static boolean[] visited;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static int answer = 0;
	
	public static void dfs(int r, int c, int depth) {
		answer = Math.max(answer, depth);

		for (int[] dd : d) {
			int row = r+dd[0];
			int col = c+dd[1];
			
			if (0 > row || N <= row || 0 > col || M <= col) continue;
			
			char target = board[row][col];
			
			if (visited[target-'A']) continue;
			visited[target-'A'] = true;
			dfs(row, col, depth+1);
			visited[target-'A'] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		visited = new boolean[26]; 
		visited[board[0][0]-'A'] = true;
		dfs(0, 0, 0);
		
		System.out.println(answer+1);
	}
}
