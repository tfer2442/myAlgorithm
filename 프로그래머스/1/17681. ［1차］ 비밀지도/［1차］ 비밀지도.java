import java.util.*;

class Solution {
    char[][] tmpAnswer;
    String[] strArr1;
    String[] strArr2;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer;
        
        tmpAnswer = new char[n][n];
        strArr1 = new String[n];
        strArr2 = new String[n];
        
        for (int i = 0; i < n; i++) {
            String tmp1 = Integer.toBinaryString(arr1[i]);
            
            if (tmp1.length() < n) {
                tmp1 = "0".repeat(n-tmp1.length()) + tmp1;
            }
            
            String tmp2 = Integer.toBinaryString(arr2[i]);
            
            if (tmp2.length() < n) {
                tmp2 = "0".repeat(n-tmp2.length()) + tmp2;
            }
            
            for (int j = 0; j < n; j++) {
                if (tmp1.charAt(j) == '0' && tmp2.charAt(j) == '0') {
                    tmpAnswer[i][j] = ' ';
                    continue;
                }
                
                tmpAnswer[i][j] = '#';
            }
        }
        
        answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                sb.append(tmpAnswer[i][j]);
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}