import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<Integer>[] outGraph;
	public static ArrayList<Integer>[] inGraph;
	public static boolean[] visited;
	
	public static int bfs(int start) {
		int answer = 0;
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		visited = new boolean[N+1];
		visited[start] = true;
		dq.add(start);
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
			for (int next : inGraph[cur]) {
				if (visited[next]) continue;
				dq.add(next);
				visited[next] = true;
				answer++;
			}
		}
		
		dq = new ArrayDeque<>();
		visited = new boolean[N+1];
		visited[start] = true;
		dq.add(start);
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
			for (int next : outGraph[cur]) {
				if (visited[next]) continue;
				dq.add(next);
				visited[next] = true;
				answer++;
			}
		}
		
		return N-answer-1;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		inGraph = new ArrayList[N+1];
		outGraph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			inGraph[i] = new ArrayList<>();
			outGraph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			inGraph[a].add(b);
			outGraph[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(bfs(i));
		}
	}

}
