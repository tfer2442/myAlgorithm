import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static Integer[] nums;
	public static int[] sums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	
		
		Arrays.sort(nums, (o1, o2) -> {
			return o2-o1;
		});
		
		sums = new int[M];
		
		for (int i = 0; i < N; i++) {
			int minIndex = 0;
			int minSum = sums[0];
			
			for (int j = 0; j < M; j++) {
				if (sums[j] < minSum) {
					minIndex = j;
					minSum = sums[j]; 
				}
			}
			
			sums[minIndex] += nums[i];
		}
		
		int maxSum = sums[0];
		for (int i = 0; i < M; i++) {
			maxSum = Math.max(maxSum, sums[i]);
		}
		System.out.println(maxSum);
	}

}
