import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] board;
	public static int[][] d = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
	public static boolean[][] visited;
	public static int N = 19;
	public static int answer;
	
	public static void dfs(int row, int col, int value, int dd) {
		if (row-d[dd][0] >= 0 && col-d[dd][1] >= 0 && row-d[dd][0] < N && col-d[dd][1] < N && !visited[row-d[dd][0]][col-d[dd][1]] && board[row-d[dd][0]][col-d[dd][1]] == value) {
			answer++;
			visited[row-d[dd][0]][col-d[dd][1]] = true;
			dfs(row-d[dd][0], col-d[dd][1], value, dd);
		}
		
		if (row+d[dd][0] < N &&  col+d[dd][1] < N && row+d[dd][0] >= 0 && col+d[dd][1] >= 0 && !visited[row+d[dd][0]][col+d[dd][1]] && board[row+d[dd][0]][col+d[dd][1]] == value) {
			answer++;
			visited[row+d[dd][0]][col+d[dd][1]] = true;
			dfs(row+d[dd][0], col+d[dd][1], value, dd);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[19][19];
		
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (board[i][j] == 0) continue;
				
				for (int k = 0; k < 4; k++) {
					visited = new boolean[19][19];
					answer = 1;
					visited[i][j] = true;
					dfs(i, j, board[i][j], k);
					
					if (answer == 5) {
						System.out.println(board[i][j]);
						System.out.println((i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

}
