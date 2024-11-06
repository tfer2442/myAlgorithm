import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] nums;
	public static int answer = 0;
	
	public static long cal(int mid) {
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			int tmp = Math.min(nums[i], mid);
			sum += tmp;
		}
		
		return sum;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		int maxValue = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			maxValue = Math.max(maxValue, nums[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = maxValue;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			long v = cal(mid);
			
			if (v < M) {
				answer = mid;
				left = mid + 1;
			} else if (v > M){
				right = mid - 1;
			} else if (v == M){
				answer = mid;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
