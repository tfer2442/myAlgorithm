import java.util.*;
import java.io.*;

/*
 * 다시 풀어보기
 * 42분 02초
 * 
 * 경우의 수를 모두 손으로 직접 그려보는게 도움이 될 것
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		Arrays.fill(dp, 0);
		
		dp[0] = 3;
		dp[1] = 7;
		
		for (int i = 2; i < N; i++) {
			dp[i] = (2*dp[i-1] + dp[i-2]) % 9901;
		}
		
		System.out.println(dp[N-1]);
		
	}
}
