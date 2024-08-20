import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	public static int n, m;
	public static ArrayList<int[]>[] graph;
	public static int[] distance;
	public static PriorityQueue<Node> pq;
	
	public static class Node {
		int v;
		int value;
		
		public Node(int v, int value) {
			this.v = v;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, value});
			graph[e].add(new int[] {s, value});
		}
		
		distance = new int[n+1];
		pq = new PriorityQueue<>((o1, o2) -> o1.value-o2.value);
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			if (distance[node.v] < node.value) continue;
			
			for (int[] nextNode : graph[node.v]) {
				int nextV = nextNode[0];
				int nextValue = nextNode[1];
				
				if (distance[nextV] > distance[node.v] + nextValue) {
					distance[nextV] = distance[node.v] + nextValue;
					pq.add(new Node(nextV, distance[nextV]));
				}
 			}
		}
		
		System.out.println(distance[end]);
	}

}
