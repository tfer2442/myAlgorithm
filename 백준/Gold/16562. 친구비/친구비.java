import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, k;
	public static int[] nums;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static ArrayDeque<Integer> dq;
	public static int sum = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N];


		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			dq = new ArrayDeque<>();
			dq.add(i);
			visited[i] = true;
			int answer = nums[i];
			
			while (!dq.isEmpty()) {
				int node = dq.poll();
				
				for (int next : graph[node]) {
					if (visited[next]) continue;
					dq.add(next);
					visited[next] = true;
					
					answer = Math.min(answer, nums[next]);
				}
			}
			
			sum += answer;
		}

		if (sum > k) {
			System.out.println("Oh no");
			return;
		}
		System.out.println(sum);
	}

}
