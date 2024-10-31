import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] board;
	public static ArrayList<int[]> arr;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == '.') continue;
				
				int cnt = 0;
				for (int[] dd : d) {
					int dr = dd[0] + i;
					int dc = dd[1] + j;
					
					if (dr < 0 || dr >= N || dc < 0 || dc >= M) {
						cnt++;
						continue;
					}
					
					if (board[dr][dc] == '.') {
						cnt++;
					}
 				}
				
				if (cnt >= 3) {
					arr.add(new int[] {i, j});
				}
			}
		}
		
		for (int[] a : arr) {
			board[a[0]][a[1]] = '.';
		}
		
		int minRow = N;
		int maxRow = -1;
		int minCol = M;
		int maxCol = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'X') {
					minRow = Math.min(minRow, i);
					maxRow = Math.max(maxRow, i);
					minCol = Math.min(minCol, j);
					maxCol = Math.max(maxCol, j);
				} 
			}
		}
		
		for (int i = minRow; i <= maxRow; i++) {
			for (int j = minCol; j <= maxCol; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
