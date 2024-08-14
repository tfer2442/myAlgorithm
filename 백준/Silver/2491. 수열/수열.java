import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static int[] dp1;
	public static int[] dp2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		dp1 = new int[N];
		dp2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp1[i] = 1;
			dp2[i] = 1;
		}
		
		int answer = 1;
		
		for (int i = 1; i < N; i++) {
			if (arr[i] >= arr[i-1]) {
				dp1[i] = dp1[i-1] + 1;
				answer = Math.max(dp1[i], answer);
			}
		}
		
		for (int i = 1; i < N; i++) {
			if (arr[i] <= arr[i-1]) {
				dp2[i] = dp2[i-1] + 1;
				answer = Math.max(dp2[i], answer);
			}
		}
		
		System.out.println(answer);
	}
}
