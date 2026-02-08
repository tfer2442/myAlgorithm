class Solution {
    // 각 배열의 최대공약수를 구한다.
    // 구한 최대공약수로 반대편 배열을 나눠본다 (0 or 숫자 반환)
    // Math.max로 더 높은 값을 return
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    
    int calculate(int value, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % value == 0) return 0;
        }
        
        return value;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = arrayA[0];
        int b = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }
        
        for (int i = 1; i < arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }
        
        int value1 = calculate(a, arrayB);
        int value2 = calculate(b, arrayA);
        
        return Math.max(value1, value2);
    }
}