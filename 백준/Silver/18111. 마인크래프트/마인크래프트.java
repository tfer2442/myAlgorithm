
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int b = Integer.parseInt(tmp[2]);
		
		int[][] board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] str1 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(str1[j]);
			}
		}
		
		int minTime = Integer.MAX_VALUE;
		int height = 0;
				
		for (int i = 256; i >= 0; i--) {
			int block = 0;
			int myTime = 0;
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++){
					if (board[j][k] < i) {
						block += i - board[j][k];
						myTime += i - board[j][k];
					} else if (board[j][k] > i) {
						myTime += (board[j][k] - i) * 2;
						block -= (board[j][k] - i);
					}
				}
			}
			if (block <= b) {
				if (minTime > myTime) {
					minTime = myTime;
					height = i;
				}
			}
		}
		System.out.printf("%d %d", minTime, height);
	}

}
