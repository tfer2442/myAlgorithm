import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static int[][] board;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp.charAt(j) - 'N';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					board[i][j] = 0;
					continue;
				}
				
				if (board[i][j] == 0) {
					board[i][j] = Integer.MAX_VALUE;
				} else {
					board[i][j] = 1;
				}
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (board[i][k] == Integer.MAX_VALUE) continue;
				for (int j = 0; j < N; j++) {
					if (board[k][j] == Integer.MAX_VALUE) continue;
					board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int twoFriend = 0;
			
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (board[i][j] <= 2) twoFriend++;
			}
			answer = Math.max(answer, twoFriend);
		}
		System.out.println(answer);
	}

}
