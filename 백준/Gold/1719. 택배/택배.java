import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[][] board;
	public static int[][] answer;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n+1][n+1];
		answer = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				answer[i][j] = j;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			board[a][b] = board[b][a] = Math.min(board[a][b], value);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (board[i][k] == Integer.MAX_VALUE) continue;
				for (int j = 1; j <= n; j++) {
					if (board[k][j] == Integer.MAX_VALUE) continue;
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
						answer[i][j] = answer[i][k];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					sb.append("- ");
					continue;
				}
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
