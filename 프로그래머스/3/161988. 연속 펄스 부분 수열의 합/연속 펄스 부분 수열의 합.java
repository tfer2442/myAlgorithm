import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int[] seq1 = new int[sequence.length];
        int[] seq2 = new int[sequence.length];
        
        int tmp = 1;
        
        for (int i = 0; i < sequence.length; i++) {
            seq1[i] = sequence[i] * tmp;
            seq2[i] = sequence[i] * (-tmp);
            
            tmp *= -1;
        }
        
        long tmp1 = 0;
        long answer1 = 0;
        long tmp2 = 0;
        long answer2 = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            if (seq1[i] + tmp1 > 0) {
                tmp1 += seq1[i];
                answer1 = Math.max(answer1, tmp1);
            } else {
                tmp1 = 0;
            }
        }
        
        
        for (int i = 0; i < sequence.length; i++) {
            if (seq2[i] + tmp2 > 0) {
                tmp2 += seq2[i];
                answer2 = Math.max(answer2, tmp2);
            } else {
                tmp2 = 0;
            }
        }
        
        return Math.max(answer1, answer2);
    }
}