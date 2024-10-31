import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 3; t++) {

            int n = Integer.parseInt(br.readLine());
            int[] values = new int[n];
            int[] quantities = new int[n];
            int total = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                values[i] = Integer.parseInt(st.nextToken());
                quantities[i] = Integer.parseInt(st.nextToken());
                total += values[i] * quantities[i];
            }

            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            }

            int target = total / 2;

            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                int v = values[i];
                int q = quantities[i];

                ArrayList<Integer> counts = new ArrayList<>();
                int k = 1;
                while (q > 0) {
                    int cnt = Math.min(k, q);
                    counts.add(cnt * v);
                    q -= cnt;
                    k <<= 1;
                }

                for (int cntv : counts) {
                    for (int j = target; j >= cntv; j--) {
                        if (dp[j - cntv]) {
                            dp[j] = true;
                        }
                    }
                }
            }

            if (dp[target]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }
}
