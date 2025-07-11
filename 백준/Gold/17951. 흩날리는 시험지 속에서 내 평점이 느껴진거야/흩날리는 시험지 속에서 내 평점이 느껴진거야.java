import java.util.*;
import java.io.*;

public class Main {
	public static int N, K;
	public static int[] scores;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		scores = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int total = 0;

		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			total += scores[i];
		}
		
		int left = 0;
		int right = total/K;
		int answer = 0;
		
		while (left <= right) {
			int mid = (left+right)/2;
			
			int cnt = 0;
			int sum = 0;
			for (int score : scores) {
				sum += score;
				if (sum >= mid) {
					sum = 0;
					cnt++;
				}
			}
			
			if (cnt >= K) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}
