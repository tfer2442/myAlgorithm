import java.util.*;

class Solution {
    
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a%b);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean flagA = false;
        
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                flagA = true;
            }
        }
        
        boolean flagB = false;
        
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                flagB = true;
            }
        }
        
        if (flagA && flagB) {
            return 0;
        }
        
        return Math.max(gcdA, gcdB);
    }
}