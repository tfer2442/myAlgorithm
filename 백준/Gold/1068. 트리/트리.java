import java.util.*;
import java.io.*;

/*
 * 노드 하나를 삭제하고, 리프 노드의 개수를 찾는 문제
 * 삭제할 노드에서부터 dfs를 돌려서, -1로 변경
 * -1이 아닌 숫자들 중에서 자신을 부모로하는 숫자가 있는지 확인 (HashSet 이용)
 * 
 */
public class Main {
	public static int N, K;
	public static ArrayList<Integer>[] tree;
	public static int[] parents;

	public static void dfs(int cur) {
		parents[cur] = -1;
		
		for (int next : tree[cur]) {
			dfs(next);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		parents = new int[N];
		tree = new ArrayList[N];
		int root = 0;
		
		for (int i = 0 ; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < N; i++) {
			parents[i] = Integer.parseInt(st.nextToken());
			
			if (parents[i] == -1) {
				root = i;
				continue;
			}
			tree[parents[i]].add(i);
		}
		
		K = Integer.parseInt(br.readLine());
		
		if (root == K) {
			System.out.println(0);
			return;
		}
		
		dfs(K);
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			if (parents[i] == -1) continue;
			
			hs.add(parents[i]);
		}
		
		if (hs.isEmpty()) {
			System.out.println(1);
			return;
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (parents[i] == -1) continue;
			if (!hs.contains(i)) {
				cnt++;				
			}
		}
		
		System.out.println(cnt);
	}
}
