import java.util.*;
import java.io.*;

public class Main {	
	public static int[][][] d = {
									  {{0}}
									, {{0}, {1}, {2}, {3}}
									, {{0, 2}, {1, 3}}
									, {{0, 1}, {1, 2}, {0, 3}, {2, 3}}
									, {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}
									, {{0, 1, 2, 3}}
									};
	public static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	public static int N, M;
	public static int[][] board;
	public static ArrayList<int[]> cctvs;
	public static int answer = Integer.MAX_VALUE;
	public static int[] combi;
	public static int K;
	
	public static void fillArray(int[][] board, int sr, int sc, int dirIdx) {
		board[sr][sc] = -1;
		
		int[] curDir = dir[dirIdx];
		int curR = sr;
		int curC = sc;
		
		while (true) {
			if (curR < 0 || curR >= N || curC < 0 || curC >= M) break;
			if (board[curR][curC] == 6) break;
			
			board[curR][curC] = -1;
			curR += curDir[0];
			curC += curDir[1];
		}
	}
	
	public static void calculate() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = board[i][j];
			}
		}
		
		for (int i = 0; i < K; i++) {
			int[] nums = d[cctvs.get(i)[2]][combi[i]];
			
			for (int num : nums) {
				fillArray(tmp, cctvs.get(i)[0], cctvs.get(i)[1], num);
			}
		}
				
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		answer = Math.min(answer, cnt);
	}
	
	public static void dfs(int depth) {
		if (depth >= K) {
			calculate();
			return;
		}
		
		int[] node = cctvs.get(depth);
		int r = node[0];
		int c = node[1];
		int p = node[2];
		
		for (int i = 0; i < d[p].length; i++) {
			combi[depth] = i;
			dfs(depth+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		cctvs = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if (board[i][j] >= 1 && board[i][j] <= 5) {
					cctvs.add(new int[] {i, j, board[i][j]});
				}
			}
		}
		
		K = cctvs.size();
		combi = new int[K];
		
		dfs(0);
		
		System.out.println(answer);
	}
}
