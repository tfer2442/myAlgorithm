import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static int N;
	public static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			pq.add(tmp);
		}
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		int sum = 0;
		
		while (true) {
			int a = pq.poll();
			sum += a;
			if (pq.isEmpty()) {
				break;
			}
			
			int b = pq.poll();
			sum += b;
			if (pq.isEmpty()) {
				break;
			}
			
			pq.add(a+b);
		}
		
		System.out.println(sum);
	}
}
