import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int N;
	public static int[] tree;
	public static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq = new PriorityQueue<>();
			tree = new int[N];
			
			for (int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			int left = 0;
			int right = N-1;
			
			while (left < right) { 
				int a = pq.poll();
				int b = pq.poll();
				
				tree[left++] = a;
				tree[right--] = b;
			}
			
			if (!pq.isEmpty()) {
				tree[left] = pq.poll();
			}
			
			int answer = Integer.MIN_VALUE;
			for (int i = 0; i < N-1; i++) {
				answer = Math.max(answer, Math.abs(tree[i] - tree[i+1]));
			}
			
			if (Math.abs(tree[0]-tree[N-1]) > answer) {
				answer = Math.abs(tree[0]-tree[N-1]);
			}
			
			System.out.println(answer);
		}
	}
}
