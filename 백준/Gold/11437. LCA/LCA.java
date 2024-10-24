import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static ArrayList<Integer>[] graph;
	public static int[] degrees;
	public static int[] parents;
	public static boolean[] visited;
	public static int[] depths;
	public static ArrayDeque<Integer> dq;

	public static void dfs(int cur, int depth) {
		depths[cur] = depth;

		for (int next : graph[cur]) {
			if (next != parents[cur]) {
				dfs(next, depth + 1);
			}
		}
	}

	public static int lca(int a, int b) {
		if (depths[a] > depths[b]) {
			while (depths[a] != depths[b]) {
				a = parents[a];
			}
		} else {
			while (depths[a] != depths[b]) {
				b = parents[b];
			}
		}

		while (a != b) {
			a = parents[a];
			b = parents[b];
		}
		
		return a;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		parents = new int[N + 1];
		degrees = new int[N + 1];
		visited = new boolean[N + 1];
		depths = new int[N + 1];
		dq = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			degrees[a]++;
			degrees[b]++;
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 2; i <= N; i++) {
			if (degrees[i] == 1) {
				dq.add(i);
			}
		}

		while (!dq.isEmpty()) {
			int node = dq.poll();
			visited[node] = true;

			for (int next : graph[node]) {
				degrees[next]--;

				if (!visited[next]) {
					parents[node] = next;

					if (degrees[next] == 1 && next != 1) {
						dq.add(next);
					}
				}
			}
		}

		int m = Integer.parseInt(br.readLine());
		dfs(1, 0);

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(lca(a, b)).append("\n");
		}

		System.out.println(sb);

	}

}
