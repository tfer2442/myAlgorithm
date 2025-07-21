import java.util.*;
import java.io.*;

/*
 * 수열의 길이: 1 <= N <= 100,000 
 * O(NlogN) 이내로 문제를 해결
 * 반복문을 돌면서, 자신의 이전 값과 비교해 같거나 크면 dp[i] = dp[i-1] + 1, 작다면 dp[i] = 1
 * 감소하는 수열도 동일
 * 증가와 감소를 하나의 반복문에서 처리할 수 있다.
 */
public class Main {
	public static int N, answer;
	public static int[] nums, upDP, downDP;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		upDP = new int[N];
		downDP = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			upDP[i] = 1;
			downDP[i] = 1;
		}
		
		answer = 1;
		for (int i = 1; i < N; i++) {
			if (nums[i] >= nums[i-1]) {
				upDP[i] = upDP[i-1]+1;
			}
			
			if (nums[i] <= nums[i-1]) {
				downDP[i] = downDP[i-1]+1;
			}
			
			answer = Math.max(answer, Math.max(upDP[i], downDP[i]));
		}
		
		System.out.println(answer);
	}
}
