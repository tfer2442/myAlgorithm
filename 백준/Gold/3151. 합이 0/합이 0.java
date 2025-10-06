import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] students;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		students = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(students);
		
		long answer = 0;
		
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				int left = j+1;
				int right = N-1;
				int value = students[i] + students[j];
				int lowerBound = -1;
				
				// lowerBound
				while (left <= right) {
					int mid = (left + right) / 2;
					int tmp = value + students[mid];
					
					if (tmp > 0) {
						right = mid - 1;
					} else if (tmp < 0) {
						left = mid + 1;
					} else if (tmp == 0) {
						lowerBound = mid;
						right = mid-1;
					}
				}
			
				if (lowerBound == -1) {
					continue;
				}
				
				// upperBound
				left = lowerBound;
				right = N-1;
				int upperBound = -1;
				while (left <= right) {
					int mid = (left + right) / 2;
					int tmp = value + students[mid];
					
					if (tmp > 0) {
						right = mid - 1;
					} else if (tmp < 0) {
						left = mid + 1;
					} else if (tmp == 0) {
						upperBound = mid;
						left = mid+1;
					}
				}
				
				answer += (upperBound-lowerBound+1);
			}
		}
		
		System.out.println(answer);
	}
}
