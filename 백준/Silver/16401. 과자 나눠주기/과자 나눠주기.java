import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int[] snacks;
	
	public static int calculate(int mid) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			cnt += snacks[i] / mid;
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 조카의 수 
		N = Integer.parseInt(st.nextToken()); // 과자의 수
		
		snacks = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int left = 1;
		int right = 0;
		
		for (int i = 0; i < N; i++) {
			snacks[i] = Integer.parseInt(st.nextToken());
			right = Math.max(snacks[i], right);
		}
		
		int answer = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (calculate(mid) >= M) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
