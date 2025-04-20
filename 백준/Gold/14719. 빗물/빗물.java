import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken()); 
        
        int[] heights = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        int totalWater = 0;
        
        // 각 위치마다 고이는 빗물 계산
        for(int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            
            // 왼쪽에서 가장 높은 블록 찾기
            for(int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }
            
            // 오른쪽에서 가장 높은 블록 찾기
            for(int j = i; j < W; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }
            
            // 현재 위치에 고이는 빗물 = min(leftMax, rightMax) - 현재 높이
            int water = Math.min(leftMax, rightMax) - heights[i];
            
            // 양수인 경우만 더함
            if(water > 0) {
                totalWater += water;
            }
        }
        
        System.out.println(totalWater);
    }
}