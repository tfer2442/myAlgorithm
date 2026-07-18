import java.util.*;
import java.io.*;


public class Solution {
	public static int T, N, M, K;
	public static HashMap<String, int[]> hm;
	public static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static int calculate() {
	    for (int time = 0; time <= K; time++) {
	        List<String> ready = new ArrayList<>();

	        for (Map.Entry<String, int[]> e : hm.entrySet()) {
	            int[] nums = e.getValue();
	            if (nums[0] >= time-nums[1] || time-nums[1] > 2*nums[0]) continue;
	            ready.add(e.getKey());
	        }

	        for (String key : ready) {
	            int[] nums = hm.get(key);

	            String[] tmp = key.split(",");
	            int r = Integer.parseInt(tmp[0]);
	            int c = Integer.parseInt(tmp[1]);

	            for (int[] dd : d) {
	                int nextR = r + dd[0];
	                int nextC = c + dd[1];
	                String nextKey = nextR+","+nextC;

	                if (hm.containsKey(nextKey)) {
	                    int[] nextNums = hm.get(nextKey);
	                    if (nextNums[1] == time && nextNums[0] < nums[0]) {
	                        hm.put(nextKey, new int[] {nums[0], time});
	                    }
	                    continue;
	                }

	                hm.put(nextKey, new int[] {nums[0], time});
	            }
	        }
	    }

	    int cnt = 0;
	    for (String key : hm.keySet()) {
	        int[] nums = hm.get(key);
	        if (K < nums[0]*2 + nums[1]) {
	            cnt++;
	        }
	    }
	    return cnt;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
					
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// "r,c" : [생명력, 심긴시간]
			hm = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < M; j++) {
					int a = Integer.parseInt(st.nextToken());					
					
					if (a == 0) continue;					
					
					hm.put(i+","+j, new int[] {a, 0});					
				}
			}
			
			int answer = calculate();
			
			System.out.println("#" + t + " " + answer);
		}		
	}
}
