import java.util.*;

class Solution {
    static class Node {
        int idx;
        double rate;
        
        Node(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        ArrayList<Node> l1 = new ArrayList<>();
        int K = stages.length;
        int[] nums = new int[N+2];
        
        Arrays.fill(nums, 0);
        
        for (int i = 0; i < K; i++) {
            nums[stages[i]]++;
        }
                
        int sum = 0;
                
        for (int i = 1; i <= N; i++) {
            if (K-sum == 0) {
                l1.add(new Node(i, 0));
                continue;
            }
            
            l1.add(new Node(i, (double)nums[i]/(K-sum)));
            System.out.println((double)nums[i]/(K-sum));
            sum += nums[i];
        }
        
        l1.sort((o1, o2) -> {
           int cmp = Double.compare(o2.rate, o1.rate);

           if (cmp == 0) {
               return Integer.compare(o1.idx, o2.idx);
           }
            
           return cmp;
        });
        
        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            answer[i] = l1.get(i).idx;
        }      
        
        return answer;
    }
}