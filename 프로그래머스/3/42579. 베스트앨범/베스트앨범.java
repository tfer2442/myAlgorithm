import java.util.*;

class Solution {
    
    static class Node {
        String key;
        Integer value;
        
        Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> hm = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!hm.containsKey(genres[i])) {
                hm.put(genres[i], new PriorityQueue<>((o1, o2) -> {
                    return Integer.compare(o2[0], o1[0]);
                }));    
            }
            
            hm.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        List<Node> l1 = new ArrayList<>();
        
        for (String key : total.keySet()) {
            l1.add(new Node(key, total.get(key)));
        }
        
        l1.sort((o1, o2)-> {
            return Integer.compare(o2.value, o1.value);
        });
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < l1.size(); i++) {
            String key = l1.get(i).key;
            
            PriorityQueue<int[]> pq = hm.get(key);
            
            for (int j = 0; j < 2; j++) {
                if (pq.isEmpty()) break;
                
                answerList.add(pq.poll()[1]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}