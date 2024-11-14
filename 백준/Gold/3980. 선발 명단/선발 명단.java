import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static int T;
	public static int[][] board;
	public static boolean[] visited;
	public static int total;
	
	public static void permu(int index, int sum) {
		if (index >= 11) {
			total = Math.max(total, sum);
			return;
		}
		
		for (int i = 0; i < 11; i++) {
			if (visited[i]) continue;
			if (board[index][i] == 0) continue;
			visited[i] = true;
			permu(index+1, board[index][i]+sum);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			board = new int[11][11];
			visited = new boolean[11];
			total = 0;
			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			permu(0, 0);
			System.out.println(total);
		}
	}

}
