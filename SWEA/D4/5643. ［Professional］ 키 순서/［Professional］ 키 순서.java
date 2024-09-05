import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static int N, M;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static boolean[] visited2;
	public static int[][] degrees;
	public static int answer;
	
	public static void dfs(int cnt) {
		for (int next : graph[cnt]) {
			if (visited[next]) continue;
			visited[next] = true;
			answer++;
			dfs(next);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			graph = new ArrayList[N+1];
			degrees = new int[N+1][2];
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
			}
			
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				visited[i] = true;
				answer = 0;
				dfs(i);
				degrees[i][0] = answer;
				
				for (int j = 1; j <= N; j++) {
					if (i != j && visited[j]) {
						degrees[j][1] += 1;
					}
				}
			}
			
			int total = 0;
			for (int i = 1; i <= N; i++) {
				if (degrees[i][0] + degrees[i][1] == N-1) total++;
			}
			System.out.println("#" + t + " " + total);
		}
		
	}

}
