import java.util.*;
import java.io.*;


public class Solution {
	public static int T, answer;

	public static void perm(int depth, int leftSum, int rightSum, int N, int[] nums, boolean[] visited) {
		if (depth >= N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				
				perm(depth+1, leftSum+nums[i], rightSum, N, nums, visited);
				if (leftSum >= rightSum+nums[i]) {
					perm(depth+1, leftSum, rightSum+nums[i], N, nums, visited);
				}
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] nums;
		int N;
		boolean[] visited;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = 0;
			perm(0, 0, 0, N, nums, visited);
			
			System.out.println("#" + t + " " + answer);
		}
		
	}

}
