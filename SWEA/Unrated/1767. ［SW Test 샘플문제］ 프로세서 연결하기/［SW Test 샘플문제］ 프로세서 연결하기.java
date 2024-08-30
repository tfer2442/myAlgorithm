import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static int T;
	public static int N;
	public static int[][] board;
	public static ArrayList<int[]> cores;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static int answerCore;
	public static int answerSum;
	
	public static void dfs(int cur, int cnt, int sum) {
		if (cur == cores.size()) {
			if (cnt > answerCore) {
				answerCore = cnt;
				answerSum = sum;
			} else if (cnt == answerCore) {
				if (sum < answerSum) {
					answerSum = sum;
				}
			}
			
			return;
		}
		
		dfs(cur+1, cnt, sum);
		
		for (int[] dd : d) {
			int row = cores.get(cur)[0];
			int col = cores.get(cur)[1];
			
			boolean flag = false;
			while (true) {
				row = row+dd[0];
				col = col+dd[1];
				
				if (row < 0 || col < 0 || row >= N || col >= N) {
					break;
				}
				
				if (board[row][col] == 1) {
					flag = true;
					break;
				}
			}
			
			if (flag) continue;
			
			row = cores.get(cur)[0];
			col = cores.get(cur)[1];
			int len = 0;
			while (true) {
				row = row+dd[0];
				col = col+dd[1];
				
				if (row < 0 || col < 0 || row >= N || col >= N) {
					break;
				}
				
				len++;
				board[row][col] = 1;
			}
			dfs(cur+1, cnt+1, sum+len);
			
			row = cores.get(cur)[0];
			col = cores.get(cur)[1];
			while (true) {
				row = row+dd[0];
				col = col+dd[1];
				if (row < 0 || col < 0 || row >= N || col >= N) {
					break;
				}
				
				board[row][col] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			cores = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1 && i != 0 && j != 0) cores.add(new int[] {i, j});
				}
			}
			
			answerCore = 0;
			answerSum = 0;
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + answerSum);
		}
	}

}
