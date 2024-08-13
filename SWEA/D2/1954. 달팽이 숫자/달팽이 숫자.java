import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static int[][] d = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int r = 0;
			int c = 0;
			int curD = 0;
			
			for (int i = 0; i < n*n; i++) {
				arr[r][c] = i+1;
				int nextR = r+d[curD][0];
				int nextC = c+d[curD][1];
				
				if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || arr[nextR][nextC] != 0) {
					curD = (curD+1) % 4;
				}
				
				r += d[curD][0];
				c += d[curD][1];
			}
			System.out.println("#"+t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
