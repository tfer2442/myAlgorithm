import java.util.*;
import java.io.*;

public class Main {
	// 접시 수, 초밥 가짓 수, 연속 먹는 접시 수, 쿠폰 번호
	public static int N, d, k, c;
	public static int[] nums;
	public static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 0;
		int right = 0;
		int answer = 0;
		
		hm.put(c, 1);
		for (; right < k; right++) {
			hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
		}
		
		answer = hm.size();
		
		for (; left < N; left++, right++) {
			int rIdx = right % N;
			
			hm.put(nums[rIdx], hm.getOrDefault(nums[rIdx], 0) + 1);
			
			if (hm.get(nums[left]) <= 1) {
				hm.remove(nums[left]);
			} else {
				hm.put(nums[left], hm.get(nums[left]) - 1);
			}
			
			answer = Math.max(answer, hm.size());
		}
		
		System.out.println(answer);
	}
}
