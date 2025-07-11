import java.util.*;
import java.io.*;

public class Main {
	public static int T;
	public static int N, K;
	public static int[] nums;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int closedValue = 1_000_000_000;
			int answer = 0;
			
			for (int i = 0 ; i < N-1; i++) {
				int left = i + 1;
				int right = N - 1;
				
				while (left <= right) {
					int mid = (left+right)/2;
					
					int value = nums[i] + nums[mid];
					int tmp = Math.abs(K-value);
					
					if (closedValue > tmp) {
						closedValue = tmp;
						answer = 1;
					} else if (closedValue == tmp){
						answer++;
					}

					if (value < K) {
						left = mid + 1;
					} else if (value > K) {
						right = mid - 1;
					} else {
						break;
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}
