import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int K;
    public static char[][] arr;
    public static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        arr = new char[N + 1][M + 1]; 
        dp = new int[N + 1][M + 1][3]; // 누적합 배열 (J, O, I 순서)

        // 행성 맵 입력 받기
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = tmp.charAt(j - 1);
            }
        }

        // 2D 누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 이전 누적합 계산 (위쪽 + 왼쪽 - 중복된 왼쪽 위 대각선)
                dp[i][j][0] = dp[i-1][j][0] + dp[i][j-1][0] - dp[i-1][j-1][0];
                dp[i][j][1] = dp[i-1][j][1] + dp[i][j-1][1] - dp[i-1][j-1][1];
                dp[i][j][2] = dp[i-1][j][2] + dp[i][j-1][2] - dp[i-1][j-1][2];

                // 현재 위치의 값 추가
                if (arr[i][j] == 'J') {
                    dp[i][j][0]++;
                } else if (arr[i][j] == 'O') {
                    dp[i][j][1]++;
                } else if (arr[i][j] == 'I') {
                    dp[i][j][2]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 행
            int b = Integer.parseInt(st.nextToken()); // 시작 열
            int c = Integer.parseInt(st.nextToken()); // 끝 행
            int d = Integer.parseInt(st.nextToken()); // 끝 열

            // 각 지형 유형별 개수 계산
            int jungles = dp[c][d][0] - dp[a-1][d][0] - dp[c][b-1][0] + dp[a-1][b-1][0];
            int oceans = dp[c][d][1] - dp[a-1][d][1] - dp[c][b-1][1] + dp[a-1][b-1][1];
            int ices = dp[c][d][2] - dp[a-1][d][2] - dp[c][b-1][2] + dp[a-1][b-1][2];

            sb.append(jungles).append(" ").append(oceans).append(" ").append(ices).append("\n");
        }

        System.out.print(sb);
    }
}