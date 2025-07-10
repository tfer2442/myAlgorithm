import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] scores;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		scores = new int[N];
		
		for (int i =0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N <= 2) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(scores);
		long answer = 0;
		
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				int left = j + 1;
				int right = N - 1;
				int sum = scores[i] + scores[j];
				int target = -1 * sum;
				int leftIdx = N;
				
				// target 맨 왼쪽 인덱스 찾기
				while (left <= right) {
					int mid = (left+right)/2;
					
					if (scores[mid] > target) {
						right = mid - 1;
					} else if (scores[mid] < target) {
						left = mid + 1;
					} else if (scores[mid] == target) {
						leftIdx = mid;
						right = mid - 1;
					}
				}
								
				// target 값이 없다면 반복문 넘어가기
				if (leftIdx == N) continue;
				
				left = j + 1;
				right = N - 1;
				int rightIdx = -1;
				// target 맨 오른쪽 인덱스 찾기
				while (left <= right) {
					int mid = (left+right)/2;
					
					if (scores[mid] > target) {
						right = mid - 1;
					} else if (scores[mid] < target) {
						left = mid + 1;
					} else if (scores[mid] == target) {
						rightIdx = mid;
						left = mid + 1;
					}
				}
				
				answer += (rightIdx - leftIdx) + 1;
			}
		}
		System.out.println(answer);
	}
}
