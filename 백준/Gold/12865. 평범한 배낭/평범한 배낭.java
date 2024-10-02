import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	public static int[] dp;
	public static int[] costs, values;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		costs = new int[N+1];
		values = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= 1; j--) {
				if (j-costs[i] < 0) {
					continue;
				}
				dp[j] = Math.max(dp[j], dp[j-costs[i]] + values[i]);
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= K; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
