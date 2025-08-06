import java.util.*;
import java.io.*;

/*
 * 다시 풀어 보기
 * 
 * 재귀 함수를 이용한 하노이탑
 * 직접 모든걸 따라가보려고 하지말고, 큰 부분을 작은 부분으로 나누고
 * 그게 반복 되는건지를 확인한 이후에 규칙을 찾으면 됨
 */
public class Main {
    public static int N;
    
    // 재귀 시 바로 출력 문자열에 기록
    public static void hanoi(int n, int start, int mid, int end, StringBuilder sb) {
        if (n == 1) {
            sb.append(start).append(' ').append(end).append('\n');
            return;
        }
        hanoi(n-1, start, end, mid, sb);
        sb.append(start).append(' ').append(end).append('\n');
        hanoi(n-1, mid, start, end, sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long moves = (1L << N) - 1;             // 2^N - 1
        StringBuilder sb = new StringBuilder();
        sb.append(moves).append('\n');

        hanoi(N, 1, 2, 3, sb);

        System.out.print(sb);
    }
}