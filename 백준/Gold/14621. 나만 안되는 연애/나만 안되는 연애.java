import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[] schools;
	public static boolean[] visited;
	public static ArrayList<int[]>[] graph;
	public static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		schools = new char[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			schools[i] = st.nextToken().charAt(0);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, value});
			graph[b].add(new int[] {a, value});
		}
		
		pq.add(new int[] {1, 0});
		int total = 0;
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (visited[node[0]]) continue;
			
			visited[node[0]] = true;
			total += node[1];
			
			for (int[] next : graph[node[0]]) {
				if (!visited[next[0]] && schools[next[0]] != schools[node[0]]) {
					pq.add(next);
				}
			}
		}
		
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				flag = true;
				break;
			}
		}
		
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(total);
		}
	}
}
