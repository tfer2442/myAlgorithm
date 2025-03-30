import java.util.*;
import java.io.*;

public class Main {
	public static int N, d, k, c;
	public static int[] nums;
	public static HashMap<Integer, Integer> hm;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		nums = new int[N];
		hm = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		hm.put(c, 1);
		for (int i = 0; i < k; i++) {
			if (hm.containsKey(nums[i])) {
				hm.put(nums[i], hm.get(nums[i])+1);
				continue;
			}
			hm.put(nums[i], 1);
		}
		int answer = hm.size();
		
		int right = k;
		for (int left = 0; left < N; left++, right++) {
			
			if (hm.get(nums[left%N]) >= 2) {
				hm.put(nums[left%N], hm.get(nums[left%N])-1);
			} else {
				hm.remove(nums[left%N]);
			}
			
			if (hm.containsKey(nums[right%N])) {
				hm.put(nums[right%N], hm.get(nums[right%N])+1);
			} else {
				hm.put(nums[right%N], 1);				
			}
			
			answer = Math.max(hm.size(), answer);
		}
		System.out.println(answer);
	}
}
