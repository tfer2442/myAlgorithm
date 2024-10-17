import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] board;
	
	public static int dac(int curN, int sRow, int sCol) {
		if (curN <= 1) {
			return board[sRow][sCol];
		}
		
		int nextN = curN/2;
		int a = dac(nextN, sRow, sCol);
		int b = dac(nextN, sRow+nextN, sCol);
		int c = dac(nextN, sRow, sCol+nextN);
		int d = dac(nextN, sRow+nextN, sCol+nextN);
		
		int[] arr = {a, b, c, d};
		
		Arrays.sort(arr);
		return arr[1];
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dac(N, 0, 0));
	}

}
