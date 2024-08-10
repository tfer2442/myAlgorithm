import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int total = 0;
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		
		int left = 0;
		int sum = arr[0];
		int answer = Math.min(total-sum, sum);
		
		for (int right = 1; right < n; right++) {
			sum += arr[right];
			int a = Math.min(total-sum, sum);
			answer = Math.max(answer, a);
		
			while (sum > total-sum) {
				sum -= arr[left];
				left++;
				a = Math.min(total-sum, sum);
				answer = Math.max(answer, a);
			}
		}
		
		System.out.println(answer);
	}

}
