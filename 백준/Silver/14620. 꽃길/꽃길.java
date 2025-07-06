import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] board;
	public static boolean[][] visited;
	public static int[][] selected;
	public static int answer;
	public static int[][] d = {{0, 0}, {0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	
	public static boolean isAvailable(int r, int c) {
		
		for (int[] dd : d) {
			int nextR = dd[0] + r;
			int nextC = dd[1] + c;
			
			if (visited[nextR][nextC]) return false;
		}
		
		return true;
	}
	
	public static void backtracking(int cnt) {
		if (cnt == 3) {
			// 고른 것 들의 총 비용 계산하기
			int total = 0;
			for (int i = 0; i < 3; i++) {
				for (int[] dd : d) {
					int r = selected[i][0] + dd[0];
					int c = selected[i][1] + dd[1];
					
					total += board[r][c];
				}
			}
			
			answer = Math.min(answer, total);
			return;
		}
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				if (isAvailable(i, j)) {
					selected[cnt][0] = i;
					selected[cnt][1] = j;
					for (int[] dd : d) {
						int r = dd[0] + i;
						int c = dd[1] + j;
						visited[r][c] = true;
					}
					backtracking(cnt+1);
					for (int[] dd : d) {
						int r = dd[0] + i;
						int c = dd[1] + j;
						visited[r][c] = false;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		selected = new int[3][2];
		answer = Integer.MAX_VALUE;
		backtracking(0);
		System.out.println(answer);
	}

}
