import java.util.*;

class Solution {
    boolean[] visited;
    int N;
    int answer;
    int[][] arr;
    
    void dfs(int depth, int curK) {
        answer = Math.max(answer, depth);
        
        if (depth > N) {
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (arr[i][0] > curK) continue;
            
            visited[i] = true;
            dfs(depth+1, curK-arr[i][1]);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];

        arr = dungeons;
        
        for (int i = 0; i < N; i++) {
            if (dungeons[i][0] > k) continue;
            visited[i] = true;
            dfs(1, k-dungeons[i][1]);
            visited[i] = false;
        }

        return answer;
    }
}