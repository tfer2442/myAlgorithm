import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, K;
	public static int[] arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);
		arr = new int[N];
		
		long right = -1;
		long total = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
			right = Math.max(right, arr[i]);
		}
		
		if (total < N) {
			System.out.println(0);
			System.exit(0);
		}
		
		long left = 1;
		long maxValue = 0;
		
		while (left <= right) {
			long mid = (left+right)/2;
			long cnt = 0;
			
			for (int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}
			
			if (K <= cnt) {
				left = mid + 1;
				maxValue = Math.max(maxValue, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(maxValue);
	}

}
