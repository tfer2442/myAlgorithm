import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] arr;
	public static PriorityQueue<Integer> sPq;
	public static PriorityQueue<Integer> ePq;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sPq = new PriorityQueue<>();
		ePq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			sPq.add(Integer.parseInt(st.nextToken()));
			ePq.add(Integer.parseInt(st.nextToken()));
		}
		
		int answer = 0;
		
		while (!sPq.isEmpty() && !ePq.isEmpty()) {
			int a = sPq.peek();
			int b = ePq.peek();
			
			if (a < b) {
				sPq.poll();
				answer++;
			} else if(a >= b) {
				sPq.poll();
				ePq.poll();
			}
		}
		System.out.println(answer);
	}
}
