import java.util.*;
import java.io.*;

public class Main {
	public static int n, k;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int answer = 0;
		int left = 0;
		
		for (int right = 0; right < n; right++) {
			if (arr[right] % 2 == 1) {
				cnt++;
				
				while (cnt > k) {
					if (arr[left] % 2 == 1) {
						cnt--;
					}
					
					left++;
				}
			}
			answer = Math.max(answer, right-left-cnt+1);
		}
		System.out.println(answer);
	}
}
