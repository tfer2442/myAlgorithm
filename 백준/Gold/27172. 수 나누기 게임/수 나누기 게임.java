import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] nums;
	public static int maxValue = 0;
	public static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			hm.put(nums[i], 0);
			maxValue = Math.max(nums[i], maxValue);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = nums[i]; j <= maxValue; j += nums[i]) {
				if (hm.containsKey(j)) {
					hm.put(nums[i], hm.get(nums[i])+1);
					hm.put(j, hm.get(j)-1);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(hm.get(nums[i]) + " ");
		}
	}
}
