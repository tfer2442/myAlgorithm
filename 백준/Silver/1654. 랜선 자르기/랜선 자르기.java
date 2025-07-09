import java.util.*;
import java.io.*;

public class Main {
    public static int K, N;
    public static int[] nums;
    
    public static int calculate(long mid) {
        int cnt = 0;
        
        for (int i = 0; i < K; i++) {
            cnt += nums[i] / mid;
        }
        
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        nums = new int[K];
        
        long left = 1;
        long right = 0;  // 최대값으로 설정할 예정
        
        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());
            nums[i] = tmp;
            right = Math.max(right, tmp);  // 입력된 랜선 중 최대값
        }

        long answer = 1;
        while (left <= right) {
            long mid = (left + right) / 2;  // 정수 나눗셈
            int tmp = calculate(mid);
                        
            if (tmp >= N) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}