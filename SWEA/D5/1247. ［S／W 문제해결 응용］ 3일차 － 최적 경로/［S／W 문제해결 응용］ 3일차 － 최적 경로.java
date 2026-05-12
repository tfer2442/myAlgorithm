import java.util.*;
import java.io.*;

public class Solution {
    public static int T, N;
    public static int[][] p, dp;
    public static final int INF = 1_000_000_000;

    public static int calculateDistance(int v1, int v2) {
        return Math.abs(p[v1][0] - p[v2][0]) + Math.abs(p[v1][1] - p[v2][1]);
    }

    public static int tsp(int now, int visited) {
        if (visited == (1 << N) - 1) {
            // 모든 고객 방문 후 집으로 이동
            return calculateDistance(now, 1);
        }

        if (dp[now][visited] != INF) {
            return dp[now][visited];
        }

        for (int i = 2; i < N; i++) {
            if ((visited & (1 << i)) != 0) continue;

            int nextVisited = visited | (1 << i);

            dp[now][visited] = Math.min(
                    dp[now][visited],
                    calculateDistance(now, i) + tsp(i, nextVisited)
            );
        }

        return dp[now][visited];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()) + 2;

            p = new int[N][2];
            dp = new int[N][1 << N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                p[i][0] = x;
                p[i][1] = y;

                Arrays.fill(dp[i], INF);
            }

            System.out.print("#" + t + " ");

            // 0번 회사, 1번 집은 방문 처리
            // 실제 이동은 회사에서 시작하고, 집은 마지막에만 감
            System.out.println(tsp(0, 3));
        }
    }
}