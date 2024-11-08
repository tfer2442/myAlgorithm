import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] nums;
	public static ArrayDeque<Integer> dq;
	public static int[] answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dq = new ArrayDeque<>();
		answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			answer[i] = -1;
		}
		
		dq.push(nums[N-1]);
		
		for (int i = N-2; i >= 0; i--) {
			while (true) {
				if (dq.isEmpty()) {
					dq.push(nums[i]);
					answer[i] = -1;
					break;
				}
				
				if (dq.peek() > nums[i]) {
					answer[i] = dq.peek();
					dq.push(nums[i]);
					break;
				} else {
					dq.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

}
