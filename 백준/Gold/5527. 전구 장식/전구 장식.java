import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static int[] dp;
	public static List<Integer> nums;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		nums = new ArrayList<>();
		dp = new int[N];
		
		for (int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		
		for (int i = 1; i < N; i++) {
			if (arr[i] != arr[i-1]) {
				dp[i] = dp[i-1] + 1;
				continue;
			}
			
			dp[i] = 1;
			nums.add(dp[i-1]);
		}
		nums.add(dp[N-1]);
		
		if (nums.size() == 1) {
			System.out.println(nums.get(0));
			return;
		}
		
		if (nums.size() == 2) {
			System.out.println(nums.get(0) + nums.get(1));
			return;
		}
		
		int sum = nums.get(0) + nums.get(1) + nums.get(2);
		int answer = sum;
		
		for (int i = 3; i < nums.size(); i++) {
			sum -= nums.get(i-3);
			sum += nums.get(i);
			
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
