import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int[] dp;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		String[] tmp = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			arr[i+1] = Integer.parseInt(tmp[i]);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				dp[j] = Math.max(dp[j], arr[i]+dp[j-i]);
			}
		}
		System.out.println(dp[n]);
	}
}
