import java.util.*;
import java.io.*;

public class Main {
	public static int N, K, P, X;
	public static int answer;
	
	// ex) 0->0: 0번 변경, 0->1: 4번 변경 ....
	public static int[][] nums = {
			{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
			{4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
			{3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
			{3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
			{4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
			{3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
			{2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
			{3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
			{1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
			{2, 4, 3, 1, 2, 1, 2, 3, 1, 0},
	};
	
	
	public static void dfs(int depth, int cnt, int num) { // 현재 자릿수, 바꾼 횟수, 현재 숫자
		if (cnt > P || num > N) return;
		if (depth == K) {
			if (num <= 0 || cnt == 0) return; // 1층 이상, 1번 이상 바꿔야 함.
			answer++;
			return;
		}
		
		int tmp = (int)Math.pow(10, depth);
		
		for (int i = 0; i < 10; i++) {
			dfs(depth+1, cnt+nums[X/tmp%10][i], num+tmp*i);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 최대 층수
		K = Integer.parseInt(st.nextToken()); // 자릿수
		P = Integer.parseInt(st.nextToken()); // 최대 바꿀 갯수
		X = Integer.parseInt(st.nextToken()); // 현재층
		
		dfs(0, 0, 0);
		System.out.println(answer);
	}

}
