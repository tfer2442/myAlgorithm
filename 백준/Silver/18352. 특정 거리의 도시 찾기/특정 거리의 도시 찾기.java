import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K, X;
	public static ArrayList<int[]>[] graph;
	public static int[] distance;
	public static PriorityQueue<Node> pq;
	
	public static class Node {
		int value;
		int v;
		
		public Node(int v, int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.v = v;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시 갯수
		M = Integer.parseInt(st.nextToken()); // 도로 갯수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시
		graph = new ArrayList[N+1];
		distance = new int[N+1];
		pq = new PriorityQueue<>((o1, o2) -> o1.value-o2.value);
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, 1});
		}
		
		for (int i = 0; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[X] = 0;
		pq.add(new Node(X, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			if (node.value > distance[node.v]) continue;
			
			for (int[] nextNode : graph[node.v]) {
				if (distance[nextNode[0]] > distance[node.v] + nextNode[1]) {
					distance[nextNode[0]] = distance[node.v] + nextNode[1];
					pq.add(new Node(nextNode[0], distance[nextNode[0]]));
				}
			}
		}
		
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if (!flag) {
			System.out.println(-1);
		}
	}

}
