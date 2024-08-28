import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static int N;
	public static boolean[] visited;
	public static ArrayList<int[]>[] graph;
	public static PriorityQueue<int[]> pq;
	public static int total = 0;
	public static int mst = 0;
	public static int[][] board;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		graph = new ArrayList[N];
		board = new int[N][N];
		pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < N; j++) {
				char c = tmp.charAt(j);
				int value = 0;
				
				if (c == '0') {
					continue;
				}
				
				if ('a' <= c && c <= 'z') {
					value = c - 'a' + 1;
				} else {
					value = c - 'A' + 27;
				}
				
				total += value;
				if (i == j) continue;
				
				if (board[j][i] == 0) {
					board[i][j] = value;
					board[j][i] = value;
				} else {
					board[i][j] = Math.min(board[j][i], value);
					board[j][i] = board[i][j];
				}
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (board[i][j] == 0) continue;
				graph[i].add(new int[] {j, board[i][j]});
				graph[j].add(new int[] {i, board[i][j]});
			}
		}
		
		pq.add(new int[] {0, 0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (visited[node[0]]) continue;
			visited[node[0]] = true;
			mst += node[1];
			
			for (int[] next : graph[node[0]]) {
				if (!visited[next[0]]) {
					pq.add(next);
				}
			}
		}
		
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				flag = true;
				break;
			}
		}
		
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(total-mst);
		}
	}

}
