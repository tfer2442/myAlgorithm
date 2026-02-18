import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int n = 0;
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(0.0);
        int prev = k;
        
        while (k > 1) {
            n++;            
            prev = k;
            
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k*3 + 1;
            }
            
            double value = ((double)prev + k) / 2;
            
            arr.add(arr.get(n-1) + value);
        }
        
        double[] answer = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if (a > b || a > n || b > n) {
                answer[i] = -1.0;
                continue;
            }
            
            answer[i] = arr.get(b) - arr.get(a);
        }
        
        return answer;
    }
}