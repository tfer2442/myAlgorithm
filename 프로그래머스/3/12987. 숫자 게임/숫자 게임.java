import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int N = A.length;
        
        Integer[] A1 = new Integer[N];
        Integer[] B1 = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            A1[i] = A[i];
            B1[i] = B[i];
        }
        
        Arrays.sort(A1, Collections.reverseOrder());
        Arrays.sort(B1, Collections.reverseOrder());
        
        int left = 0;
        
        for (int right = 0; right < N; right++) {
            while (left < N) {
                if (A1[left] < B1[right]) {
                    left++;
                    answer++;
                    break;
                }
                
                left++;
            }
        }
        
        return answer;
    }
}