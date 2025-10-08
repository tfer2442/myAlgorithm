import java.util.*;
import java.io.*;

/*
 * N: 도시의 개수, M: 도로의 개수, K: 거리 정보, X: 출발 도시 번호
 * 최단 거리 K 도시가 하나도 없다면 -1 출력
 * 모든 거리는 1
 * 
 *  BFS 문제
 */
public class Main {
	public static int N, M, K, X;
	public static int INF = 1_000_000_000;
	public static ArrayList<Integer>[] graph;
	public static int[] distance;
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void bfs() {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		dq.add(X);
		
		while (!dq.isEmpty()) {
			int node = dq.poll();
			
			for (int next : graph[node]) {
				if (distance[next] > distance[node] + 1) {
					distance[next] = distance[node] + 1;
					dq.add(next);
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
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
		}
		
		distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[X] = 0;
		bfs();
		
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K) {
				answer.add(i);
			}
		}
		
		if (answer.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int node : answer) {
			sb.append(node).append("\n");
		}
		
		System.out.println(sb);
	}

}
