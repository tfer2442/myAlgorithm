import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static boolean[][] board;
	public static int[][] d = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	
	public static void checkDragonCurve(int x, int y, int curD, int g) {
		// 0세대 체크
		ArrayList<Integer> recordDir = new ArrayList<>();
		board[x][y] = true;
		board[x+d[curD][0]][y+d[curD][1]] = true;
		recordDir.add(curD);
		ArrayList<int[]> result = new ArrayList<>();
		result.add(new int[] {x, y});
		result.add(new int[] {x+d[curD][0], y+d[curD][1]});
		
		x += d[curD][0];
		y += d[curD][1];
		
		for (int i = 0; i < g; i++) {
			int num = (int)Math.pow(2, i);
			
			for (int j = 0; j < num; j++) {
				curD = (recordDir.get(num-j-1) + 1) % 4;
				
				recordDir.add(curD);
				x += d[curD][0];
				y += d[curD][1];
				
				board[x][y] = true;
				result.add(new int[] {x, y});
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new boolean[101][101];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int curD = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			checkDragonCurve(x, y, curD, g);
		}
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
