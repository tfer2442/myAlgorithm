import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int T;
	public static int n, m;
	public static int[] parents;
	
	public static int findParent(int x) {
		if (parents[x] == x) {
			return x;
		}
		parents[x] = findParent(parents[x]);
		return parents[x];
	}
	
	public static boolean unionSet(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		

	    if (parentA != parentB) {
	        // 부모를 병합합니다.
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
			StringBuilder sb = new StringBuilder();
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int com = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (com == 0) {
					unionSet(a, b);
					continue;
				}
				
				if (com == 1) {
					if (findParent(a) == findParent(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			
			System.out.println("#" + t + " " + sb.toString());
			
		}
	}

}
