import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, S;
	public static int[] nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = 0; i < N-1; i++) {
			if (cnt >= S) break; 
			
			int maxValue = 0;
			int index = -1;
			
			for (int j = i+1; j < i+1+S-cnt && j < N; j++) {
				if (nums[i] < nums[j] && maxValue < nums[j]) {
					maxValue = nums[j];
					index = j;
				}
			}
			
			if (index == -1) continue;
			
			for (int j = index; j > i; j--) {
				nums[j] = nums[j-1];
			}
			nums[i] = maxValue;
			cnt += index-i;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
