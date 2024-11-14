import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] nums;
	
	public static boolean solution(int mid) {
		int min = 10_000;
		int max = 0;
		int cnt = 1;
		
		for (int i = 0; i < N; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
			
			if (max-min <= mid) {
				continue;
			} else {
				min = nums[i];
				max = nums[i];
				cnt++;
			}
		}
		
		if (cnt <= M) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 10_000;
		int answer = 10_000;
		
		while (left <= right) {
			int mid = (left + right) / 2;

			if (solution(mid)) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
