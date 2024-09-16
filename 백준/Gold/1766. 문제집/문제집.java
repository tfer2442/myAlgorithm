import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] inDegrees;
	public static ArrayList<Integer>[] graph;
	public static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegrees = new int[N+1];
		graph = new ArrayList[N+1];
		pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegrees[b]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) {
				pq.add(i);
			}
		}
		
		while (!pq.isEmpty()) {
			int node = pq.poll();
			
			System.out.print(node + " ");
			
			for (int next : graph[node]) {
				if (--inDegrees[next] == 0) {
					pq.add(next);
				}
			}
		}
	}

}
