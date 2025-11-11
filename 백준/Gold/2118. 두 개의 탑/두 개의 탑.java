import java.util.*;
import java.io.*;

public class Main {
	public static int N, total;
	public static int[] nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			total += nums[i];
		}
		
		int left = 0;
		int right = 1;
		int d = nums[0];
		int answer = Math.min(d, total-d);
		
		while (left <= right && right < N) {
			if (total - d > d) {
				d += nums[right];
				right++;
			} else {
				d -= nums[left];
				left++;
			}
			
			answer = Math.max(answer, Math.min(d, total-d));
		}
		
		System.out.println(answer);
	}
}
