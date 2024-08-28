import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int start, end;
	public static ArrayList<int[]>[] graph;
	public static PriorityQueue<int[]> pq;
	public static int[] weights;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
		weights = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, weight, a});
			graph[b].add(new int[] {a, weight, b});
		}
		

		for (int[] node : graph[start]) {
			pq.add(node);
		}
		
		if (!pq.isEmpty()) {
			weights[start] = pq.peek()[1];
		}
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (weights[node[0]] != 0) continue;
			weights[node[0]] = Math.min(node[1], weights[node[2]]);
			
			for (int[] next : graph[node[0]]) {
				if (weights[next[0]] == 0) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(weights[end]);
	}

}
