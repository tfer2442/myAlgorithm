import java.util.*;
import java.io.*;

public class Main {
	public static int order;
	public static int m, n;
	public static int[] p1, p2;
	public static HashMap<Integer, Integer> hm1;
	public static HashMap<Integer, Integer> hm2;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		order = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		m = Integer.parseInt(tmp[0]);
		n = Integer.parseInt(tmp[1]);
		
		p1 = new int[m];
		p2 = new int[n];
		
		for (int i = 0; i < m; i++) {
			p1[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			p2[i] = Integer.parseInt(br.readLine());
		}
		
		int[] arr1 = new int[m];
		int[] arr2 = new int[n];
		hm1 = new HashMap<>();
		hm2 = new HashMap<>();
		
		for (int i = 0; i < m-1; i++) { // 연속된거 몇 개 더할건지
			for (int j = 0; j < m; j++) { // 시작 인덱스
				arr1[j] += p1[(j+i)%m];
				
				if (hm1.containsKey(arr1[j])) {
					hm1.put(arr1[j], hm1.get(arr1[j])+1);
				} else {
					hm1.put(arr1[j], 1);
				}
			}
		}
		hm1.put(arr1[0]+p1[m-1], 1);
		
		for (int i = 0; i < n-1; i++) { // 연속된거 몇 개 더할건지
			for (int j = 0; j < n; j++) { // 시작 인덱스
				arr2[j] += p2[(j+i)%n];
				
				if (hm2.containsKey(arr2[j])) {
					hm2.put(arr2[j], hm2.get(arr2[j])+1);
				} else {
					hm2.put(arr2[j], 1);
				}
			}
		}
		hm2.put(arr2[0]+p2[n-1], 1);
		
		long answer = 0;
		if (hm1.size() < hm2.size()) {
			for (int key : hm1.keySet()) {
				if (key > order) continue;
				else if (key == order) {
					answer += hm1.get(key);
				}
				else {
					if (hm2.containsKey(order-key)) {
						answer += hm1.get(key) * hm2.get(order-key);
					}
				}
			}
			if (hm2.containsKey(order)) {
				answer += hm2.get(order);
			}
		} else {
			for (int key : hm2.keySet()) {
				if (key > order) continue;
				else if (key == order) {
					answer += hm2.get(key);
				}
				else {
					if (hm1.containsKey(order-key)) {
						answer += hm2.get(key) * hm1.get(order-key);
					}
				}
			}
			if (hm1.containsKey(order)) {
				answer += hm1.get(order);
			}	
		}
		System.out.println(answer);
	}
}
