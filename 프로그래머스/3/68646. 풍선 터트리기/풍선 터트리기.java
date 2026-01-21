import java.util.*;

class Solution {
    int[] leftMin;
    int[] rightMin;
    
    public int solution(int[] a) {
        leftMin = new int[a.length];
        rightMin = new int[a.length];
        
        leftMin[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        rightMin[a.length-1] = a[a.length-1];
        
        for (int i = a.length-2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        
        int cnt = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (leftMin[i] < a[i] && rightMin[i] < a[i]) {
                cnt++;
            }
        }
        
        return a.length-cnt;
    }
}