import java.util.*;

/*
    투 포인터 문제
    1. 보석의 종류 갯수 세기
    2. 보석의 종류를 모두 포함할 수 있도록 right++
    3. 만약 모두 포함하게 되었을 때 부터는 left++ 를 한다
       (보석의 종류를 모두 포함하지 못할 때 까지)
    4. 보석의 종류를 모두 포함할 때까지 다시 right++
    5. 만약 left > right 라면 break
*/

class Solution {
    HashMap<String, Integer> hm = new HashMap<>();
    int N;
    int R;
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len = 0;
        
        N = gems.length;
        
        for (int i = 0; i < N; i++) {
            hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1);
        }
        
        R = hm.size();
        
        int left = 0;
        int right = 0;
        
        hm = new HashMap<>();
        
        for (; right < N; right++) {
            hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);

            if (hm.size() >= R) break;
        }
        
        answer[0] = left+1;
        answer[1] = right+1;
        len = right - left + 1;
        
        while (left < right && right <= N) {
            if (hm.size() >= R) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                
                if (hm.get(gems[left]) == 1) {
                    hm.remove(gems[left]);
                } else {
                    hm.put(gems[left], hm.get(gems[left])-1);
                }
                
                left++;
                 
                continue;
            }
            
            right++;
            
            if (right >= N) {
                continue;
            }
            
            hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
            
        }
        
        return answer;
    }
}