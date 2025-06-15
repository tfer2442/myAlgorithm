import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int answer;
    
    public static boolean isAvailable(int col, int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나, 대각선에 있으면 false
            if (arr[i] == col || Math.abs(arr[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    
    public static void backtracking(int row) {
        if (row == N) {  // N개 모두 배치 완료
            answer++;
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (isAvailable(col, row)) {
                arr[row] = col;
                backtracking(row + 1);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        answer = 0;
        
        backtracking(0);
        
        System.out.println(answer);  // 결과 출력
    }
}