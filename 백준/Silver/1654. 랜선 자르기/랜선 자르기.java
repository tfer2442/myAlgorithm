import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int K, N;
	public static int[] arr;
	
	static long calculate(long mid) {
		long cnt = 0;
		
		for (int i = 0; i < K; i++) {
			cnt += arr[i] / mid;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		K = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);
		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long left = 1;
		long right = 0;
		
		for (int i = 0; i < K; i++) {
			right = Math.max(right, arr[i]);
		}
		
		long mid = 0;
		long answer = 0;
		
		while (left <= right) {
			mid = (left+right)/2;
			long result = calculate(mid);
			
			if (result < N) {
				right = mid - 1;
			} else {
				left = mid + 1;
				answer = Math.max(answer, mid);
			}
		}
		System.out.println(answer);
	}
}
