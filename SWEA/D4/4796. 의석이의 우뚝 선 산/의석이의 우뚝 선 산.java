import java.util.*;

public class Solution {
	public static int T, N;
	public static int[] mountains, nums1, nums2;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			mountains = new int[N];
			nums1 = new int[N];
			nums2 = new int[N];

			for (int i = 0; i < N; i++) {
				mountains[i] = sc.nextInt();
			}

			for (int i = 1; i < N; i++) {
				if (mountains[i] > mountains[i-1]) {
					nums1[i] = nums1[i-1] + 1;
				}
			}

			for (int i = N-2; i >= 0; i--) {
				if (mountains[i] > mountains[i+1]) {
					nums2[i] = nums2[i+1] + 1;
				}
			}

			long sum = 0;

			for (int i = 0; i < N; i++) {
				sum += (long)nums1[i] * nums2[i];
			}

			System.out.println("#" + t + " " + sum);
		}
	}
}