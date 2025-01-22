import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] A;
	public static int[] B;
	public static int[][] arr;
	
	public static int dfs(int left, int right) {
		if (left >= N || right >= N) return 0;
		
		if (arr[left][right] != -1) {
			return arr[left][right];
		}
		
		if (A[left] > B[right]) {
			arr[left][right] = dfs(left, right+1) + B[right];
		} else {
			arr[left][right] = Math.max(dfs(left+1, right), dfs(left+1, right+1));
		}
		
		return arr[left][right];
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = -1;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dfs(0, 0));
	}
}
