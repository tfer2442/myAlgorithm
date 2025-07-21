import java.util.*;
import java.io.*;

/*
 * 전형적인 냅색 문제 (DP)
 * 만약, 부분집합으로 풀었다면 N이 100이므로 2**100 이라, 시간초과 발생함
 * 무게 별로 최대의 가치 값을 구하는 것이 핵심
 * 배열의 뒤부터 DP를 채워넣으면, 일차원 배열로도 해결 가능
 * dp[i] = max(dp[i-현재물건무게] + 현재물건가치, dp[i]);
 * ArrayOfBounds 문제가 안 생기도록 해야 함
 */
public class Main {
	public static int N, K;
	public static int[] dp;
	public static int[][] things;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		things = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= things[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j-things[i][0]]+things[i][1]);
			}
		}
		
		System.out.println(dp[K]);
	}
}
