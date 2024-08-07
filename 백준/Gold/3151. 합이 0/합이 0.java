import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int N;
	public static int[] arr;
	
	static int lowerBS(int left, int twoSum) {
		int right = N-1;
		int result = -1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] + twoSum > 0) {
				right = mid - 1;
			} else if (arr[mid] + twoSum < 0) {
				left = mid + 1;
			} else if (arr[mid] + twoSum == 0){
				right = mid - 1;
				result = mid;
			}
		}
		
		return result;
	}
	
	static int upperBS(int left, int twoSum) {
		int right = N-1;
		int result = -1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] + twoSum > 0) {
				right = mid - 1;
			} else if (arr[mid] + twoSum < 0) {
				left = mid + 1;
			} else if (arr[mid] + twoSum == 0){
				left = mid + 1;
				result = mid;
			}
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		
		if (N <= 2) {
			System.out.println(0);
			System.exit(0);
		}
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(arr);
		
		long answer = 0;
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				int l = lowerBS(j+1, arr[i]+arr[j]);
				int r = upperBS(j+1, arr[i]+arr[j]);
				if (l == -1) {
					continue;
				}
				answer += r-l+1;
			}
		}
		System.out.println(answer);
		
	
	}
}
