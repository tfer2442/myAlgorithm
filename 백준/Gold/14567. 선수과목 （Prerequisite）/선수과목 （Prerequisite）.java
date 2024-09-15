import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] inDegrees;
	public static ArrayList<Integer>[] graph;
	public static ArrayDeque<int[]> dq;
	public static int[] results;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegrees = new int[N+1];
		graph = new ArrayList[N+1];
		dq = new ArrayDeque<>();
		results = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegrees[b]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) {
				dq.add(new int[] {i, 1});
			}
		}
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			results[node[0]] = node[1];
			
			for (int next : graph[node[0]]) {
				inDegrees[next]--;
				if (inDegrees[next] == 0) {
					dq.add(new int[] {next, node[1]+1});
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(results[i] + " ");
		}
	}

}
