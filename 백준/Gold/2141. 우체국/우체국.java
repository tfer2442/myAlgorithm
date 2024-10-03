import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] nums;
	public static long sum = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nums[i][0] = a;
			nums[i][1] = b;
			
			sum += b;
		}
		
		Arrays.sort(nums, (o1, o2) -> {
			return o1[0]-o2[0];
		});
		
		long median = (sum+1)/2;
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			answer += nums[i][1];
			
			if (answer >= median) {
				System.out.println(nums[i][0]);
				break;
			}
		}
	}
}
