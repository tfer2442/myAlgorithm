import java.util.*;
import java.io.*;


public class Solution {
	public static int N;
	public static int[] heights;
	
	public static void solution() {
		int sum = 0;
		
		for (int i = 2; i < N-2; i++) {
			int left2 = i-2;
			int left1 = i-1;
			
			int leftHeight = Math.max(heights[i-2], heights[i-1]);
			int rightHeight = Math.max(heights[i+2], heights[i+1]);
			
			if (heights[i] <= leftHeight || heights[i] <= rightHeight) {
				continue;
			}
			
			int maxHeight = Math.max(leftHeight, rightHeight);
			sum += heights[i] - maxHeight;
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			heights = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.print("#" + t + " ");
			solution();
		}
	}
}
