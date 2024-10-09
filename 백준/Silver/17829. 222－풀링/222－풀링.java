import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] board;
	
	public static int dac(int curN, int sR, int sC) {
		if (curN == 1) {
			return board[sR][sC];
		}
		
		int nextN = curN/2;
		
		int a = dac(nextN, sR, sC);
		int b = dac(nextN, sR, sC+nextN);
		int c = dac(nextN, sR+nextN, sC);
		int d = dac(nextN, sR+nextN, sC+nextN);
		
		int[] nums = {a, b, c, d};
		Arrays.sort(nums);
		
		return nums[2];
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
