import java.util.*;
import java.io.*;

/*
 * 임의의 두 점을 고르고, 다른 정점에서 두 점 중 가까운 점까지의 거리의 총합
 * 2 <= N <= 100 -> 임의의 두 점을 고른다면 O(100*99/2)
 * 다익스트라를 활용하면? O(ElogV)
 * -> O(V^2 * ElogV) 1 초안에 통과 가능
 * 근데, 거리가 모두 1로 같으므로 BFS로 해도 되지 않을까? Depth가 곧 길이인데
 * 그러면, 치킨 집을 기준으로 BFS를 돌리고, 배열을 업데이트 하는 식으로 하면 되겠다.
 * 1. 조합을 작은 숫자부터 차례대로 구해야 함
 */
public class Main {
	public static int N, M;
	public static ArrayList<Integer>[] graph;
	public static int[] combinationNumbers, answerIdx;
	public static int answer = Integer.MAX_VALUE;
	
	public static void bfs() {
		int[] distance = new int[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		
		for (int i = 0; i < 2; i++) {
			ArrayDeque<int[]> dq = new ArrayDeque<>();
			int start = combinationNumbers[i];
			
			distance[start] = 0;
			dq.offer(new int[] {start, 0});
			
			while (!dq.isEmpty()) {
				int[] node = dq.poll();
				int cur = node[0];
				int value = node[1];
				
				for (int next : graph[cur]) {
					if (distance[next] == Integer.MAX_VALUE || distance[next] > value+1) {
						distance[next] = value+1;
						dq.offer(new int[] {next, value+1});
						continue;
					}
				}
			}
		}
		
		int total = 0;
		for (int i = 1; i <= N; i++) {
			total += distance[i];
		}
		
		total *= 2;
		
		if (total < answer) {
			answer = total;
			answerIdx[0] = combinationNumbers[0];
			answerIdx[1] = combinationNumbers[1];
		}
	}
	
	public static void calculate(int depth, int idx) {
		if (depth >= 2) {
			bfs();
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			combinationNumbers[depth] = i;
			calculate(depth+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		combinationNumbers = new int[2];
		answerIdx = new int[2];
		
		calculate(0, 1);
		
		System.out.println(answerIdx[0] + " " + answerIdx[1] + " " + answer);
	}
}
