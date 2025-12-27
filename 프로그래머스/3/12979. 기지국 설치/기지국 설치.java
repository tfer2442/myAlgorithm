import java.util.*;

/*
    1. visited 배열을 사용해서 stations와 w를 통해서 전파가 닿는 곳을 표시
    이후에, 0~n-1까지 전파가 안 닿는 곳을 찾아서,, 점프하면서 기지국 설치할 곳 표시
    -> 시간초과
    
    2. 다른사람풀이: i += 1 부분 없이 한 번에 뛰어넘을 수 있도록 처리,,
    
    
    3. 기가막힌 풀이? 
    기지국이 설치되는 구간을 먼저 합치고, 기지국이 설치되지 않은 곳을 
    start, end를 옮겨가면서 구하고 list에 넣어둔다. 그리고, 그 것들의 크기를 통해
    기지국의 개수를 구한다.
*/
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int i = 1;
        int idx = 0;
        
        while (i <= n) {
            if (idx < stations.length && stations[idx]-w <= i) {
                i = stations[idx] + w + 1;
                idx++;
                continue;
            }
            
            answer++;
            i += w*2 + 1;
        }
        
        
        
//         boolean[] visited = new boolean[n];
        
//         Arrays.fill(visited, false);
        
//         for (int i = 0; i < stations.length; i++) {
//             int v = stations[i] - 1;
                        
//             int start = Math.max(0, v-w);
//             int end = Math.min(n, v+w+1);
            
//             for (int j = start; j < end; j++) {
//                 visited[j] = true;
//             }
//         }
                        
//         int answer = 0;
        
//         for (int i = 0; i < n; ) {
//             if (!visited[i]) {
//                 answer++;
//                 i += w*2 + 1;
//             } else {
//                 i += 1;
//             }
            
            
//         }

        return answer;
    }
}