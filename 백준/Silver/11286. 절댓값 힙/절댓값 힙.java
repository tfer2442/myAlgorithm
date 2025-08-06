import java.util.*;
import java.io.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			
			return o1[0] - o2[0];
		});
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
					continue;
				}
				
				System.out.println(pq.poll()[1]);
				continue;
			}
			
			pq.add(new int[] {Math.abs(num), num});
		}
	}
}
