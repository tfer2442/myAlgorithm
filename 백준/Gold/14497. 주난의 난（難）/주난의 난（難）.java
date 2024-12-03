import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int sR, sC;
	public static int tR, tC;
	public static char[][] arr;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sR = Integer.parseInt(st.nextToken())-1;
		sC = Integer.parseInt(st.nextToken())-1;
		tR = Integer.parseInt(st.nextToken())-1;
		tC = Integer.parseInt(st.nextToken())-1;
		
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		PriorityQueue<int[]> dq = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		
		boolean[][] visited = new boolean[N][M];
		
		dq.add(new int[] {sR, sC, 0});
		visited[sR][sC] = true;
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			int curR = node[0];
			int curC = node[1];
			int depth = node[2];
			
			for (int[] dd : d) {
				int dR = dd[0];
				int dC = dd[1];
				int nextR = curR + dR;
				int nextC = curC + dC;
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
				if (visited[nextR][nextC]) continue;
				visited[nextR][nextC] = true;
				
				if (arr[nextR][nextC] == '1') {
					dq.add(new int[] {nextR, nextC, depth+1});
					continue;
				}
				
				if (arr[nextR][nextC] == '0') {
					dq.add(new int[] {nextR, nextC, depth});
					continue;
				}
				
				if (arr[nextR][nextC] == '#') {
					System.out.println(depth+1);
					return;
				}
				
			}
		}	
		
	}
}
