import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static int T;
	public static int N;
	public static int[] nums;
	public static int[] dp;
	public static int cnt;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[N];
			dp = new int[N];
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = nums[0];
			
			for (int i = 1; i < N; i++) {
				int left = 0;
				int right = cnt;
				int target = nums[i];
				
				while (left <= right) {
					int mid = (left + right) / 2;
					
					if (dp[mid] > target) {
						right = mid - 1;
					} else if (dp[mid] <= target) {
						left = mid + 1;
					}
				}
				
				if (left >= cnt+1) {
					dp[cnt+1] = target;
					cnt++;
				} else {
					dp[left] = target;
				}
			}
			
			System.out.println("#" + t + " " + (cnt+1));			
		}
	}

}
