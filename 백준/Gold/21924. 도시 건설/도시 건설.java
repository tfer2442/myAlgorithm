import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<int[]>[] graph;
	public static PriorityQueue<int[]> pq;
	public static boolean[] visited;
	public static long total = 0;
	public static long mst = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
			total += c;
		}
		
		visited = new boolean[N+1];
		pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		
		pq.add(new int[] {1, 0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (visited[node[0]]) continue;
			visited[node[0]] = true;
			mst += node[1];
			
			for (int[] next : graph[node[0]]) {
				if (!visited[next[0]]) {
					pq.add(next);
				}
			}
		}
		
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {
				flag= true;
				break;
			}
		}
		
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(total-mst);
		}
	}
}
