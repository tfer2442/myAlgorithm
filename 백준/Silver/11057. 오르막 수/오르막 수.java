import java.util.*;
import java.io.*;

/*
 * 주의할 것
 * 1. 10_007로 나눈 나머지를 출력
 */
public class Main {
	public static int N;
	public static long[] nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(10);
			return;
		}
		
		nums = new long[10];
		
		for (int i = 0; i < 10; i++) {
			nums[i] = i+1;
		}
		
		for (int i = 2; i < N; i++) {
			long sum = 0;
			
			for (int j = 0; j < 10; j++) {
				sum = (sum + nums[j]) % 10_007;
			}
			
			long[] nums2 = new long[10];
			nums2[9] = sum;
			
			for (int j = 8; j >= 0; j--) {
//				nums2[j] = nums2[j+1] - nums[j+1];
                nums2[j] = (nums2[j + 1] - nums[j + 1] + 10_007) % 10_007;
			}
			
			for (int j = 0; j < 10; j++) {
				nums[j] = nums2[j];
			}
		}
		
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + nums[i]) % 10_007;
		}
		
		System.out.println(answer);
	}
}
