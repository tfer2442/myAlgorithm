import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[][] d = {{-1 ,0}, {0, 1}, {1, 0}, {0, -1}};
	public static int N, M;
	public static int sR, sC;
	public static char[][] arr;
	public static int[] result;
	public static boolean[][][] visited;
	public static boolean flag;
	public static int cnt;
	
	public static void dfs(int curR, int curC, int curD) {
		if (curR < 0 || curR >= N || curC < 0 || curC >= M) return;
		if (arr[curR][curC] == 'C') return;
		
		if (visited[curR][curC][curD]) {
			flag = true;
			return;
		}
		
		visited[curR][curC][curD] = true;
		cnt++;
		int nextD = curD;
		
		if (arr[curR][curC] == '\\') {
			nextD = 3-curD;
		} else if (arr[curR][curC] == '/') {
			if (curD == 0) {
				nextD = 1;
			} else if (curD == 1) {
				nextD = 0;
			} else if (curD == 2) {
				nextD = 3;
			} else if (curD == 3) {
				nextD = 2;
			}
		}
		
		dfs(curR+d[nextD][0], curC+d[nextD][1], nextD);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sR = Integer.parseInt(st.nextToken()) - 1;
		sC = Integer.parseInt(st.nextToken()) - 1;
		
		result = new int[4];
		
		for (int i = 0; i < 4; i++) {
			cnt = 0;
			visited = new boolean[N][M][4];
			flag = false;
			dfs(sR, sC, i);
			
			if (flag) {
				if (i == 0) {
					System.out.println("U");
				} else if (i == 1) {
					System.out.println("R");
				} else if (i == 2) {
					System.out.println("D");
				} else if (i == 3) {
					System.out.println("L");
				}
				
				System.out.println("Voyager");

				return;
			} 
			result[i] = cnt;				
		}
		
		int max = 0;
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			if (result[i] > max) {
				max = result[i];
				answer = i;
			}
		}
		
		if (answer == 0) {
			System.out.println("U");
		} else if (answer == 1) {
			System.out.println("R");
		} else if (answer == 2) {
			System.out.println("D");
		} else if (answer == 3) {
			System.out.println("L");
		}
		
		System.out.println(max);
	}
}
