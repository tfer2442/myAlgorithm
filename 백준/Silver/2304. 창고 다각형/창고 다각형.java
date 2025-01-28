import java.util.*;
import java.io.*;


public class Main {
	public static int N;
	public static int[][] arr;

	public static int answer = 0;
	public static int maxIdx = -1;
	public static int maxH = 0;
	
	public static ArrayDeque<Integer> dq1 = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = a;
			arr[i][1] = b;
			
			if (b > maxH) {
				maxIdx = a;
				maxH = b;
			}
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0]-o2[0];
		});
		
		
		ArrayDeque<int[]> dq1 = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			if (arr[i][0] == maxIdx) {
				dq1.add(arr[i]);
				break;
			}
			
			if (dq1.isEmpty()) {
				dq1.add(arr[i]);
				continue;
			}
	
			int[] node = dq1.getLast();
			if (node[1] <= arr[i][1]) {
				dq1.add(arr[i]);
			}
		}
		
		ArrayDeque<int[]> dq2 = new ArrayDeque<>();

		for (int i = N-1; i >= 0; i--) {
			if (arr[i][0] == maxIdx) {
				dq2.add(arr[i]);
				break;
			}
			
			if (dq2.isEmpty()) {
				dq2.add(arr[i]);
				continue;
			}
			
			int[] node = dq2.getLast();
			if (node[1] <= arr[i][1]) {
				dq2.add(arr[i]);
			}
		}
		
		answer = maxH;
		while (true) {
			if (dq1.size() <= 1) break;
			int[] node1 = dq1.poll();
			int[] node2 = dq1.getFirst();
			
			answer += node1[1] * (node2[0]-node1[0]);
		}
		
		while (true) {
			if (dq2.size() <= 1) break;
			int[] node1 = dq2.poll();
			int[] node2 = dq2.getFirst();
			
			answer += node1[1] * (node1[0]-node2[0]);
		}
		
		System.out.println(answer);
	}
}
