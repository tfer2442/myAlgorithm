import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] honey = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }
        
        // 누적합 배열 계산
        int[] prefixSum = new int[N];
        prefixSum[0] = honey[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i-1] + honey[i];
        }
        
        int maxHoney = 0;
        
        for (int i = 1; i < N-1; i++) {
            // 왼쪽 벌이 모으는 꿀
            int bee1 = prefixSum[i] - prefixSum[0];
            
            // 오른쪽 벌이 모으는 꿀
            int bee2 = prefixSum[N-1] - prefixSum[i-1] - honey[N-1];
            
            int total = bee1 + bee2;
            maxHoney = Math.max(maxHoney, total);
        }
        
        for (int i = 1; i < N-1; i++) {
            // 왼쪽 벌이 모으는 꿀
            int bee1 = prefixSum[N-1] - prefixSum[0] - honey[i];
            
            // 중간 벌이 모으는 꿀
            int bee2 = prefixSum[N-1] - prefixSum[i];
            
            int total = bee1 + bee2;
            maxHoney = Math.max(maxHoney, total);
        }
        
        for (int i = 1; i < N-1; i++) {
            // 중간 벌이 모으는 꿀
            int bee1 = prefixSum[i] - honey[i];
            
            // 오른쪽 벌이 모으는 꿀
            int bee2 = prefixSum[N-1] - honey[N-1] - honey[i];
            
            int total = bee1 + bee2;
            maxHoney = Math.max(maxHoney, total);
        }
        
        System.out.println(maxHoney);
    }
}