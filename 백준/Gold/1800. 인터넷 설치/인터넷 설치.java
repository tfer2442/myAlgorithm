import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<int[]>[] graph;
	public static int N, P, K;
	
	public static boolean solution(int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1]-o2[1];
		});
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, 1_000_000_000);
		distance[1] = 0;
		pq.add(new int[] {1, 0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int vertex = node[0];
			int value = node[1];
			
			if (distance[vertex] < value) continue;
			
			for (int[] next : graph[vertex]) {
				int nVertex = next[0];
				int nValue = next[1];
				
				if (nValue > k && distance[nVertex] > distance[vertex] + 1) {
					distance[nVertex] = distance[vertex]+1;
					pq.add(new int[] {nVertex, distance[nVertex]});
				} else if (nValue <= k && distance[nVertex] > distance[vertex]) {
					distance[nVertex] = distance[vertex];
					pq.add(new int[] {nVertex, distance[nVertex]});
				}
			}
		}
		
		return distance[N] <= K;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int left = 0;
		int right = 0;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[s].add(new int[] {e, v});
			graph[e].add(new int[] {s, v});
			
			right = Math.max(right, v);
		}
		
		int answer = -1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (solution(mid)) {
				right = mid - 1;
				answer = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
