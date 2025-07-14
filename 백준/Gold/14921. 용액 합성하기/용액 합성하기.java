import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] nums;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = N - 1;
		int answer = Integer.MAX_VALUE;
		
		while (left < right) {
			int value = nums[left] + nums[right];
			
			if (Math.abs(value) < Math.abs(answer)) {
				answer = value;
			} 
			
			if (value > 0) {
				right -= 1;
			} else if (value < 0) {
				left += 1; 
			} else if (value == 0) {
				answer = 0;
				break;
			}
		}
		System.out.println(answer);
	}
}
