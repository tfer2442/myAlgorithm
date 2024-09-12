import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int N;
	public static PriorityQueue<Long> nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new PriorityQueue<>();
			
			for (int i = 0 ; i < N; i++) {
				nums.add(Long.parseLong(st.nextToken()));
			}
			
			long total = 0;
			while (nums.size() > 1) {
				long a = nums.poll();
				long b = nums.poll();
				
				total += (a+b);
				nums.add(a+b);
			}
			System.out.println(total);
		}
	}
}
