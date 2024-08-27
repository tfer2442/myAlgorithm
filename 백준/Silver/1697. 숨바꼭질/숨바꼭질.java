import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	public static int[] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N == K) {
			System.out.println(0);
			return;
		}
		
		if (N < K) {
			dp = new int[K*2+1];			
		} else {
			dp = new int[N+1];
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(N);
		dp[N] = 1;
		
		while (!dq.isEmpty()) {
			int value = dq.poll();
			
			if (value == K) {
				System.out.println(dp[value]-1);
				break;
			}
			

			if (value < K && dp[value+1] == 0) {
				dp[value+1] = dp[value]+1;
				dq.add(value+1);
			}
			
			if (value < K && dp[value*2] == 0) {
				dp[value*2] = dp[value]+1;
				dq.add(value*2);
			}

		
			if (value > 0 && dp[value-1] == 0) {
				dp[value-1] = dp[value]+1;
				dq.add(value-1);
			}
		}
	}
		
}
