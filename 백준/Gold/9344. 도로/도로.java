import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int N, M, p, q;
	public static PriorityQueue<int[]> pq;
	public static int[] parents;
	
	public static int findParent(int x) {
		if (parents[x] == x) {
			return x;
		}
		
		return parents[x] = findParent(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		
		if (parentA == parentB) {
			return false;
		} 
		
		if (parentA > parentB) {
			parents[parentA] = parentB;
		} else {
			parents[parentB] = parentA;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<>((o1, o2) -> {
				return o1[2]-o2[2];
			});
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				pq.add(new int[] {a, b, value});
			}
			parents = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			int cnt = 0;
			boolean flag = false;
			while (!pq.isEmpty()) {
				int[] node = pq.poll();
				
				if (union(node[0], node[1])) {
					cnt++;
					if ((node[0] == p && node[1] == q) || (node[0] == q && node[1] == p)) {
						System.out.println("YES");
						flag = true;
					}
				}
				
				if (cnt == N-1) break;
			}
			
			if (!flag) {
				System.out.println("NO");
			}
		}
	}

}
