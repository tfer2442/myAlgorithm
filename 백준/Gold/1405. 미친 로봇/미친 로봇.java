import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] rate;
	public static double answer;
	public static boolean[][] visited;
	public static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void dfs(int r, int c, int depth, double value) {
		if (N == depth) {
			answer += value;
			
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + d[i][0];
			int nextC = c + d[i][1];
			
			if (rate[i] == (double)0) continue;
			if (visited[nextR][nextC]) continue;
			
			visited[nextR][nextC] = true;
			dfs(nextR, nextC, depth+1, value*rate[i]/100);
			visited[nextR][nextC] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		rate = new int[4];
		visited = new boolean[30][30];
		
		for (int i = 0; i < 4; i++) {
			rate[i] = Integer.parseInt(st.nextToken());
		}
		
		visited[15][15] = true;
		dfs(15, 15, 0, 1);
		
		System.out.println(answer);
	}

}
