import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if (parentA == parentB) return false;
		parent[parentA] = parentB;
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o2[0]-o1[0];
		});
		
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {value, a, b});
		}
		
		parent = new int[p];
		
		for (int i = 0; i < p; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < w; i++) {
			int[] node = pq.poll();
			int a = node[1];
			int b = node[2];
			
			union(a, b);
			
			if (find(c) == find(v)) {
				System.out.println(node[0]);
				break;
			}
		}
	}
}
