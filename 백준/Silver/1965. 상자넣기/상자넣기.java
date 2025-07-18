import java.util.*;
import java.io.*;

/*
 * 오름차순 배열 중 가장 긴 배열을 찾는 문제
 * 상자의 개수 1 <= N <= 1,000 -> O(N^3) 까지 가능
 * 반복문으로 배열을 차례대로 순회하며, 현재 인덱스 이전의 값 중에
 * 자신보다 작은 숫자인 값의 dp 배열의 최대 값 + 1을 dp[현재인덱스] 저장
 * dp 배열의 최대 값이 정답
 */
public class Main {
	public static int N;
	public static int[] boxes, dp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		boxes = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
				
		dp[0] = 1;
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (boxes[i] > boxes[j]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += 1;
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
