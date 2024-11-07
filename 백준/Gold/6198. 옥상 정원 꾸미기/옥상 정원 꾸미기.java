import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int N;
	public static int[] nums;
	public static long[] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		dp = new long[N+1];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		dp[N-1] = 0;
		dp[N] = -1;
		
		for (int i = N-2; i >= 0; i--) {
			int target = i+1;
			long tmp = 0;
			
			while (true) {
				if (nums[i] > nums[target]) {
					tmp += (dp[target]+1);
					target += (dp[target]+1);
				} else {
					break;
				}
				
				if (target >= N) break;
			}
			
			if (tmp == 0) continue;
			dp[i] = tmp;
		}
		
		long answer = 0;
		for (int i = 0; i < N-1; i++) {
			answer += dp[i];
		}
		
		System.out.println(answer);
	}
}
