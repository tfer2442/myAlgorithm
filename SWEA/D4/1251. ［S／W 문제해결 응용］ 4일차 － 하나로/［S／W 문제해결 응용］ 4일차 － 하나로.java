import java.util.*;
import java.io.*;

/*
 * MST문제
 * 각 점들이 모두 갈 수 있는 길이 있다고 생각하면 되겠네
 * 2차원 배열로 좌표 표현
 * 크루스칼로 풀자
 */
public class Solution {
	public static int T, N;
	public static int[] x, y, parents;
	public static PriorityQueue<double[]> pq;
	public static double E;
	
	public static int findParent(int x) {
		if (parents[x] == x) {
			return x;
		}
		
		return parents[x] = findParent(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		
		if (parentA == parentB) return false;
		
		parents[parentA] = parentB;
		return true;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			x = new int[N];
			y = new int[N];
			
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			// [0] : 길이, [1], [2] : 연결 좌표
			pq = new PriorityQueue<>((o1, o2)->{
				return Double.compare(o1[0], o2[0]);
			});
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					pq.add(new double[] {Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)), i, j});
				}
			}
			
			parents = new int[N];
			
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}
			
			int cnt = 0;
			double sum = 0;
			
			while (!pq.isEmpty()) {
				if (cnt == N-1) {
					break;
				}
				
				double[] node = pq.poll();
				
				if (union((int)node[1], (int)node[2])) {
					cnt++;
					sum += E * (node[0] * node[0]);
				}
			}
			
			System.out.println("#" + t + " " + Math.round(sum));
		}
	}

}
