

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] list;
	public static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N][2];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i] = new int[] {a, b};
		}
		
		Arrays.sort(list, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0]-o2[0];
		});
		
		pq.add(list[0][1]);
		
		for (int i = 1; i < N; i++) {
			if (list[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.add(list[i][1]);
		}
		System.out.println(pq.size());
	}

}
