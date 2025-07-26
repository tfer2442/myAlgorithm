import java.util.*;
import java.io.*;

/*
 * s -> e 를 잇는 간선 중 최소값의 최대값을 구하는 문제
 * 집의 수 : 2 <= N <= 100,000
 * 다리 수 : 1 <= M <= 300,000
 * 무게제한 : 1 <= k <= 1,000,000
 * 프림을 변형해서, Maximum 으로 풀면 되지 않을까?
 */
public class Main {
	public static int N, M, s, e;
	public static ArrayList<int[]>[] graph;
	public static boolean[] visited;
	public static int[] maxEdge;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		maxEdge = new int[N+1];
		visited = new boolean[N+1];
		
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
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return -1 * (o1[1] - o2[1]);
		});
		
		maxEdge[s] = Integer.MAX_VALUE;
		pq.add(new int[] {s, Integer.MAX_VALUE});
		int answer = Integer.MAX_VALUE;
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int cur = node[0];
			int value = node[1];
			
			if (visited[cur]) continue;
			visited[cur] = true;
			answer = Math.min(answer, value);
			
			if (cur == e) {
				System.out.println(answer);
				return;
			}
			
			for (int[] nextNode : graph[cur]) {
				int next = nextNode[0];
				int nextValue = nextNode[1];
				
				if (!visited[next] && maxEdge[next] < nextValue) {
					maxEdge[next] = nextValue;
					pq.add(new int[] {next, nextValue});
				}
			}
		}
		
		System.out.println(0);
	}
}
