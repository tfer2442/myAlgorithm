import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> hs = new HashSet<>();
        
        int r = 0;
        int c = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            String check = r+","+c+dirs.charAt(i);
            
            int nextR = r;
            int nextC = c;
            char reverse = '0';
            
            if (dirs.charAt(i) == 'U') {
                nextR += -1;
                reverse = 'D';
            } else if(dirs.charAt(i) == 'R') {
                nextC += 1;
                reverse = 'L';
            } else if(dirs.charAt(i) == 'D') {
                nextR += 1;
                reverse = 'U';
            } else if(dirs.charAt(i) == 'L') {
                nextC += -1;
                reverse = 'R';
            }
            
            if (Math.abs(nextR) > 5 || Math.abs(nextC) > 5) continue;
            
            r = nextR;
            c = nextC;
            
            String check2 = r+","+c+reverse;
            
            if (!hs.contains(check) && !hs.contains(check2)) {
                answer++;
                hs.add(check);
            }
        }
        
        return answer;
    }
}