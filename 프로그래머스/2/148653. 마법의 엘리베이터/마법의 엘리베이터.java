class Solution {
    int answer = 46;
    
    void dfs(int storey, int cnt) {
        if (cnt >= answer) {
            return;
        }
        if (storey == 0) {
            answer = cnt;
            return;
        }
        
        int last = storey % 10;
                 
        // 맨 마지막 자리를 올림
        dfs(storey/10 + 1, cnt + (10-last));
        
        
        // 맨 마지막 자리를 버림
        dfs(storey/10 , cnt + last);
        
    }
    
    public int solution(int storey) { 
        dfs(storey, 0);
        
        return answer;
    }
}