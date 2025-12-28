import java.util.*;

/*
    1. 끝나는 시간을 기준으로 오름차순 정렬
    2. 반복문을 돌면서, 현재 routes의 끝나는 시간에 카메라를 두기
    3. 이미 봤던 곳은 보지 않기
*/
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            if (Integer.compare(o1[1], o2[1]) == 0) {
                return Integer.compare(o1[0], o2[0]);
            }
        
            return Integer.compare(o1[1], o2[1]);
        });
        
        boolean[] visited = new boolean[routes.length];
        
        for (int i = 0; i < routes.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                
                for (int j = i+1; j < routes.length; j++) {
                    if (routes[j][0] <= routes[i][1]) {
                        visited[j] = true;
                        continue;
                    }
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}