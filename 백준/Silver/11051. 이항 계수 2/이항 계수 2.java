import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, K;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);
		
		if (N-K < K) {
			K = N-K;
		}
		
		int[][] dp = new int[N+1][K+1];

		for (int i = 0; i <= N; i++) {
			dp[i][0] = 1;
			if (i <= K) {
				dp[i][i] = 1;
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= Math.min(K, i); j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		System.out.println(dp[N][K]);
	}

}
