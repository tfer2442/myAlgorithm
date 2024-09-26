import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static ArrayList<Integer>[] graph;
	public static int[] inDegrees;
	public static int[] values;
	public static int[] costs;
	public static ArrayDeque<int[]> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		inDegrees = new int[N+1];
		values = new int[N+1];
		costs = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			values[i] = value;
			
			for (int j = 0; j < cnt; j++) {
				int start = Integer.parseInt(st.nextToken());
				inDegrees[i]++;
				graph[start].add(i);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) {
				dq.add(new int[] {i, values[i]});
				costs[i] = values[i];
			}
		}
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int next : graph[node[0]]) {
				inDegrees[next]--;
				
				if (costs[next] < node[1]+values[next]) {
					costs[next] = node[1]+values[next];
				}
				if (inDegrees[next] == 0) {
					dq.add(new int[] {next, costs[next]});
				}
			}
		}
		
		int maxValue = -1;
		
		for (int i = 1; i <= N; i++) {
			if (costs[i] > maxValue) {
				maxValue = costs[i];
			}
		}
		
		System.out.println(maxValue);
	}
}
