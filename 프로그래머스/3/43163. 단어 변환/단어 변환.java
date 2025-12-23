import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int cnt = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                cnt++;
            }
        }
        
        // words 배열 안에 target 없음
        if (cnt == words.length) {
            return 0;
        }
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        for (int i = 0; i < words.length; i++) {
            int diff = 0;
            
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
                
                if (diff >= 2) break;
            }
            
            if (diff == 1) {
                if (words[i].equals(target)) return 1;
                
                dq.add(new int[]{i, 1});
            }
        }
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            int v = node[0];
            int depth = node[1];
            
            if (depth >= words.length) return 0;
            
            for (int i = 0; i < words.length; i++) {
                
                int diff = 0;
            
                for (int j = 0; j < begin.length(); j++) {
                    if (words[v].charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }

                    if (diff >= 2) break;
                }

                if (diff == 1) {
                    if (words[i].equals(target)) return depth+1;

                    dq.add(new int[]{i, depth+1});
                }
            }
        }
        
        int answer = 0;
        return answer;
    }
}