import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int N;
	public static ArrayList<Integer>[] graph;
	public static int[][] dp;
	
	public static void dfs(int cur, int parent) {
		dp[cur][0] = 0;
		dp[cur][1] = 1;
		
		for (int next : graph[cur]) {
			if (next != parent) {
				dfs(next, cur);
				dp[cur][0] += dp[next][1];
				dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		dp = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.valueOf(tmp[0]);
			int b = Integer.valueOf(tmp[1]);
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1, -1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
}
