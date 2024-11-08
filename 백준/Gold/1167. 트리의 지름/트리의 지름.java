import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	public static int N;
	public static ArrayList<int[]>[] tree;
	public static boolean[] visited;
	public static long len1 = 0;
	public static int ver1 = 1;
	
	public static void dfs(int cur, long length) {
		if (length > len1) {
			ver1 = cur;
			len1 = length;
		}
		
		for (int[] tmp : tree[cur]) {
			int next = tmp[0];
			int value = tmp[1];
			
			if (visited[next]) continue;
			visited[next]=true;
			dfs(next, length+value);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			
			while (true) {
				int next = Integer.parseInt(st.nextToken());
				if (next == -1) break;
				int value = Integer.parseInt(st.nextToken());
				
				tree[cur].add(new int[] {next, value});
			}
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 0);
		visited = new boolean[N+1];
		visited[ver1] = true;
		dfs(ver1, 0);
		
		System.out.println(len1);
	}

}
