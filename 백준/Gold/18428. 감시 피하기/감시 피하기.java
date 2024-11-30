import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static char[][] board;
	public static List<int[]> ts;
	public static int[][] nums;
	public static boolean flag;
	public static int[][] dd = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void combination(int depth, int index) {
		if (flag) return;
		
		if (depth == 3) {
			board[nums[0][0]][nums[0][1]] = 'O';
			board[nums[1][0]][nums[1][1]] = 'O';
			board[nums[2][0]][nums[2][1]] = 'O';
			
			for (int[] t : ts) {
				for (int[] d : dd) {
					int nRow = t[0];
					int nCol = t[1];
					while (true) {
						nRow += d[0];
						nCol += d[1];
						
						if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) break;
						if (board[nRow][nCol] == 'O' || board[nRow][nCol] == 'T') {
							break;
						}
						
						if (board[nRow][nCol] == 'S') {
							board[nums[0][0]][nums[0][1]] = 'X';
							board[nums[1][0]][nums[1][1]] = 'X';
							board[nums[2][0]][nums[2][1]] = 'X';
							return;
						}
					}
				}
				
			}
			
			flag = true;
			return;
		}
		
		for (int i = index; i < N*N; i++) {
			int row = i/N;
			int col = i%N;
			
			if (board[row][col] != 'X') continue;
			nums[depth] = new int[] {row, col};
			combination(depth+1, i+1);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		ts = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp[j].charAt(0);
				
				if (board[i][j] == 'T') {
					ts.add(new int[] {i, j});
				}
			}
		}
		
		nums = new int[3][];
		combination(0, 0);
		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
