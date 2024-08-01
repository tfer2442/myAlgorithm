import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n, k;
	public static int[] arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			n = Integer.parseInt(tmp[0]);
			k = Integer.parseInt(tmp[1]);
			tmp = br.readLine().split(" ");
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			Arrays.sort(arr);
			
			int closeCnt = 0;
			long closeValue = Integer.MAX_VALUE; 

			for (int i = 0; i < n-1; i++) {
				int left = i+1;
				int right = n-1;
						
				while (left <= right) {
					int mid = (left + right) / 2;
					long result = arr[mid] + arr[i];
					
					if (closeValue > Math.abs(result-k)) {
						closeValue = Math.abs(result-k);
						closeCnt = 1;
					} else if (closeValue == Math.abs(result-k)) {
						closeCnt += 1;
					}
					
					if (result < k) {
						left = mid + 1;
						
					} else if (result > k) {
						right = mid - 1;
					} else if (result == k) {
						break;
					}
				}
			}
			System.out.println(closeCnt);
		}

	}

}
