import java.util.*;
import java.io.*;

public class Solution {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[100];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2)-> {
				return o2-o1;
			});
			
			PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2)-> {
				return o1-o2;
			});
			
			for (int i = 0; i < 100; i++) {
				maxHeap.add(nums[i]);
				minHeap.add(nums[i]);
			}
			
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				int maxValue = maxHeap.peek();				
				int minValue = minHeap.peek();
				
				if (Math.abs(maxValue-minValue) <= 1) {
					break;
				}
				
				maxHeap.poll();
				minHeap.poll();
				maxHeap.add(maxValue-1);
				minHeap.add(minValue+1);
			}
			
			System.out.println("#" + t + " " + (maxHeap.poll() - minHeap.poll()));
		}
	}

}
