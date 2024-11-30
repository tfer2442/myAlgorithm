import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static List<int[]> graph[];
	public static PriorityQueue<int[]> pq;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if (N == 0 && M == 0) break;
			
			graph = new ArrayList[N];	
			int total = 0;
			int mst = 0;
			
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				graph[start].add(new int[] {end, value});
				graph[end].add(new int[] {start, value});
				total += value;
			}
			
			visited = new boolean[N];
			pq = new PriorityQueue<>((o1, o2) -> {
				return o1[1] - o2[1];
			});
			
			pq.add(new int[] {0, 0});
			int cnt = 0;
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				if (visited[cur[0]]) continue;
				visited[cur[0]] = true;
				mst += cur[1];
				cnt++;
				
				if (cnt == N) break;
				
				for (int[] next : graph[cur[0]]) {
					if (visited[next[0]]) continue;
					pq.add(next);
				}
			}
			
			System.out.println(total-mst);
		}
	}
}
