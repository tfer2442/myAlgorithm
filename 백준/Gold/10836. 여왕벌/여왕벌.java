import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] board;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(board[i], 1);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			for (int j = N-1; j >= 0; j--) {
				if (zero > 0) {
					zero--;
					continue;
				} 
				
				if (one > 0) {
					one--;
					board[j][0] += 1;
					continue;
				}
				
				if (two > 0) {
					two--;
					board[j][0] += 2;
					continue;
				}
			}
			
			for (int j = 1; j < N; j++) {
				if (zero > 0) {
					zero--;
					continue;
				}
				
				if (one > 0) {
					one--;
					board[0][j] += 1;
					continue;
				}
				
				if (two > 0) {
					two--;
					board[0][j] += 2;
					continue;
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				board[i][j] = Math.max(Math.max(board[i-1][j], board[i][j-1]), board[i-1][j-1]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
