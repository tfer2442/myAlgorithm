import java.util.*;
import java.io.*;

public class Solution {
	public static int T, M;
	public static ArrayList<Integer>[] graph;
	
	public static int bfs() {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[100];

		dq.add(0);
		visited[0] = true;
		
		while (!dq.isEmpty()) {
			int node = dq.poll();
			
			for (int next : graph[node]) {
				if (!visited[next]) {
					visited[next] = true;
					dq.add(next);
				}
			}
		}
		
		if (visited[99]) {
			return 1;
		}
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[100];
			
			for (int i = 0; i < 100; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
			}
			
			int answer = bfs();
			System.out.println("#" + T + " " + answer);			
		}

	}
}
