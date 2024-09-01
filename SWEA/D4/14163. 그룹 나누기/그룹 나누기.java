import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int T;
	public static int N, M;
	public static int[] parents;
	
	public static int findParent(int x) {
		if (parents[x] == x) {
			return x;
		}
		
		return parents[x] = findParent(parents[x]);
	}
	
	
	public static boolean unionSet(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		
		if (parentA == parentB) return false;
		
		if (parentA > parentB) {
			parents[parentA] = parentB;
		} else if (parentA < parentB) {
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
			parents = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M*2; i+=2) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				unionSet(a, b);
			}
			
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (parents[i] == i) {
					answer++;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
