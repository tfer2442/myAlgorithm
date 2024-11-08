import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    int maxLen = 0;
    String numbers;
    HashSet<Integer> hs;
    boolean[] visited;
    
    public void permutations(String str, int len) {
        if (len > maxLen) return;
        if (!str.equals("")) {
            if (!hs.contains(Integer.parseInt(str)) && isPrime(Integer.parseInt(str))) {
                answer++;
            }
            hs.add(Integer.parseInt(str));
        }
        
        for (int i = 0; i < maxLen; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            String tmp = str + String.valueOf(numbers.charAt(i));
            permutations(tmp, len+1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        
        for (int i = 2; i <= Math.pow(num, 0.5); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(String numbers) {
        maxLen = numbers.length();
        this.numbers = numbers;
        visited = new boolean[maxLen+1];
        hs = new HashSet<>();
        permutations("", 0);
        
        return answer;
    }
}