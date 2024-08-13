import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int[] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			if (Math.sqrt(i)%1 == 0) {
				dp[i] = 1;
				continue;
			}
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (dp[i] == 0 || dp[i] > dp[i-j*j] + dp[j*j]) {
					dp[i] = dp[i-j*j] + dp[j*j];
				}
			}
		}
		
		System.out.println(dp[n]);
	}

}
