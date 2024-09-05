import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] board;
	public static boolean[][] visited;
	public static int N;
	public static int[][] d = {{0, 1}, {1, 1}, {1, 0}};
	public static int answer = 0;
	
	public static void dfs(int cRow, int cCol,int cD) {
		if (cRow == N-1 && cCol == N-1) {
			answer++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (cD == 0 && i == 2) continue;
			if (cD == 2 && i == 0) continue;
			int nRow = cRow + d[i][0];
			int nCol = cCol + d[i][1];
			
			if (0 > nRow || nRow >= N || 0 > nCol || nCol >= N) continue;
			if (visited[nRow][nCol]) continue;
			if (board[nRow][nCol]==1) continue;
			if (i==1 && (board[nRow-1][nCol]==1 || board[nRow][nCol-1]==1)) continue;
			visited[nRow][nCol] = true;
			dfs(nRow, nCol, i);
			visited[nRow][nCol] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][0] = true;
		visited[0][1] = true;
		dfs(0, 1, 0);
		System.out.println(answer);
	}

}
