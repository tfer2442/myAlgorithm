import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] nums;
	public static int[] answer;
	public static ArrayDeque<int[]> dq = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		answer = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			while (true) {
				if (dq.isEmpty()) {
					dq.push(new int[] {nums[i], i});
					answer[i] = 0;
					break;
				}
				
				if (dq.peek()[0] > nums[i]) {
					answer[i] = dq.peek()[1] + 1;
					dq.push(new int[] {nums[i], i});
					break;
				}
				
				dq.pop();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}	

}
