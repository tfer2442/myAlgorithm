import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n, k;
	public static int[][] arr;
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		n = Integer.parseInt(tmp[0]);
		k = Integer.parseInt(tmp[1]);
		
		arr = new int[n][2];
		dp = new int[n+1][k+1];
		
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]);
			arr[i][1] = Integer.parseInt(tmp[1]);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (arr[i-1][0] > j) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], arr[i-1][1] + dp[i-1][j-arr[i-1][0]]);
			}
		}
		
		System.out.println(dp[n][k]);
		
	}

}
