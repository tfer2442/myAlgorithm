import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static PriorityQueue<Node> pq;
	public static ArrayList<Node>[] graph;
	public static int[] distance;
	public static int N, E;
	public static int SA, SB, AB, BA, AE, BE;
	public static int a, b;
	
	static class Node {
		int v;
		int cost;
	
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	
	public static void dijkstra(int start, char f) {
		for (int i = 0; i < N+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int curV = node.v;
			int curCost = node.cost;
			
			if (distance[curV] < curCost) continue;
			
			for (Node nextNode : graph[curV]) {
				int nextV = nextNode.v;
				int nextCost = nextNode.cost;
				
				if (distance[nextV] > distance[curV] + nextCost) {
					distance[nextV] = distance[curV] + nextCost;
					pq.add(new Node(nextV, distance[nextV]));
				} 
			}
		}
		
		if (f == 's') {
			SA = distance[a];
			SB = distance[b];
		} else if (f == 'a') {
			AB = distance[b];
			AE = distance[N];
		} else if (f == 'b') {
			BA = distance[a];
			BE = distance[N];
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		graph = new ArrayList[N+1];
		distance = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			distance[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph[x].add(new Node(y, z));
			graph[y].add(new Node(x, z));
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		dijkstra(1, 's');
		dijkstra(a, 'a');
		dijkstra(b, 'b');
		long answer = Integer.MAX_VALUE;
		
		if (SA != Integer.MAX_VALUE && AB != Integer.MAX_VALUE && BE != Integer.MAX_VALUE) {
			answer = SA + AB + BE;
		}
		
		if (SB != Integer.MAX_VALUE && BA != Integer.MAX_VALUE && AE != Integer.MAX_VALUE) {
			answer = Math.min(answer, SB+BA+AE);
		}
		
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.println(answer);
	}

}
