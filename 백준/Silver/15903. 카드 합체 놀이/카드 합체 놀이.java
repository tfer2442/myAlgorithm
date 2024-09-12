import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static PriorityQueue<Long> pq;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			long a = pq.poll();
			long b = pq.poll();
			long total = a+b;
			pq.add(total);
			pq.add(total);
		}
		
		long answer = 0;
		for (int i = 0; i < N; i++) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}

}
