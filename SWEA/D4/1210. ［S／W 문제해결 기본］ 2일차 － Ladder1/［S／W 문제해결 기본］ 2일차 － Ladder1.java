import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

class Solution {
	public static int[][] arr;
	public static int sRow;
	public static int sCol;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int T = 1; T <= 10; T++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				String[] tmp = br.readLine().split(" ");
				
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
					if (arr[i][j] == 2) {
						sRow = i;
						sCol = j;
					}
				}
			}
			
			int r = sRow-1;
			int c = sCol;

			while (true) {
				if (r == 0) {
					System.out.println("#" + T + " " + c);
					break;
				}
				if (c-1 >= 0 && arr[r][c-1] == 1) {
					for(;c>=1; c--) {
						if (arr[r][c-1] == 0) {
							break;
						}
					}
					r = r-1;
					continue;
				}
				
				if (c+1 < 100 && arr[r][c+1] == 1) {
					for(;c+1<100; c++) {
						if (arr[r][c+1] == 0) {
							break;
						}
					}
					r = r-1;
					continue;
				}
				r = r-1;
			}
		}
	}

}
