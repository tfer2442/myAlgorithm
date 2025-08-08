import java.util.*;
import java.io.*;

/*
 * 다시 풀기
 * 
 * BFS를 통해서, 이분 그래프를 찾을 수 있음
 * O(V+E)
 * 
 * 유니온 파인드 문제 XXXXXXXXXXX
 * parents 배열의 인덱스와 가지고 있는 값이 같은 갯수가 곧 집합의 갯수 XXXXXXXXXX
 * 
 * 문제를 착각했음. 애초에 갈라져있는 그래프가 2개인지를 판별하는 문제가 아니었음. XXX
 * 가장 연결되어있는 정점이 많은 것을 구하고, 이를 자르면 되겠다. XXXX
 * 
 * 문제를 또 착각했음.
 */
public class Main {
	public static int T;
	public static int V, E;
	public static ArrayList<Integer>[] graph;
	public static int[] colors;
	public static boolean isBipartiteGraph;
	
	public static void bfs(int start) {
		colors[start] = 1;
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(start);
		
		while (!dq.isEmpty()) {
			int node = dq.poll();
			
			for (int next : graph[node]) {
				if (colors[next] == colors[node]) {
					isBipartiteGraph = false;
					return;
				}
				
				if (colors[next] == 0) {
					dq.add(next);
					colors[next] = colors[node] * (-1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			colors = new int[V+1];
			graph = new ArrayList[V+1];
			
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}

			isBipartiteGraph = true;
			for (int i = 1; i <= V; i++) {
				
				if (colors[i] == 0) {
					bfs(i);
					
					if (!isBipartiteGraph) {
						break;
					}
				}
			}
			
		    System.out.println(isBipartiteGraph ? "YES" : "NO");

		}
	}

}
