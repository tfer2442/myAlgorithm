import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static int n, d, k, c;
	public static int[] arr;
	public static Map<Integer, Integer> hashMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		d = Integer.parseInt(tmp[1]);
		k = Integer.parseInt(tmp[2]);
		c = Integer.parseInt(tmp[3]);
		
		arr = new int[n+k-1];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if (i < k) {
				if (hashMap.get(arr[i]) == null) {
					hashMap.put(arr[i], 1);
				} else {
					hashMap.put(arr[i], hashMap.get(arr[i])+1);
				}
			}
		}
		
		for (int i = n; i < n+k-1; i++) {
			arr[i] = arr[i-n];
		}
		
		int left = 0;
		int maxSize = hashMap.size();
		
		if (!hashMap.containsKey(c)) {
			maxSize += 1;
		} 

		for (int right = k; right < n+k-1; right++) {
			if (hashMap.get(arr[right]) == null) {
				hashMap.put(arr[right], 1);
			} else {
				hashMap.put(arr[right], hashMap.get(arr[right])+1);
			}
			
			if (hashMap.get(arr[left]) == 1) {
				hashMap.remove(arr[left]);
			} else {
				hashMap.put(arr[left], hashMap.get(arr[left])-1);
			}
			
			if (hashMap.containsKey(c)) {
				maxSize = Math.max(maxSize, hashMap.size());
			} else {
				maxSize = Math.max(maxSize, hashMap.size()+1);
			}
			left++;
		
		}
		
		System.out.println(maxSize);
	}

}
