import java.util.*;
import java.io.*;

/*
 * 1초마다 미세민지 확장, 공기청정기 작동 순서대로 구현
 * 
 * 1. 미세먼지 확장
 * BFS 이용하여 R * C 방을 초마다 미세먼지 확산 (T * R * C = 1,000 * 2,500 = 2,500,000)
 * 미세먼지를 바로 확산하게 되면, 아직 확산되지 않은 미세먼지의 값이 변경될 위험이 있음. 
 * 영향 범위의 값을 queue에 담아두고, 이후에 모두 poll 하여 기존 board 업데이트
 * 
 * 2. 공기청정기 작동
 * 공기 청정기 바람 방향반대로 미세먼지를 확인하면서, 업데이트
 */
public class Main {
	public static int R, C, T;
	public static int[][] board;
	public static int[][] airCleanMachine;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void spread() {
		// (r, c, value)
		ArrayList<int[]> savedValue = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 0 || board[i][j] == -1) continue;
				
				int cnt = 0;
				ArrayList<int[]> position = new ArrayList<>();
				
				for (int[] nextD : d) {
					int nextR = nextD[0] + i;
					int nextC = nextD[1] + j;
					
					if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
					if (board[nextR][nextC] == -1) continue;
					position.add(new int[] {nextR, nextC});
					cnt++;
				}
				
				int value = board[i][j] / 5;
				
				for (int[] next : position) {
					savedValue.add(new int[] {next[0], next[1], value});
				}
				savedValue.add(new int[] {i, j, board[i][j] - value*cnt});
			}
		}
		
		board = new int[R][C];
		board[airCleanMachine[0][0]][airCleanMachine[0][1]] = -1;
		board[airCleanMachine[1][0]][airCleanMachine[1][1]] = -1;
		
		for (int[] node : savedValue) {
			board[node[0]][node[1]] += node[2];
		}
//		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
	}
	
	public static void cleanAir() {
		// 공기청정기 상단 작동
		int prevR = airCleanMachine[0][0];
		int prevC = airCleanMachine[0][1];
		
		int[][] upD = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		int cntD = 0;
		
		for (int i = 0; i < (airCleanMachine[0][0]+1)*2+C*2-2; i++) {
			int curR = prevR + upD[cntD%4][0];
			int curC = prevC + upD[cntD%4][1];
						
			if (curR < 0 || curR >= R || curC < 0 || curC >= C || curR > airCleanMachine[0][0]) {
				cntD++;
				continue;
			}
			
			if (board[prevR][prevC] != -1) {
				board[prevR][prevC] = board[curR][curC];
			}
			board[curR][curC] = 0;
			prevR = curR;
			prevC = curC;
		}
		
		prevR = airCleanMachine[1][0];
		prevC = airCleanMachine[1][1];
		
		int[][] downD = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		cntD = 0;
		
		for (int i = 0; i < (R-airCleanMachine[1][0])*2+C*2-2; i++) {
			int curR = prevR + downD[cntD%4][0];
			int curC = prevC + downD[cntD%4][1];
						
			if (curR < 0 || curR >= R || curC < 0 || curC >= C || curR < airCleanMachine[1][0]) {
				cntD++;
				continue;
			}
			
			if (board[prevR][prevC] != -1) {
				board[prevR][prevC] = board[curR][curC];
			}
			board[curR][curC] = 0;
			prevR = curR;
			prevC = curC;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		airCleanMachine = new int[2][2];
		
		for (int i = 0; i < R; i++) {
			if (board[i][0] == -1) {
				airCleanMachine[0][0] = i;
				airCleanMachine[1][0] = i+1;
				break;
			}
		}
		
		for (int t = 0; t < T; t++) {
			spread();
			cleanAir();
		}
		
		int answer = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				answer += board[i][j];
			}
		}
		
		System.out.println(answer+2);
	}
}
