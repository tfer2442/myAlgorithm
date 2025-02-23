import java.util.*;
import java.io.*;

public class Main {
	public static int M, N;
	public static int[][] board;
	public static int[][] visited;
	public static int[][] d = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	public static int area = 1;
	public static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void bfs(int sR, int sC) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		int sum = 0;
		dq.add(new int[] {sR, sC});
		visited[sR][sC] = area;
		sum += 1;
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			int curR = node[0];
			int curC = node[1];
			
			for (int i = 0; i < 4; i++) {
				if (curR + d[i][0] < 0 || curR + d[i][0] >= N || curC + d[i][1] < 0 || curC + d[i][1] >= M) continue;
				if (visited[curR+d[i][0]][curC+d[i][1]] != 0) continue;
				
				if ((board[curR][curC] & 1 << i) == 0) {
					dq.add(new int[] {curR+d[i][0], curC+d[i][1]});
					visited[curR+d[i][0]][curC+d[i][1]] = area;
					sum += 1;
				}
			}
		}
		
		hm.put(area, sum);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != 0) continue; 
				bfs(i, j);
				area++;
			}
		}
		
		int answer3 = hm.get(1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int[] dd : d) {
					int nextR = dd[0] + i;
					int nextC = dd[1] + j;
					
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
					if (visited[i][j] != visited[nextR][nextC]) {
						if (answer3 < hm.get(visited[i][j]) + hm.get(visited[nextR][nextC])) {
							answer3 = hm.get(visited[i][j]) + hm.get(visited[nextR][nextC]);
						}
					}
				}
			}
		}
		
		System.out.println(area-1);
		
		int maxValue = 0;
		for (int key : hm.keySet()) {
			if (hm.get(key) > maxValue) {
				maxValue = hm.get(key);
			}
		}
		System.out.println(maxValue);
		System.out.println(answer3);
	}

}
