import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, L, K;
	public static int[][] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[K][2];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int maxValue = 0;
		
		for (int i = 0; i < K; i++) {
		    for (int j = i; j < K; j++) {  
		        int answer = 0;
		        
		        // 두 별의 좌표로부터 왼쪽 상단 후보 좌표 결정
		        int candidateX = Math.min(nums[i][0], nums[j][0]);
		        int candidateY = Math.max(nums[i][1], nums[j][1]);
		        
		        for (int k = 0; k < K; k++) {
		            int curX = nums[k][0];
		            int curY = nums[k][1];

		            if (candidateX <= curX && curX <= candidateX + L &&
		                candidateY - L <= curY && curY <= candidateY)
		                answer++;
		        }
		        maxValue = Math.max(answer, maxValue);
		    }
		}
		System.out.println(K-maxValue);
	}
}
