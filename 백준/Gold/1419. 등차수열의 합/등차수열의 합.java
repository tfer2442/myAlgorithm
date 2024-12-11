import java.util.*;
import java.io.*;

public class Main {
	public static int left, right, k, answer;
	
	public static int calCnt(int first, int last, int d) {
		if (first % d == 0) {
			left = first;
		} else {
			left = first + (d - (first % d));
		}
		
		if (left > last) return 0;

		right = last - (last % d);
		
		return ((right-left) / d) + 1;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		left = Integer.parseInt(br.readLine());
		right = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		if (k == 2) {
			left = Math.max(left, 3);
			
			if (right < left) {
				answer = 0;
			} else {
				answer = right - left + 1;
			}
			
		} else if (k == 3) {
			int first = Math.max(left, 6);
			
			if (right < first) {
				answer = 0;
			} else {
				answer = calCnt(first, right, 3);
			}
		} else if (k == 4) {
			int first = Math.max(left, 14);
			
			if (left <= 10 && right >= 10) {
				answer = 1;
			}
			if (right < first) {
				answer += 0;
			} else {
				answer += calCnt(first, right, 2);
			}
			
			
		} else if (k == 5) {
			int first = Math.max(left, 15);
			
			if (right < first) {
				answer = 0;
			} else {
				answer = calCnt(first, right, 5);
			}
		}
		
		System.out.println(answer);
	}

}
