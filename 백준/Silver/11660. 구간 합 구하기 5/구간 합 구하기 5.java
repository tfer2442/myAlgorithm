import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[i+1][j+1] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 2; i <= N; i++) {
			arr[i][1] += arr[i-1][1];
			arr[1][i] += arr[1][i-1];
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
						
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			System.out.println(arr[r2][c2] - arr[r2][c1-1] - arr[r1-1][c2] + arr[r1-1][c1-1]);
			
		}
	}
}
