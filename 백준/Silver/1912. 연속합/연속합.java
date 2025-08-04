import java.util.*;
import java.io.*;

/*
 * 정수의 개수 : 1 <= n < 100_000
 * 슬라이딩 윈도우를 이용하여, 합이 음수가 되었을 때는 더하는 것을 멈추고
 * 다음숫자부터는 다시 센다.
 */
public class Main {
	public static int N;
	public static int answer;
	public static int[] nums;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = -1 * Integer.MAX_VALUE;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (nums[i] + sum <= 0) {
				sum = 0;
				answer = Math.max(answer, nums[i]);
				continue;
			}
			
			sum += nums[i];
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}
}
