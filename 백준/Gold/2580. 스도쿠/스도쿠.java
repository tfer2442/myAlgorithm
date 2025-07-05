import java.util.*;
import java.io.*;

/*
 * 백트랙킹 문제?
 * 같은행, 같은열, 같은 3*3을 보면서 가능해보이는 숫자를 미리 넣어둔다.
 * 이후에 아무 숫자도 들어가지 못하게 된다면, 이전에 수를 잘못 넣은 것이므로 return
 * 
 * 포인트
 * 1. 0의 위치를 미리 저장해두자
 * 2. 0의 개수를 미리 저장해두자
 * 3. 자신이 해당하는 3*3 시작점과 끝점을 찾는법을 생각해보자 
 */
public class Main {
	public static final int N = 9;
	public static int[][] board;
	public static ArrayList<int[]> zeroPosition;
	public static int zeroCount;
	
	public static boolean isAvailable(int cur, int value) {
		// 같은 행, 같은 열에 value와 같은게 있으면 false
		
		int row = zeroPosition.get(cur)[0];
		int col = zeroPosition.get(cur)[1];
		
		for (int i = 0; i < N; i++) {
			if (board[row][i] == value) {
				return false;
			}
			
			if (board[i][col] == value) {
				return false;
			}
		}
		
		for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
			for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
				if (board[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void backTracking(int cur) {
		if (cur == zeroCount) {
			for (int i = 0; i < N; i++) {	
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		for (int i = 1; i <= N; i++) {
			if (isAvailable(cur, i)) {
				board[zeroPosition.get(cur)[0]][zeroPosition.get(cur)[1]] = i;
				backTracking(cur+1);
				board[zeroPosition.get(cur)[0]][zeroPosition.get(cur)[1]] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		board = new int[N][N];
		zeroPosition = new ArrayList<>();
		
		// BufferdReader는 loop안에 두면 안됨. 스트림이 끊김
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					zeroCount++;
					zeroPosition.add(new int[] {i, j});
				}
			}
		}
		backTracking(0);		
	}
}
