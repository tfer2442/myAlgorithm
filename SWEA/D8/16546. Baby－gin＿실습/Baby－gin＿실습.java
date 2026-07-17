import java.util.*;
import java.io.*;

public class Solution {
	public static int T;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String line = br.readLine();
			HashMap<Integer, Integer> hm = new HashMap<>();
			
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				hm.put(c-'0', hm.getOrDefault(c-'0', 0)+1);
			}
			
			boolean flag = false;
			int cnt = 0;
			int i = 0;
			
			while (i < 10) {
				if (cnt == 6) {
					flag = true;
					break;
				}
				
				if (hm.getOrDefault(i, 0) == 0) {
					i++;
					continue;
				}
				
				if (hm.get(i) >= 3) {
					cnt += 3 * (hm.get(i)/3);
					hm.put(i, hm.get(i)%3);				
				} else {
					if (i >= 8) break;
					
					if (hm.getOrDefault(i, 0) >= 1 && hm.getOrDefault(i+1, 0) >= 1 && hm.getOrDefault(i+2, 0) >= 1) {					
						cnt += 3;
						hm.put(i, hm.get(i)-1);
						hm.put(i+1, hm.get(i+1)-1);
						hm.put(i+2, hm.get(i+2)-1);
					} else {
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + flag);
		}
	}
}
