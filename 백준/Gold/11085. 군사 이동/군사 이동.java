import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] graph = new ArrayList[p];
		int[][] distance = new int[p][p];
		
		for (int i = 0; i < p; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, value});
			graph[b].add(new int[] {a, value});
			distance[a][b] = Math.max(distance[a][b], value);
			distance[b][a] = Math.max(distance[b][a], value);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o2[1] - o1[1];
		});
		
		pq.add(new int[] {c, 0, -1});
		boolean[] visited = new boolean[p];
		
		ArrayList<Integer>[] path = new ArrayList[p];
		
		path[c] = new ArrayList<>();
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int vertex = node[0];
			int value = node[1];
			int prev = node[2];
			
			if (visited[vertex]) continue;
			visited[vertex] = true;
			
			if (vertex != c) {
				path[vertex] = new ArrayList<>();
				path[vertex].add(prev);
				
				for (int a : path[prev]) {
					path[vertex].add(a);
				}
			}
			
			for (int[] nextNode : graph[vertex]) {
				int nextVertex = nextNode[0];
				int nextValue = nextNode[1];
				
				if (visited[nextVertex]) continue;
				pq.add(new int[] {nextVertex, nextValue, vertex});
			}
		}
				
		int answer = Integer.MAX_VALUE;
		int cur = v;
		
		for (int i = 0; i < path[v].size(); i++) {
			answer = Math.min(answer, distance[cur][path[v].get(i)]);
			cur = path[v].get(i); 
		}
		
		System.out.println(answer);
	}
}
