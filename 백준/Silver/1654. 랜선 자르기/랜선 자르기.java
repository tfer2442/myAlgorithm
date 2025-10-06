import java.util.*;
import java.io.*;

/*
 * 1 <= 랜선의 개수 K <= 10,000
 * 1 <= 필요한 랜선의 개수 N <= 1,000,000
 * K <= N
 * 1 <= 랜선의 길이 <= 2^31-1
 */
public class Main {
	public static int N, K;
	public static long[] cable;
	
	public static long checkCableNum(long mid) {
		long cnt = 0;
		
		for (int i = 0; i < K; i++) {
			cnt += cable[i]/mid;
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		cable = new long[K];
		
		long left = 1;
		long right = 0;
		long answer = 1;
		
		for (int i = 0; i < K; i++) {
			cable[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, cable[i]);
		}
		
		while (left <= right) {
			long mid = (left + right) / 2;
			long tmp = checkCableNum(mid);
			
			if (tmp < N) {
				right = mid - 1;
			} else if (tmp >= N) {
				answer = mid;
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
