import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int T;
	public static int N, M;
	public static int[] A, B;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			A = new int[N];
			B = new int[M];
			
			tmp = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(tmp[i]);
			}
			
			tmp = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(tmp[i]);
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			int right = 0;
			int total = 0;
			
			for (int left = 0; left < N; left++) {
				while (right < M) {
					if (A[left] > B[right]) {
						right++;
					} else {
						break;
					}
				}
				total += right;
			}
			System.out.println(total);
		}
	}
}
