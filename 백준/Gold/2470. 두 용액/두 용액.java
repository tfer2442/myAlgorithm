import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		int answer = 2_000_000_001;
		int[] result = new int[2];
		
		while (left < right) {
			int tmp = arr[left] + arr[right];
			
			if (answer > Math.abs(tmp)) {
				answer = Math.abs(tmp);

				result[0] = arr[left];
				result[1] = arr[right];
			}
			
			if (tmp == 0) {
				result[0] = arr[left];
				result[1] = arr[right];
				break;
			} else if (tmp > 0) {
				right--;
			} else if (tmp < 0) {
				left++;
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
	}

}
