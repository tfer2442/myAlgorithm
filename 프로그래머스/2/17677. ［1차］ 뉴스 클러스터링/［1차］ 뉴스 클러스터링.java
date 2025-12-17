import java.util.*;

/*
    둘 다 해쉬맵에 넣어놓고, 겹치는 것 중 적은 것의 개수가 교집합의 개수,
    겹치는 것 중 많은 것의 수가 합칩합의 개수,, 
    
    A먼저 사악 보고, 겹치는 것 A에서도 삭제 B에서도 삭제 
    B는 보면서, 합집합의 개수만 늘어남 
    
    또한, 대문자빼고는 버린다
    만약 둘다 공집합일면? 
*/

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for (int i = 0; i < str1.length()-1; i++) {
            if (str1.charAt(i) < 'A' || str1.charAt(i) > 'Z') continue;
            if (str1.charAt(i+1) < 'A' || str1.charAt(i+1) > 'Z') continue; 
            
            hm1.put(str1.substring(i, i+2), hm1.getOrDefault(str1.substring(i, i+2), 0) + 1);
        }

        for (int i = 0; i < str2.length()-1; i++) {
            if (str2.charAt(i) < 'A' || str2.charAt(i) > 'Z') continue;
            if (str2.charAt(i+1) < 'A' || str2.charAt(i+1) > 'Z') continue; 
            
            hm2.put(str2.substring(i, i+2), hm2.getOrDefault(str2.substring(i, i+2), 0) + 1);
        }
        
        if (hm1.size() == 0 && hm2.size() == 0) {
            return 65536;
        }
        
        int a = 0;
        int b = 0;
                
        for (String hm1Key : hm1.keySet()) {
            a += Math.min(hm1.get(hm1Key), hm2.getOrDefault(hm1Key, 0));
            b += Math.max(hm1.get(hm1Key), hm2.getOrDefault(hm1Key, 0));
            
            hm1.put(hm1Key, 0);
            
            if (hm2.containsKey(hm1Key)) {
                hm2.put(hm1Key, 0);    
            }
        }
        
        for (String hm2Key : hm2.keySet()) {
            a += Math.min(hm2.get(hm2Key), hm1.getOrDefault(hm2Key, 0));
            b += Math.max(hm2.get(hm2Key), hm1.getOrDefault(hm2Key, 0));
            
            hm2.put(hm2Key, 0);
            
            if (hm1.containsKey(hm2Key)) {
                hm1.put(hm2Key, 0);    
            }
        }
        
        return a*65536/b;
    }
}