import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static boolean flag;
	
	public static void dfs(int cnt, int depth) {
		if (flag || depth >= 4) {
			flag = true;
			return;
		}
		
		visited[cnt] = true;
		for (int d : graph[cnt]) {
			if (!visited[d]) {
				dfs(d, depth+1);
			}
		}
		visited[cnt] = false;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
			if (flag) break;
		}
		
		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
