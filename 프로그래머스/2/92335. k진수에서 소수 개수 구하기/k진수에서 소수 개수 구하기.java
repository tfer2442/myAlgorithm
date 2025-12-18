import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    
    private boolean isPrime(long x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;

        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private void calculate(String s) {
        long v = Long.parseLong(s);
        if (isPrime(v)) answer++;
    }
    
    public int solution(int n, int k) {
        String s1;
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n = n / k;
        }
        
        s1 = sb.reverse().toString();
                
        sb = new StringBuilder();
        
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '0' && sb.length() == 0) {
                continue;
            }
            
            if (s1.charAt(i) == '0') {
                calculate(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            
            sb.append(s1.charAt(i));

            if (i == s1.length()-1) {
                calculate(sb.toString());
            }
        }
        
        
        return answer;
    }
}