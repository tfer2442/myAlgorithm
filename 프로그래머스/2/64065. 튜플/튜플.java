import java.util.*;

/*
맨 왼쪽 괄호 삭제, 맨 오른쪽 괄호 삭제
},{ 로 split,, String 배열에 넣기
*/

class Solution {
    public int[] solution(String s) {
        
        ArrayList<Integer> l1 = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        
        s = s.substring(2, s.length()-2);
        String[] a = s.split("},\\{");
        
        Arrays.sort(a, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        
        for (int i = 0; i < a.length; i++) {
            String[] tmp = a[i].split(",");
            
            for (int j = 0; j < tmp.length; j++) {
                if (hs.contains(Integer.parseInt(tmp[j]))) continue;
                
                hs.add(Integer.parseInt(tmp[j]));
                l1.add(Integer.parseInt(tmp[j]));
            }
        }
        
        int[] answer = new int[l1.size()];
        
        for (int i = 0; i < l1.size(); i++) {
            answer[i] = l1.get(i);
        }
        
        return answer;
    }
}