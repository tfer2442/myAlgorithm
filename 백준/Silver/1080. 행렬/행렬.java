import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] board1;
	public static int[][] board2;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board1 = new int[N][M];
		board2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				board1[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				board2[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		int answer = 0;
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (board1[i-1][j-1] != board2[i-1][j-1]) {
					for (int k = i-1; k < i-1+3; k++) {
						for (int l = j-1; l < j-1+3; l++) {
							if (board1[k][l] == 1) {
								board1[k][l] = 0;
							} else {
								board1[k][l] = 1;
							}
						}
					}
					answer++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board1[i][j] != board2[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}

}
