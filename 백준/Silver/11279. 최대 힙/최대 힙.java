import java.util.*;
import java.io.*;

/*
 * 맥스힙
 */
public class Main {
	public static int N;
	
	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> {
			return o2-o1;
		});
			
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
					continue;
				}
				
				System.out.println(pq.poll());
				continue;
			}
			
			pq.add(num);
		}
	}
}
