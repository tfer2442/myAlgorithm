import java.util.*;
import java.io.*;

public class Main {
	public static int T;
	public static int N, M, K;
	public static int[] nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int end = M-1;
			int answer = 0;
			int sum = 0;
			
			for (int i = 0; i < M; i++) {
				sum += nums[i];
			}
			
			if (N == M) {
				if (sum < K) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				continue;
			}
			
			for (int start = 0; start < N; start++) {
				if (sum < K) {
					answer++;
				}
				
				sum -= nums[start];
				end = (end + 1) % N;
				sum += nums[end];
			}
			System.out.println(answer);
		}
	}

}
