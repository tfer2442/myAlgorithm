import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] rate;
	public static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1 ,0}};
	public static boolean[][] visited;
	public static double answer = 0;
	
	public static void dfs(int depth, int r, int c, double curRate) {
		if (depth >= N) {
			answer += curRate;
			return;
		}
				
		for (int i = 0; i < 4; i++) {
			if (rate[i] == 0) continue;
			
			int nextR = r + d[i][0];
			int nextC = c + d[i][1];
			
			if (visited[nextR][nextC]) continue;
			visited[nextR][nextC] = true;
			dfs(depth+1, nextR, nextC, curRate * (rate[i]/100.0));
			visited[nextR][nextC] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		rate = new int[4];
		
		for (int i = 0; i < 4; i++) {
			rate[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[2*N+1][2*N+1];
		visited[N][N] = true;
		dfs(0, N, N, 1);
		System.out.println(answer);
	}
}
