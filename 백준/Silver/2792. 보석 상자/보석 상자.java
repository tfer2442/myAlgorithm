import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] nums;
    public static int answer = 0;

    public static int cal(int mid) {
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            if (nums[i] <= mid) {
                cnt += 1;
                continue;
            }

            cnt += (int)Math.ceil((double)nums[i]/mid);
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];

        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left+right) / 2;
            int num = cal(mid);

            // 사람 수보다 보석을 더 나눠줘야 한다면, 보석을 더 큰 크기로 나눠야 함.
            if (num > N) {
                left = mid + 1;
            } else if (num <= N) { // 사람 수보다 보석을 덜 나눠줘야 한다면, 보석을 더 작은 크기로 나눠야 함. -> 이 때, 정답이 가능함.
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
