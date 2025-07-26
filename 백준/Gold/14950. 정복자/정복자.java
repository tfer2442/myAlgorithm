import java.util.*;
import java.io.*;

/*
 * 양방향 도로
 * 도시 번호 : N, 처음 점거 도시는 1번 도시
 * 도로의 개수 : M
 * 1 <= N <= 10,000, 1 <= M <= 30,000
 * 한 점에서 시작하는 MST 문제 (Prim)
 * 두 노드 사이에 중복간선을 생각해야 함
 */
public class Main {
	public static int N, M, t;
	public static ArrayList<int[]>[] graph;
	public static boolean[] visited;
	public static int[] minEdge;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		minEdge = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			minEdge[i] = 1_000_000;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});
		
		int answer = 0;
		int cnt = 0;
		
		minEdge[1] = 0;
		pq.add(new int[] {1, 0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (visited[node[0]]) continue;
			
			visited[node[0]] = true;
			answer += node[1];
			cnt++;
			
			if (cnt == N) break;
			
			for (int[] nextNode : graph[node[0]]) {
				if (!visited[nextNode[0]] && minEdge[nextNode[0]] > nextNode[1]) {
					minEdge[nextNode[0]] = nextNode[1];
					pq.add(new int[] {nextNode[0], nextNode[1]});
				}
			}
		}
		
		System.out.println(answer + ((N-2) * (N -1) / 2) * t);
	}
}
