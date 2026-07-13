import java.util.*;

class Solution {
    /* dq를 이용해서 풀 수 있을 거 같음
    다리에 올라가 있는 트럭의 무게를 누적합으로 가지고 있기
    다리를 건너고 있는 트럭을 담는 dq를 만들자 ((트럭 무게, 다리에 올라온 시간)을 담자)
    */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        int i = 0;
        int time = 1;
        
        // 대기 트럭을 다리에 모두 올릴 때까지 시행
        while (i < truck_weights.length) {
            // 다리를 건넌 트럭이 있다면 모두 내리기
            
            while (!dq.isEmpty()) {
                if (dq.getFirst()[1]+bridge_length <= time) {
                    int[] node = dq.pollFirst();
                    sum -= node[0];
                } else {
                    break;
                }
            }
            
            // 트럭 올리기
            if (weight >= sum + truck_weights[i]) {
                sum += truck_weights[i];
                dq.add(new int[]{truck_weights[i], time});
                i++;
            }
            
            // 시간++
            time++;
        }
        
        while (!dq.isEmpty()) {
            int[] node = dq.pollFirst();
            time = node[1] + bridge_length;
        }
        
        // 다리를 건너고 있는 트럭 처리
        
        return time;
    }
}