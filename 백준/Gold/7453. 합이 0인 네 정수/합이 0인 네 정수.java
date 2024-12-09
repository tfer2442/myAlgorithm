import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] A, B, C, D;
	public static int[] merge1, merge2;
	public static long answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());	
		}
		
		merge1 = new int[N*N];
		merge2 = new int[N*N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				merge1[i*N+j] = A[i]+B[j];
				merge2[i*N+j] = C[i]+D[j];
			}
		}
		
		Arrays.sort(merge1);
		Arrays.sort(merge2);
		
		for (int i = 0; i < N*N; i++) {
			int left = 0;
			int right = N*N-1;
			int upperBound = -1;
			
			while (left <= right) {
				int mid = (left+right)/2;
				int cal = merge1[i] + merge2[mid];
				
				if (cal > 0) {
					right = mid - 1;
				} else if (cal == 0){
					upperBound = mid;
					left = mid + 1;
				} else if (cal < 0) {
					left = mid + 1;
				}
			}
			
			if (upperBound == -1) continue;
			
			left = 0;
			right = N*N-1;
			int lowerBound = N*N;
			
			while (left <= right) {
				int mid = (left+right)/2;
				int cal = merge1[i] + merge2[mid];
				
				if (cal > 0) {
					right = mid - 1;
				} else if (cal == 0){
					lowerBound = mid;
					right = mid - 1;
				} else if (cal < 0) {
					left = mid + 1;
				}
			}
			
			answer += upperBound - lowerBound + 1;
		}
		
		System.out.println(answer);
	}

}
