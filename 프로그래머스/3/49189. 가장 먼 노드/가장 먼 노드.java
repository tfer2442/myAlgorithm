import java.util.*;


class Solution {
    int[] nums;
    
    public int solution(int n, int[][] edge) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        nums = new int[n+1];
        Arrays.fill(nums, -1);
        nums[1] = 0;
        
        dq.add(new int[]{1, 1});
        int maxValue = 0;
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            maxValue = Math.max(maxValue, node[1]);
            
            for (int next : graph[node[0]]) {
                
                if (nums[next] == -1) {
                    nums[next] = node[1] + 1;
                    dq.add(new int[]{next, nums[next]});
                }

            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (nums[i] == maxValue) {
                answer++;
            }
        }
        
        return answer;
    }
}