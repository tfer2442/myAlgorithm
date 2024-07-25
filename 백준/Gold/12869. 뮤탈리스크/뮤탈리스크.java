import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	static int n;
	static boolean[] visited;
	static boolean[][][] scvVisited = new boolean[61][61][61];
	static List<int[]> perNums;
	static List<Integer> scvs;
	static int[] attacks = {9, 3, 1};
	static int result = Integer.MAX_VALUE;
	
	public static void permutations(List<Integer> nums, int depth) {
		if (depth == 3) {
			int[] tmp = new int[3];
	
			for (int i = 0; i < 3; i++) {
				tmp[i] = nums.get(i);
			}
			perNums.add(tmp);
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums.add(attacks[i]);
				permutations(nums, depth+1);
				visited[i] = false;
				nums.remove(nums.size()-1);
			}
		}
	}
	
	public static void dfs(int hp1, int hp2, int hp3, int depth) {
		if (depth >= result) {
			return;
		}
		
		if (hp1 <= 0 && hp2 <= 0 && hp3 <= 0) {
			result = Math.min(result, depth);
			return;
		}
		
		Integer[] hp = {hp1, hp2, hp3};
		
		Arrays.sort(hp, (a, b) -> {
			return -1 * (a-b);
		});
				
		for (int i = 0; i < 3; i++) {
			if (hp[i] < 0) {
				hp[i] = 0;
			}
		}
		
		if (scvVisited[hp[0]][hp[1]][hp[2]]) {
			return;
		}
		scvVisited[hp[0]][hp[1]][hp[2]] = true;
		
		for (int i = 0; i < perNums.size(); i++) {
			dfs(hp[0]-perNums.get(i)[0], hp[1]-perNums.get(i)[1], hp[2]-perNums.get(i)[2], depth+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		scvs = new ArrayList<>();
		visited = new boolean[3];
		perNums = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			scvs.add(Integer.parseInt(tmp[i]));
		}
		
		for (int i = n-1; i < 3; i++) {
			scvs.add(0);
		}
		
		permutations(new ArrayList<>(), 0);
		dfs(scvs.get(0), scvs.get(1), scvs.get(2), 0);
		System.out.println(result);
	}
}
