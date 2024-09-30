import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] weights, values;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weights = new int[N + 1];
		values = new int[N + 1];
		dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) { // 물품 번호
			for (int j = 1; j <= K; j++) { // 가방의 무게
				// 가방 무게보다 무거우면 넣지 못함
				if (weights[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} 
				// 가방 무게보다 작거나 같다면 넣거나 넣지 않을 수 있음
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}