import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] d = {1, 2, 3, 4, 5};
		

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			int[] arr = new int[8];
			int minValue = Integer.MAX_VALUE;
			
			for (int i = 0; i < 8; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				minValue = Math.min(minValue, tmp);
				arr[i] = tmp;
			}
			int div;
			
			if (minValue % 15 == 0) {
				div = (int)(minValue/15) - 1;
			} else {
				div = (int)(minValue/15);
			}
			
			for (int i = 0; i < 8; i++) {
				dq.add(arr[i]-(15*div));
			}
			
			int idx = 0;
			while (true) {
				int tmp = dq.poll();
				
				if (tmp - d[idx] <= 0) {
					dq.add(0);
					break;
				} else {
					dq.add(tmp-d[idx]);
				}
					
				idx = (idx+1)%5;
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(dq.poll() + " ");
			}
			System.out.println();
		}
		
	}

}
