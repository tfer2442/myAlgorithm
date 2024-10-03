import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] inDegrees;
	public static int[] result;
	public static int[] time;
	public static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		inDegrees = new int[N+1];
		result = new int[N+1];
		time = new int[N+1];
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			while (true) {
				int v = Integer.parseInt(st.nextToken());
				if(v == -1) break;
				
				inDegrees[i]++;
				graph[v].add(i);
			}
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) {
				dq.add(i);
				result[i] = time[i];
			}
		}
		
		while (!dq.isEmpty()) {
			int node = dq.poll();
			
			for (int next : graph[node]) {
				inDegrees[next]--;
				result[next] = Math.max(result[next], result[node] + time[next]);
				
				if (inDegrees[next] == 0) {
					dq.add(next);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}
