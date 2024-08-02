import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, M;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		arr = new int[N];
		long maxValue = -1;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxValue = Math.max(maxValue, arr[i]);
		}
		
		long left = maxValue;
		long right = 2_000_000_000L;
		long minValue = right;
		
		while (left <= right) {
			long mid = (left+right) / 2;
			long myMoney = mid;
			int cnt = 1;
			
			for (int i = 0; i < N; i++) {
				if (myMoney >= arr[i]) {
					myMoney -= arr[i];
				} else {
					myMoney = mid;
					myMoney -= arr[i];
					cnt++;
				}
			}
			
			if (cnt > M) {
				left = mid + 1;
			} else {
				right = mid -1;
				minValue = Math.min(minValue, mid);
			}
		}
		System.out.println(minValue);
	}
}
