import java.util.*;
import java.io.*;

/*
 * 학생 N명, X마을에서 파티
 * M개의 단방향 도로
 * 플로이드 와샬로 풀면 시간초과 가능성 O(N^3)
 * 다익스트라로 풀어야겠다? 그래도 시간초과ㅣ 날 거 같은데 X
 * 다익스트라의 시간복잡도는 ElogV ,, E가 V^2보다 훨씬 작으므로 괜찮네
 */
public class Main {
	public static int N, M, X;
	public static ArrayList<int[]>[] graph;
	public static int[] distanceFromX;

	public static int dijkstra(int s) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, 1_000_000_000);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});
		
		distance[s] = 0;
		pq.add(new int[] {s, 0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (node[1] > distance[node[0]]) {
				continue;
			}
			
			for (int[] nextNode : graph[node[0]]) {
				int nextValue = nextNode[1] + distance[node[0]];
				
				if (nextValue < distance[nextNode[0]]) {
					distance[nextNode[0]] = nextValue;
					pq.add(new int[] {nextNode[0], nextValue});
				}
			}
		}
		
		if (s == X) {
			distanceFromX = distance;
		}
		
		return distance[X];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
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
		}
		
		int[] distance = new int[N+1];
		for (int i = 1; i <= N; i++) {
			distance[i] = dijkstra(i);
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, distance[i] + distanceFromX[i]);
		}
		
		System.out.println(answer);
	}
}
