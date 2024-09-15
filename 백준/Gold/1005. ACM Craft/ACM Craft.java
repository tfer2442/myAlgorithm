import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int N, K, W;
	public static int[] inDegrees;
	public static ArrayList<Integer>[] graph;
	public static int[] costs;
	public static ArrayDeque<int[]> dq;
	public static int[] maxValues;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			inDegrees = new int[N+1];
			costs = new int[N+1];
			graph = new ArrayList[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
				costs[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				inDegrees[b]++;
			}
			W  = Integer.parseInt(br.readLine());
			
			dq = new ArrayDeque<>();
			maxValues = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				if (inDegrees[i] == 0) {
					dq.add(new int[] {i, costs[i]});
					maxValues[i] = costs[i];
				}
			}
			
			while (!dq.isEmpty()) {
				int[] node = dq.poll();
				int cur = node[0];
				int value = node[1];
				
				if (cur == W) {
					System.out.println(value);
					break;
				}
				
				for (int next : graph[cur]) {
					inDegrees[next]--;
					maxValues[next] = Math.max(maxValues[next], costs[next]+value);
					
					if (inDegrees[next] == 0) {
						dq.add(new int[] {next, maxValues[next]});
					}
				}
			}
		}
	}
}
