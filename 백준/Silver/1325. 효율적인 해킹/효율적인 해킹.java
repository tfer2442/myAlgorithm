import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited;
	public static int[] result;
	
	public static void bfs(int cnt) {
		int answer = 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		visited = new boolean[N+1];
		visited[cnt] = true;
		dq.add(cnt);
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
			for (int next : graph.get(cur)) {
				if (visited[next]) continue;
				visited[next] = true;
				dq.add(next);
				answer++;
			}
		}
		
		result[cnt] = answer;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N+1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < result[i]) {
				max = result[i];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (max == result[i]) {
				System.out.print(i + " ");
			}
		}
	}
}
