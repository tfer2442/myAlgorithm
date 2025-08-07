import java.util.*;
import java.io.*;

/*
 * 증가하는 부분수열 중 합이 가장 큰 것
 * 수열의 길이 : 1 <= N <= 1000
 * 원소: 1 <= 원소 <= 1000, 1000 * 1000 = 1_000_000 이므로 int
 * 
 * 이중 for문으로 자신의 원소 값보다 작으면서, 최대합을 가지는 원소를 구한다.
 */
public class Main {
	public static int N;
	public static int[] nums, dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = nums[i];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], nums[i]+dp[j]);
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}
