import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] board;
	public static int[][] visited;
	public static ArrayDeque<int[]> dq = new ArrayDeque<>();
	public static int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		visited[0][0] = 0;
//		visited[N-1][M-1] = 0;
		
		dq.add(new int[] {0, 0, 0});
		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int[] dd : d) {
				int nextR = node[0] + dd[0];
				int nextC = node[1] + dd[1];

				if (0 > nextR || nextR >= N || 0 > nextC || nextC >= M) continue;
				
				if (board[nextR][nextC] == 0 && node[2] < visited[nextR][nextC]) {
					visited[nextR][nextC] = node[2];
					dq.add(new int[] {nextR, nextC, node[2]});
				} else if (board[nextR][nextC] == 1 && node[2]+1 < visited[nextR][nextC]) {
					visited[nextR][nextC] = node[2] + 1;
					dq.add(new int[] {nextR, nextC, node[2]+1});
				}
			}
		}
		
		System.out.println(visited[N-1][M-1]);
	}
}
