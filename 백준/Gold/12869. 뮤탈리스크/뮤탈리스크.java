import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] scv;
	public static int[][][] dp;
	public static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
	public static int answer = Integer.MAX_VALUE;

	// scv의 현재 피를 인자로, 현재 몇 번째인지
	public static void dfs(int a, int b, int c, int depth) {
		if (a <= 0 && b <= 0 && c <= 0) {
			answer = Math.min(answer, depth);
			return;
		}
		
		for (int i = 0; i < 6; i++) {
			int nextA = Math.max(0, a-attack[i][0]);
			int nextB = Math.max(0, b-attack[i][1]);
			int nextC = Math.max(0, c-attack[i][2]);
			
			if (dp[nextA][nextB][nextC] <= depth+1) continue;
			
			dp[nextA][nextB][nextC] = depth+1;
			dfs(nextA, nextB, nextC, depth+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		scv = new int[3];
		
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[61][61][61];
		
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				for (int k = 0; k < 61; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		dp[scv[0]][scv[1]][scv[2]] = 0;
		
		dfs(scv[0], scv[1], scv[2], 0);
		
		System.out.println(answer);
	}
}
