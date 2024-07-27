import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
	static int T;
	static int n;
	static int sr, sc;
	static int er, ec;
	static boolean flag;
	static ArrayList<int[]> store;
	static Set<Pair> visited;
	
	static class Pair {
		int x, y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Pair pair = (Pair) obj;
			
			return this.x == pair.x && this.y == pair.y;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(x, y);
		}
	}
	
	public static void dfs(int row, int col) {
		if (flag) {
			return;
		}
		
		if (Math.abs(er-row) + Math.abs(ec-col) <= 1000) {
			flag = true;
			return;
		}
		
		for (int[] next : store) {
			if (Math.abs(row-next[0]) + Math.abs(col-next[1]) <= 1000 && !visited.contains(new Pair(next[0], next[1]))) {
				visited.add(new Pair(next[0], next[1]));
				dfs(next[0], next[1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			tmp = br.readLine().split(" ");
			sr = Integer.parseInt(tmp[0]);
			sc = Integer.parseInt(tmp[1]);
			store = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				tmp = br.readLine().split(" ");
				store.add(new int[] {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])});
			}
			
			tmp = br.readLine().split(" ");
			er = Integer.parseInt(tmp[0]);
			ec = Integer.parseInt(tmp[1]);
			
			visited = new HashSet<>();
			flag = false;
			visited.add(new Pair(sr, sc));
			dfs(sr, sc);
			
			if (flag) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}	
	}
}
