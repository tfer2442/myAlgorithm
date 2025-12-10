import java.util.*;

/*
0 <= cacheSize <= 30
도시 수 <= 100,000
도시 이름 길이 <= 20, 도시 이름은 영문자로 구성

*/

class Solution {
    public void allPlusOne(HashMap<String, Integer> hm) {
        for (String tmp : hm.keySet()) {
            hm.put(tmp, hm.get(tmp)+1);
        }
    }
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String city : cities) {
            // 캐시 안에 city 있는지 확인
            city = city.toUpperCase();
            
            if (hm.containsKey(city)) {
                hm.put(city, 0);
                answer += 1;
                allPlusOne(hm);
                
                continue;
            }
            
            
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }
            
            if (hm.size() < cacheSize) {
                hm.put(city, 0);
                answer += 5;
                allPlusOne(hm);
                
                continue;
            }
            
            int maxValue = -1;
            String maxKey = "";

            for (String tmp : hm.keySet()) {
                if (maxValue < hm.get(tmp)) {
                    maxValue = hm.get(tmp);
                    maxKey = tmp;
                }
            }
            
            hm.remove(maxKey);
            hm.put(city, 0);
            answer += 5;
            allPlusOne(hm);
        }
        
        return answer;
    }
}