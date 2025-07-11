import java.util.*;
import java.io.*;

public class Main {
	public static int N, K;
	public static int[] nums;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		long left = 1;
		long right = 0;
		
		for (int i = 0 ; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, nums[i]);
		}
		
		long answer = 0;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				cnt += nums[i] / mid;
			}
			
			if (cnt >= K) {
				answer = mid;
				left = mid + 1;
			} else if (cnt < K) {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

}
