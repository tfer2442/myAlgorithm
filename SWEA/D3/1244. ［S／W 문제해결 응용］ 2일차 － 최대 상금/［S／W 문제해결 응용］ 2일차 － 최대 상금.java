import java.util.*;
import java.io.*;

public class Solution {
	public static int T, C;
	public static char[] nums;
	public static HashSet<String> hs;
	public static int answer = 0;
	
	public static void dfs(int depth) {
		if (depth == C) {
			answer = Math.max(answer, Integer.parseInt(new String(nums)));
			return;
		}
		
		String cur = new String(nums) + "," + "0";
		
		if (hs.contains(cur)) return;
		hs.add(cur);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				char tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				
				dfs(depth+1);
				
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;			
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			nums = st.nextToken().toCharArray();
			C = Integer.parseInt(st.nextToken());
			
			answer = 0;
			System.out.print("#" + t + " ");
			hs = new HashSet<>();
			dfs(0);
			System.out.println(answer);
		}
	}
}
