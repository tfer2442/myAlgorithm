import java.util.*;
import java.io.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2)->{
			return Integer.compare(o2, o1);
		});
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2)->{
			return Integer.compare(o1, o2);
		});
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (pq1.size() <= pq2.size()) {
				pq1.add(num);
			} else if (pq1.size() > pq2.size()) {
				pq2.add(num);
			}
			
			if (!pq1.isEmpty() && !pq2.isEmpty() && (pq1.peek() > pq2.peek())) {
				int tmp = pq1.poll();
				pq1.add(pq2.poll());
				pq2.add(tmp);
			}
			
			System.out.println(pq1.peek());
		}
	}
}
