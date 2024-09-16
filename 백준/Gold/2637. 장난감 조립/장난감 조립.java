import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] inDegrees;
	public static ArrayList<int[]>[] graph;
	public static int[] results;
	public static int[][] dp;
	public static boolean[] visited;
	
	public static void dfs(int prev, int node, int value) {
		if (inDegrees[node] == 0) {
			dp[node][prev] += value;
			return;
		}
		
		for (int[] next : graph[node]) {
			if (!visited[next[0]]) {
				dfs(node, next[0], next[1]);
			}
			
			for (int j = 1; j < N; j++) {
				dp[j][node] += dp[j][next[0]] * next[1];  
			}
		}
		visited[node] = true;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		inDegrees = new int[N+1];
		results = new int[N+1];
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, v});
			inDegrees[a]++;
		}

		dp = new int[N+1][N+1];
		visited = new boolean[N+1];
		dfs(0, N, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			if (inDegrees[i] == 0) {
				sb.append(i).append(" ").append(dp[i][N]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
