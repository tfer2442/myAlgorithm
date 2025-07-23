import java.util.*;
import java.io.*;

/*
 * 다익스트라 문제
 * 1번에서 시작, V1에서 시작, V2에서 시작하는 3번의 다익스트라
 * 1→V1→V2→N, 1→V2→V1→N 중에 짧은게 답. 만약 안 이어진다면 -1
 */
public class Main {
	public static int N, E;
	public static int V1, V2;
	public static ArrayList<int[]>[] graph;
	public static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[]{b, weight});
			graph[b].add(new int[]{a, weight});
		}
		
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		
		// 1번에서 시작하는 다익스트라
		int[] distFrom1 = dijkstra(1);
		// V1에서 시작하는 다익스트라  
		int[] distFromV1 = dijkstra(V1);
		// V2에서 시작하는 다익스트라
		int[] distFromV2 = dijkstra(V2);
		
		// 경로가 존재하지 않는 경우 체크
		if (distFrom1[V1] == INF || distFrom1[V2] == INF || 
			distFromV1[V2] == INF || distFromV2[N] == INF || distFromV1[N] == INF) {
			System.out.println(-1);
			return;
		}
		
		// 1→V1→V2→N 경로
		long path1 = (long)distFrom1[V1] + distFromV1[V2] + distFromV2[N];
		// 1→V2→V1→N 경로
		long path2 = (long)distFrom1[V2] + distFromV2[V1] + distFromV1[N];
		
		long answer = Math.min(path1, path2);
		
		System.out.println(answer);
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		dist[start] = 0;
		pq.offer(new int[]{start, 0});
		
		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int currentNode = current[0];
			int currentDist = current[1];
			
			if (currentDist > dist[currentNode]) continue;
			
			for (int[] edge : graph[currentNode]) {
				int nextNode = edge[0];
				int nextWeight = edge[1];
				int nextDist = currentDist + nextWeight;
				
				if (nextDist < dist[nextNode]) {
					dist[nextNode] = nextDist;
					pq.offer(new int[]{nextNode, nextDist});
				}
			}
		}
		
		return dist;
	}
}