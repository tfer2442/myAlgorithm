import java.util.*;  

class Solution
{
    int answer = 1;
    
    public void palindrome(int left, int right, String s) {
        int l = left;
        int r = right;
        
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return;
            }
            left++;
            right--;
        }

        answer = Math.max(answer, r-l+1);
    } 
    
    public int solution(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int left = i;
                int right = j;
                
                palindrome(left, right, s);        
            }
        }
        

        return answer;
    }
}