import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static int T;
	public static int N, M;
	public static int[][] board;
	public static boolean[][] visited;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static int cnt;
	
	public static boolean bfs(int r, int c, int depth) {
		cnt = 0;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		visited[r][c] = true;
		dq.add(new int[] {r, c, 0});
		
		if (board[r][c] == 1) {
			cnt++;
		}
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
						
			for (int[] dd : d) {
				int nRow = node[0] + dd[0];
				int nCol = node[1] + dd[1];
				
				if (0 > nRow || nRow >= N || 0 > nCol || nCol >= N) continue;
				if (visited[nRow][nCol]) continue;
				if (node[2] < depth-1) {
					if (board[nRow][nCol] == 1) cnt++;
					dq.add(new int[] {nRow, nCol, node[2]+1});
					visited[nRow][nCol] = true;
				}
			}
		}
	
		
		if (cnt*M >= depth*depth + (depth-1)*(depth-1)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for (int k = N+1; k >= 2; k--) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						visited = new boolean[N][N];
						if (bfs(i, j, k)) {
							answer = Math.max(answer, cnt);
						}
					}
				}
			}
			
			if (answer != 0) {
				System.out.println("#" + t + " " + answer);
			} else {
				System.out.println("#" + t + " " + 1);
			}

			
		}
	}

}
