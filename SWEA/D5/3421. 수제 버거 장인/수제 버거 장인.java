import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int T, N, M;
	public static boolean[] visited;
	public static int[][] notCombi;
	public static int answer;
	
	public static void calSubTree(int depth) {
		if (depth == N+1) {
			for (int i = 0; i < M; i++) {
				if (visited[notCombi[i][0]] && visited[notCombi[i][1]]) {
					return;
				}
			}
			answer++;
			return; 
		} 
		
		visited[depth] = true; 
		calSubTree(depth+1);
		visited[depth] = false;
		calSubTree(depth+1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			notCombi = new int[M][2];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				notCombi[i][0] = Integer.parseInt(st.nextToken());
				notCombi[i][1] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N+1];
			answer = 0;
			calSubTree(1);
			System.out.println("#" + t + " " + answer);
		}
	}

}
