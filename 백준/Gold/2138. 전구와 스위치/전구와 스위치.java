import java.util.*;
import java.io.*;

public class Main {
	
	static int calculate(boolean flag, int[] nums1, int[] nums2) {
		int cnt = 0;
		
		if (flag) cnt++;
		
		for (int i = 1; i < nums1.length; i++) {
			if (nums1[i-1] != nums2[i-1]) {
				nums1[i-1] = nums1[i-1] ^ 1;
				nums1[i] = nums1[i] ^ 1;
				
				if (i != nums1.length-1) {
					nums1[i+1] = nums1[i+1] ^ 1;
				}
				cnt++;
			}
		}
		
		if (nums1[nums1.length-1] == nums2[nums2.length-1]) {
			return cnt;
		}
		
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String tmp1 = br.readLine();
		String tmp2 = br.readLine();
		
		int[] nums1 = new int[N];
		int[] nums2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums1[i] = tmp1.charAt(i) - '0';
			nums2[i] = tmp2.charAt(i) - '0';
		}
		
		int[] tmp = Arrays.copyOf(nums1, nums1.length);
		tmp[0] = tmp[0] ^ 1;
		tmp[1] = tmp[1] ^ 1;
		boolean flag = true;
		
		int a = calculate(flag, tmp, nums2);
		
		tmp = Arrays.copyOf(nums1, nums1.length);
		flag = false;
		int b = calculate(flag, tmp, nums2);
		
		int answer = Math.min(a, b);
		
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
		return;
	}
}
