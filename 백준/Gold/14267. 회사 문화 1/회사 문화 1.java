import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static ArrayList<Integer>[] child;
	public static int[] good;
	public static int[] total;
	
	public static void dfs(int cur, int sum) {
		total[cur] = good[cur] + sum;

		if (child[cur].isEmpty()) {
			return;
		}
		
		for (int next : child[cur]) {
			dfs(next, good[cur] + sum);
		}
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		child = new ArrayList[n+1];
		good = new int[n+1];
		total = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			child[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a == -1) continue;
			child[a].add(i);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			good[p] += v;
		}
		
		dfs(1, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(total[i]).append(" ");
		}
		System.out.println(sb);
	}

}
