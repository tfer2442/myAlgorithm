import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] inDegrees1, inDegrees2;
	public static int[] distance1, distance2;
	public static ArrayList<int[]>[] graph1, graph2;
	public static int start, end;
	public static int result;
	public static int count;
	public static ArrayDeque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		inDegrees1 = new int[N+1];
		inDegrees2 = new int[N+1];
		distance1 = new int[N+1];
		distance2 = new int[N+1];
		graph1 = new ArrayList[N+1];
		graph2 = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph1[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph1[a].add(new int[] {b, value});
			graph2[b].add(new int[] {a, value});
			inDegrees1[b]++;
			inDegrees2[a]++;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dq = new ArrayDeque<>();
		dq.add(new int[] {start, 0});
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] next : graph1[node[0]]) {
				inDegrees1[next[0]]--;
				
				distance1[next[0]] = Math.max(node[1] + next[1], distance1[next[0]]);
				
				if (inDegrees1[next[0]] == 0) {
					dq.add(new int[] {next[0], distance1[next[0]]});
				}
 			}
		}
		
		result = distance1[N];
		
		dq = new ArrayDeque<>();
		dq.add(new int[] {end, 0});
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] next : graph2[node[0]]) {
				inDegrees2[next[0]]--;
				
				distance2[next[0]] = Math.max(node[1] + next[1], distance2[next[0]]);
				
				if (inDegrees2[next[0]] == 0) {
					dq.add(new int[] {next[0], distance2[next[0]]});
				}
 			}
		}
		
		dq = new ArrayDeque<>();
		dq.add(new int[] {start, 0});
		boolean[] visited = new boolean[N+1];
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] next : graph1[node[0]]) {
				int value = node[1] + next[1] + distance2[next[0]];
				
				if (value == result) count++;
				if (value == result && !visited[next[0]]) {
					dq.add(new int[] {next[0], node[1]+next[1]});
					visited[next[0]] = true;
				}
			}
		}
		System.out.println(result);
		System.out.println(count);
	}
}
