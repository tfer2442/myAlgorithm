import java.util.*;
import java.io.*;

/*
 * 인접한 국가들 사이에 국경이 열리는지 체크
 * 만약 국경이 하나도 열리지 않았으면 끝
 * 국경이 하나라도 열렸다면, 완전탐색을 이용해서 인접한 국가들을 모두 더한다.
 * 그리고, 나눈 후 업데이트,, 하지만, 바로 업데이트 하게 되면, 아직 체크안한 연합이랑 엉킬 수도 있겠네.
 * 그러면, 연합에 번호를 매겨서 HashMap에 업데이트 해야하는 값을 저장해두고, 한꺼번에 board를 업데이트한다.
 */
public class Main {
	public static int N, L, R;
	public static int[][] board;
	public static int[][] united;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static int cnt;
	public static HashMap<Integer, Integer> hm;
	
	public static void bfs(int curR, int curC) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		int sum = 0;
		int count = 0;
		
		dq.add(new int[] {curR, curC});
		united[curR][curC] = cnt;
		sum += board[curR][curC];
		count++;
		
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];
				
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				if (united[nextR][nextC] != -1) continue;
				int value = Math.abs(board[node[0]][node[1]] - board[nextR][nextC]);
				
				if (value >= L && value <= R) {
					dq.add(new int[] {nextR, nextC});
					united[nextR][nextC] = cnt;
					sum += board[nextR][nextC];
					count++;
				}
			}
		}
		
		hm.put(cnt, sum/count);
	}
	
	public static boolean calculate() {
		hm = new HashMap<>();
		united = new int[N][N];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				united[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (united[i][j] == -1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = hm.get(united[i][j]);
			}
		}
		
		if (hm.size() == N*N) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;
		
		for (int i = 0; i <= 2000; i++) {
			if (!calculate()) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
	}
}
