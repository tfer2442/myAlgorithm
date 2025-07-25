import java.util.*;
import java.io.*;

/*
 * 1. 순서를 조정한다는 것에 집중 X
 * 2. 연결 그래프에서 s와 t의 최소 거리 구하는 문제
 * 3. 다익스트라 알고리즘으로 해결 가능
 */
public class Main {
	public static int N, M, S, T;
	public static ArrayList<int[]>[] graph;
	public static int[] distance;
	
	public static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});
		
		pq.add(new int[] {S, 0});
		
		while (!pq.isEmpty()) { 
			int[] node = pq.poll();
			int cur = node[0];
			int value = node[1];
			
			if (distance[cur] < value) continue;
			for (int[] nextNode : graph[cur]) {
				int next = nextNode[0];
				int nextValue = nextNode[1];
				
				if (distance[cur] + nextValue < distance[next]) {
					distance[next] = distance[cur] + nextValue;
					pq.add(new int[] {next, distance[next]});
				} 
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		distance = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = 1_000_000_000;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		distance[S] = 0;
		
		dijkstra();
		
		System.out.println(distance[T]);
	}
}
