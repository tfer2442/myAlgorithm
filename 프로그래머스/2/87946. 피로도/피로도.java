import java.util.*;

class Solution {
    boolean[] visited;
    int N;
    int answer;
    
    void dfs(int depth, int curK, int[][] dungeons) {
        if (depth == N) {
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (dungeons[i][0] > curK) continue;
            visited[i] = true;
            answer = Math.max(answer, depth+1);
            dfs(depth+1, curK-dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
}