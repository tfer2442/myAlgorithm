import java.util.*;
import java.io.*;


public class Main {
   public static int N, M;
   public static ArrayList<Integer>[] graph;
   public static boolean[] visited;
   public static int[] nums;
   
   
   public static void main(String[] args) throws Exception {
   	// TODO Auto-generated method stub
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
   	StringTokenizer st = new StringTokenizer(br.readLine());
   	
   	N = Integer.parseInt(st.nextToken());
   	M = Integer.parseInt(st.nextToken());
   	
   	graph = new ArrayList[N+1];
   	nums = new int[N+1];
   	
   	for (int i = 1; i <= N; i++) {
   		graph[i] = new ArrayList<>();
   	}
   	
   	for (int i = 0; i < M; i++) {
   		st = new StringTokenizer(br.readLine());
   		int a = Integer.parseInt(st.nextToken());
   		int b = Integer.parseInt(st.nextToken());
   		
   		graph[b].add(a);
   	}
   	
   	for (int i = 1; i <= N; i++) {
   		visited = new boolean[N+1];

   		Queue<Integer> queue = new LinkedList<>();
   		
   		visited[i] = true;
   		queue.offer(i);
   		int cnt = 1;
   		
   		while (!queue.isEmpty()) {
   			int cur = queue.poll();
   			
   			for (int next : graph[cur]) {
   				if (visited[next]) continue;
   				visited[next] = true;
   				queue.offer(next);
   				cnt++;
   			}
   		}
   		
   		nums[i] = cnt;
   	}
   	
   	int maxValue = -1;
   	
   	for (int i = 1; i <= N; i++) {
   		maxValue = Math.max(maxValue, nums[i]);
   	}
   	
   	StringBuilder sb = new StringBuilder();
   	
   	for (int i = 1; i <= N; i++) {
   		if (nums[i] == maxValue) {
   			sb.append(i).append(" ");
   		}
   	}
   	
   	System.out.println(sb);
   }
}