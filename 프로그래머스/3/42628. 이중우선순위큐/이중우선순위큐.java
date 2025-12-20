import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>((o1, o2) -> {
            return o1-o2;
        });
        
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int pqSize = 0;
        
        for (String op : operations) {
            String[] cmd = op.split(" ");
            
            if (cmd[0].equals("I")) {
                int key = Integer.parseInt(cmd[1]);
                
                minPq.add(key);
                maxPq.add(key);
                pqSize++;
                
                hm.put(key, hm.getOrDefault(key, 0) + 1);
                
                continue;
            }
            
            if (cmd[0].equals("D") && cmd[1].equals("1")) {
                
                while (true) {
                    if (pqSize == 0) break;
                    
                    int peek = maxPq.peek();
                    
                    if (hm.get(peek) == 0) {
                        maxPq.poll();
                        
                        continue;
                    }
                    
                    if (hm.get(peek) >= 1) {
                        hm.put(peek, hm.get(peek) - 1);
                        maxPq.poll();
                        pqSize--;
                        
                        break;
                    }
                }
                
                continue;
            } 
            
            if (cmd[0].equals("D") && cmd[1].equals("-1")) {
                
                while (true) {
                    if (pqSize == 0) break;
                    
                    int peek = minPq.peek();
                    
                    if (hm.get(peek) == 0) {
                        minPq.poll();
                        
                        continue;
                    }
                    
                    if (hm.get(peek) >= 1) {
                        hm.put(peek, hm.get(peek) - 1);
                        minPq.poll();
                        pqSize--;
                        
                        break;
                    }
                }
                
                continue;
            }
        }
        
        int[] answer = {0, 0};
        
        if (pqSize == 0) {
            return answer;
        }
        
        while (!maxPq.isEmpty()) {
            int peek = maxPq.peek();
            
            if (hm.getOrDefault(peek, 0) == 0) {
                maxPq.poll();
                continue;
            }
            
            answer[0] = peek;
            break;
        }
        
        while (!minPq.isEmpty()) {
            int peek = minPq.peek();
            
            if (hm.getOrDefault(peek, 0) == 0) {
                minPq.poll();
                continue;
            }
            
            answer[1] = peek;
            break;
        }
        
        return answer;
    }
}