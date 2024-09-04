import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static int T, N, K;
	public static int[][] board;
	public static ArrayList<int[]> maxValues;
	public static int[][] d = {{-1 ,0}, {0, -1}, {0, 1}, {1, 0}};
	public static int answer;
	public static boolean[][] visited;
	
	public static void dfs(int row, int col, int cval, int clen, int ck) {
		
		answer = Math.max(answer, clen);
		
		for (int[] dd : d) {
			int nextR = row + dd[0];
			int nextC = col + dd[1];
			
			if (0 > nextR || nextR >= N || 0 > nextC || nextC >= N) continue;
			if (visited[nextR][nextC]) continue;
			if (cval > board[nextR][nextC]) {
				visited[nextR][nextC] = true;
				dfs(nextR, nextC, board[nextR][nextC], clen+1, ck);
				visited[nextR][nextC] = false;
			} else {
				if (ck != K) continue;
				if (board[nextR][nextC] - cval + 1 <= ck) {
					visited[nextR][nextC] = true;
					dfs(nextR, nextC, cval-1, clen+1, ck-(board[nextR][nextC]-cval+1));
					visited[nextR][nextC] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			maxValues = new ArrayList<>();
			int maxValue = -1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if (board[i][j] == maxValue) {
						maxValues.add(new int[] {i, j});
					} else if (board[i][j] > maxValue) {
						maxValue = board[i][j];
						maxValues.clear();
						maxValues.add(new int[] {i, j});
					}
					
				}
			}
			
			answer = 0;
			for (int[] node : maxValues) {
				visited = new boolean[N][N];
				visited[node[0]][node[1]] = true;
				dfs(node[0], node[1], board[node[0]][node[1]], 1, K);	
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
