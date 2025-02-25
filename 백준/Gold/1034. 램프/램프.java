import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, K; 
	public static int[][] nums;
	public static long[] binaryNums;
	public static int[] zeroCount;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N][M];
		binaryNums = new long[N];
		zeroCount = new int[N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				nums[i][j] = tmp.charAt(j) - '0';
				if (nums[i][j] == 0) {
					zeroCount[i]++;
				}
			}
			
			long gap = 1L;
			
			for (int j = M-1; j >= 0; j--) {
				binaryNums[i] += nums[i][j] * gap;
				gap *= 2;
			}
		}
		
		K = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			if (zeroCount[i] <= K && zeroCount[i] % 2 == K % 2) {
				for (int j = i; j < N; j++) {
					if (binaryNums[i] == binaryNums[j]) {
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}
