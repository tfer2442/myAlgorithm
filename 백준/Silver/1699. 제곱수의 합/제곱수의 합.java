import java.util.*;
import java.io.*;


/* 각 숫자들의 항의 최소 개수를 배열에 저장하고, 이후 배열에서 활용
 * 현재 위치의 숫자에 -1, -4, -9 ... 제곱수들을 빼보며 최소값 + 1이 현재 배열의 값
 * 루트로 떨어진다면 항의 최소 개수는 1
 * 
 */
public class Main {
	public static int N;
	public static int[] dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			int target = Integer.MAX_VALUE;
			
			for (int j = 1; i-j*j >= 0 ; j++) {
				target = Math.min(dp[i-j*j], target);
			}
			dp[i] = target+1;
		}
		
		System.out.println(dp[N]);
	}
}
