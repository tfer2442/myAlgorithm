import java.util.*;
import java.io.*;

/*
 * 조건에 따라서 빙하를 녹이면서, 최초로 두 덩어리 이상으로 나눠지는 최소 시간
 * 3 <= N, M <= 300, 0 <= 각 칸에 들어가는 값 <= 10
 * 최대 10년이 걸린다는 것, 만약 분리 되지 않으면 0 출력
 * 완전탐색 풀이 대략 연산 횟수: 300 * 300 * 10 * 4 = 3_600_000 
 * 
 */
public class Main {
	public static int N, M;
	public static int[][] board;
	public static int[][] tmpBoard;
	public static boolean[][] visited;
	public static boolean flag;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static boolean isDivide() {
		tmpBoard = new int[N][M];
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (board[i][j] == 0) continue;
				
				int cnt = 0;
				
				for (int[] dd : d) {
					int nextR = i + dd[0];
					int nextC = j + dd[1];
					
					if (board[nextR][nextC] == 0) cnt++;
				}
				
				tmpBoard[i][j] = Math.max(0, board[i][j]-cnt);
			}
		}
		
		board = tmpBoard;
		
		
		int num = 0;
		int[] start = new int[2];
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (board[i][j] != 0) {
					if (num == 0) {
						start[0] = i;
						start[1] = j;						
					}
					num++;
				}
			}
		}
		
		if (num == 0) {
			flag = true;
			return false;
		}
		
		visited = new boolean[N][M];
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {start[0], start[1]});
		visited[start[0]][start[1]] = true;
		int num2 = 1;
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];
				
				if (!visited[nextR][nextC] && board[nextR][nextC] != 0) {
					dq.add(new int[] {nextR, nextC});
					visited[nextR][nextC] = true;
					num2++;
				}
			}
		}
		
		if (num != num2) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int year = 0;
		while (true) {
		    year++;
		    if (isDivide()) {          // 이번 해 녹인 뒤 분리되었는지
		        System.out.println(year);
		        return;
		    }
		    if (flag) {                // 전부 녹았는지 (isDivide 내에서 num==0이면 flag=true)
		        System.out.println(0);
		        return;
		    }
		}
	}

}
