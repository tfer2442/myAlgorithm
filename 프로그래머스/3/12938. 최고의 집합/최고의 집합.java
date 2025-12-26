import java.util.*;

/*
    s : 자연수의 합 (1 <= 100_000_000)
    n : 자연 수의 개수 (1 <= n <= 10_000)
    
    s를 n개의 자연수의 합으로 어떻게 표현할지가 관건
    일단, n이 s보다 작으면 불가능하겠다. 그 것 이외에는 모두 가능할 듯?
    s를 n으로 나눈 후에 남은 것은 공평하게 나눠주면 될 듯
    
*/
class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        } 
        
        int[] answer = new int[n];
        int a = s / n;
        int b = s - a * n;
        
        for (int i = 0; i < n; i++) {
            answer[i] = a;
        }
        
        for (int i = 0; i < b; i++) {
            answer[i%n]++;
        }
        
        Arrays.sort(answer);
            
        return answer;
    }
}