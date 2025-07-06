import java.util.*;
import java.io.*;

/*
 * 가장 높은 곳에서부터 높이를 1씩 감소시키면서, 해당 시간을 계산한다.
 * 인벤토리에 블록이 부족하면 return, 그런데 부족하다고 바로 return 하면 안됨. 어떤 블록을 먼저 빼고 넣을지 계산을 안했기 때문에!
 */
public class Main {
	public static int N, M, B;
	public static int[][] board;
	public static int maxH, minH;
	public static int minTime, answerH;
	
	public static void calculate(int h) {
		int b = B;
		int time = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == h) continue;
				if (board[i][j] < h) {
					b = b - (h-board[i][j]);
					time = time + (h-board[i][j]);
					continue;
				}
				// 블록 제거 후 인벤토리에 넣기
				if (board[i][j] > h) {
					b = b + (board[i][j]-h);
					time = time + (board[i][j]-h) * 2;
					continue;
				}
			}
		}
		
		if (b < 0) {
			return;
		}
		
		if (minTime > time) {
			minTime = time;
			answerH = h;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		minTime = Integer.MAX_VALUE;
		minH = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) { 
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, board[i][j]);
				minH = Math.min(minH, board[i][j]);
			}
		}

		for (int h = maxH; h >= minH; h--) {
			calculate(h);
		}
		
		System.out.println(minTime + " " + answerH);
	}
}
