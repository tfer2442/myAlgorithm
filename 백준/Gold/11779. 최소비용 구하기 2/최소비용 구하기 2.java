import java.util.*;
import java.io.*;

/*
 * 다익스트라 문제
 * 경로 찾기
 * 
 */
public class Main {
	public static int N, M, S, E;
	public static ArrayList<int[]>[] graph;
	public static int[] distance;
	
	public static void calculate() {
		distance = new int[N+1];
		Arrays.fill(distance, 1_000_000_000);
		distance[S] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1] - o2[1];
		});
		
		pq.add(new int[] {S, 0});
		
		int[] paths = new int[N+1];
		paths[S] = S;
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (node[1] > distance[node[0]]) continue;
			
			for (int[] next : graph[node[0]]) {
				int nextValue = distance[node[0]] + next[1];
				
				if (distance[next[0]] > nextValue) {
					distance[next[0]] = nextValue;
					pq.add(new int[] {next[0], distance[next[0]]});
					paths[next[0]] = node[0];
				}
			}
		}
		
		System.out.println(distance[E]);
		ArrayList<Integer> p = new ArrayList<>();
		
		int cur = E;
		p.add(cur);
		
		while (cur != S) {
			cur = paths[cur];
			p.add(cur);
		}
		
		Collections.reverse(p);
		System.out.println(p.size());
		
		for (int i = 0; i < p.size(); i++) {
			System.out.print(p.get(i) + " ");
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[s].add(new int[] {e, value});
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		calculate();
	}

}
