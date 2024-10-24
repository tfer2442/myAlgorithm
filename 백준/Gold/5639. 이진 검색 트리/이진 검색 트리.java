import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static HashMap<Integer, int[]> tree;
	public static int root;
	
	public static void insert(int cur, int child) {
		if (!tree.containsKey(cur)) {
			tree.put(cur, new int[] {0, 0});
		}
		
		if (tree.get(cur)[0] == 0 && cur > child) {
			tree.get(cur)[0] = child;
			tree.put(child, new int[] {0, 0});
			return;
		}
		else if (tree.get(cur)[1] == 0 && cur < child) {
			tree.get(cur)[1] = child;
			tree.put(child, new int[] {0, 0});
			return;
		}
		else if (cur > child) {
			insert(tree.get(cur)[0], child);
			return;
		}
		else if (cur < child) {
			insert(tree.get(cur)[1], child);
			return;
		}
	}
	
	public static void postOrder(int cur) {
		if (!tree.containsKey(cur)) {
			return;
		}
		
		postOrder(tree.get(cur)[0]);
		postOrder(tree.get(cur)[1]);
		System.out.println(cur);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new HashMap<>();
		root = Integer.parseInt(br.readLine());
		tree.put(root, new int[] {0, 0});
		
		while (true) {
			String tmp = br.readLine();
			
			if (tmp == null || tmp.equals("")) {
				break;
			}
			
			int node = Integer.parseInt(tmp);
			insert(root, node);
		}

		postOrder(root);
	}

}
