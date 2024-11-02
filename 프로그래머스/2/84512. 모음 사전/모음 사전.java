import java.util.*;
import java.io.*;

class Solution {
    char[] arr = new char[]{'A', 'E', 'I', 'O', 'U'};
    List<String> words;
    
    public void permu(int depth, int order, String tmp) {
        if (depth > 5) return;
        String cur = tmp + String.valueOf(arr[order]);
        words.add(cur);
        
        for (int i = 0; i < 5; i++) {
            permu(depth+1, i, cur);
        }
    }
    
    public int solution(String word) throws Exception {
        int answer = 0;
        words = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            permu(1, i, "");
        }
        
        answer = words.indexOf(word)+1;
        
        return answer;
    }
}