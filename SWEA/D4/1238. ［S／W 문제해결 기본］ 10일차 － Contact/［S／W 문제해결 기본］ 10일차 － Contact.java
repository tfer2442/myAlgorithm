import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static int M;
	public static int start;
	public static HashSet<Integer>[] graph;
	public static boolean[] visited;
	public static ArrayList<int[]> results; 
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new HashSet[101];
			visited = new boolean[101];
			results = new ArrayList<>();
			
			for (int i = 1; i <= 100; i++) {
				graph[i] = new HashSet<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
			}

			ArrayDeque<int[]> dq = new ArrayDeque<>();
			dq.add(new int[] {start, 0});
			visited[start] = true;
			
			while (!dq.isEmpty()) {
				int[] node = dq.poll();
				results.add(node);
								
				for (int i : graph[node[0]]) {
					if (!visited[i]) {
						visited[i] = true;
						dq.add(new int[] {i, node[1]+1});
					}
				}
			}
			
			Collections.sort(results, (o1, o2) -> {
				if (o1[1] == o2[1]) {
					return o2[0]-o1[0];
				}
				return o2[1]-o1[1];
			});
			
			System.out.println("#" + t + " " + results.get(0)[0]);
		}
	
	}

}
