import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static int n, m;
	private static int a, b;
	
	private static void dfs(int node, int depth) {
		if (node == b) {
			System.out.println(depth);
			System.exit(0);
		}
			
		for (int cur : graph[node]) {
			if (!visited[cur]) {
				visited[node] = true;
				dfs(cur, depth+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		a = Integer.parseInt(tmp[0]);
		b = Integer.parseInt(tmp[1]);
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			tmp = br.readLine().split(" ");
			int p1 = Integer.parseInt(tmp[0]);
			int p2 = Integer.parseInt(tmp[1]);
			graph[p1].add(p2);
			graph[p2].add(p1);
		}
		
		visited[a] = true;
		dfs(a, 0);
		System.out.println(-1);
	}

}
