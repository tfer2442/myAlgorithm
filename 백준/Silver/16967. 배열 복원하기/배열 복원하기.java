import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int H, W, X, Y;
	static int[][] A;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] tmp = br.readLine().split(" ");
		H = Integer.parseInt(tmp[0]);
		W = Integer.parseInt(tmp[1]);
		X = Integer.parseInt(tmp[2]);
		Y = Integer.parseInt(tmp[3]);
		A = new int[H][W];
		
		for (int i = 0; i < H+X; i++) {
			tmp = br.readLine().split(" ");

			for (int j = 0; j < W; j++) {
				if (i < H) {
					A[i][j] = Integer.parseInt(tmp[j]);
				}
			}
		}
		
		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				A[i][j] -= A[i-X][j-Y];
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
