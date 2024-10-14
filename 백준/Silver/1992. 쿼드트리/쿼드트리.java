import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static char[][] board;
	
	public static void dac(int curN, int sRow, int sCol) {
		
		char first = board[sRow][sCol];
		
		for (int i = sRow; i < curN+sRow; i++) {
			for (int j = sCol; j < curN+sCol; j++) {
				if (board[i][j] != first) {
					System.out.print("(");
					dac(curN/2, sRow, sCol);
					dac(curN/2, sRow, sCol+curN/2);
					dac(curN/2, sRow+curN/2, sCol);
					dac(curN/2, sRow+curN/2, sCol+curN/2);
					System.out.print(")");
					return;
				}
			}
		}
		
		if (first == '1') {
			System.out.print("1");
		} else {
			System.out.print("0");
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		dac(N, 0, 0);
	}
}
