import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] scv;
	public static int answer = Integer.MAX_VALUE;
	public static int[][][] visited = new int[61][61][61];
	
	public static void dfs(int depth, int hp1, int hp2, int hp3) {
		int[] tmp = {hp1, hp2, hp3};
		Arrays.sort(tmp);
		
		for (int i = 0; i < 3; i++) {
			if (tmp[i] < 0) tmp[i] = 0;
		}
		
		if (tmp[0] == 0 && tmp[1] == 0 && tmp[2] == 0) {
			answer = Math.min(answer, depth);
			return;
		}
		
		if (visited[tmp[0]][tmp[1]][tmp[2]] <= depth) return;
		visited[tmp[0]][tmp[1]][tmp[2]] = depth;
		
		dfs(depth+1, tmp[0]-9, tmp[1]-3, tmp[2]-1);
		dfs(depth+1, tmp[0]-9, tmp[1]-1, tmp[2]-3);
		dfs(depth+1, tmp[0]-3, tmp[1]-9, tmp[2]-1);
		dfs(depth+1, tmp[0]-3, tmp[1]-1, tmp[2]-9);
		dfs(depth+1, tmp[0]-1, tmp[1]-9, tmp[2]-3);
		dfs(depth+1, tmp[0]-1, tmp[1]-3, tmp[2]-9);
		
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		scv = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(scv);
		
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				for (int k = 0; k < 61; k++) {
					visited[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		dfs(0, scv[0], scv[1], scv[2]);
		System.out.println(answer);
	}
}
