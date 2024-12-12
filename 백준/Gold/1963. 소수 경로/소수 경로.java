import java.util.*;
import java.io.*;

public class Main {
	public static int T;
	public static int start, end;
	public static boolean[] primeNums;
	public static boolean[] visited;
	
	public static void eratostenes() {
		for (int i = 2; i < 10000; i++) {			
			boolean flag = false;
			for (int j = 2; j <= Math.pow(i, 0.5); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				primeNums[i] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		primeNums = new boolean[10000];
		eratostenes();
				
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			if (start == end) {
				System.out.println(0);
				continue;
			}
			visited = new boolean[10000];
			
			PriorityQueue<int[]> dq = new PriorityQueue<>((o1, o2) -> {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1]-o2[1];
			});
			
			dq.add(new int[] {start, 0});
			visited[start] = true;
			boolean flag = false;
			
			while (!dq.isEmpty()) {
				int[] node = dq.poll();
				int num = node[0];
				int depth = node[1];
				String tmp = String.valueOf(num);
				
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 10; j++) {
						if (tmp.charAt(i)-'0' == j) continue;
						
						String tmp2 = tmp.substring(0, i) + String.valueOf(j) + tmp.substring(i+1, tmp.length());
						int num2 = Integer.parseInt(tmp2);
						if (num2 < 1000) continue;
						if (!primeNums[num2]) continue;
						
						if (num2 == end) {
							flag = true;
							break;
						}
						if (visited[num2]) continue;
						visited[num2] = true;
						dq.add(new int[] {num2, depth+1});
					}
					if (flag) break;
				}
				
				if (flag) {
					System.out.println(depth+1);
					break;
				}
				
			}
			if (!flag) {
				System.out.println("Impossible");
			}
		}
	}
}
