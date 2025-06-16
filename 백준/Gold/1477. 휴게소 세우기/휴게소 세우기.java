import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, L;
	public static int[] nums;
	
	public static int calculate(int mid) {
		int cnt = 0;
		
		for (int i = 1; i <= N+1; i++) {
			cnt += (nums[i]-nums[i-1]-1)/mid;
		}
		
		if (cnt > M) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		nums = new int[N+2];
				
		st = new StringTokenizer(br.readLine());

		nums[0] = 0;
		nums[N+1] = L;
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int left = 1;
		int right = L-1;
		int mid = (left + right) / 2;
		int answer = mid; 
		
		while (left <= right) { 
			mid = (left + right) / 2;
			int cal = calculate(mid);
			
			if (cal == 1) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
