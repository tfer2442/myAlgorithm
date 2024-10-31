import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N, M;
	public static char[][] board;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static long[] dp;
	
	public static long pow(int x) {
		if (dp[x] != 0) {
			return dp[x] % 1_000_000_007;
		}
		
		if (x % 2 == 0) {
			return (pow(x/2) * pow(x/2)) % 1_000_000_007; 
		} else {
			return (pow(x/2) * pow(x/2) * 2) % 1_000_000_007;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		
		board = new char[N][M];
		dp = new long[2001*2001];
		dp[0] = 1;
		dp[1] = 2;
		
		for (int i = 0; i < N; i++) {
			String tmp2 = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp2.charAt(j);
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean flag = false;
				
				for (int[] k : d) {
					if (k[0] + i < 0 || k[0] + i >= N || k[1] + j < 0 || k[1] + j >= M) continue;
					if (board[i][j] != board[i+k[0]][j+k[1]]) {
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					answer++;
				}
			}
		}
		
		System.out.println(pow(answer));
	}

}
