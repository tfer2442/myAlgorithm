import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 다리에 올라간 트럭의 무게를 담는 변수
        int total = 0;
        
        // 다리에 올라가 있는 트럭을 담는 Queue, [0] : 올라가있던 시간, [1] : 트럭 무게
        // 트럭 무게가 있어야 하는 이유는, 다리에서 트럭이 내려왔을 때 total 값을 빼줘야함
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        int time = 0;
        int idx = 0; // 올라가야 하는 트럭의 인덱스
        while (true) {
            
            // 현재 시간에 해야하는 것.
            // 1초를 늘린다.
            // 모든 다리 위의 트럭이 1만큼 더 이동해야 한다. (이 때, 내려오는 트럭도 있음)
            // 대기 트럭의 맨 앞의 트럭이 다리위에 올라올 수 있으면 올린다.
            time++;
            
            int size = dq.size();
            
            for (int i = 0; i < size; i++) {
                int[] node = dq.poll();
                
                if (node[0]+1 == bridge_length) {
                    total -= node[1];
                } else {
                    dq.add(new int[]{node[0]+1, node[1]});
                }
            }
            
            if (dq.isEmpty() && idx >= truck_weights.length) {
                break;
            }
            
            if (idx >= truck_weights.length) continue;
            if (total + truck_weights[idx] > weight) continue;
            total += truck_weights[idx];
            dq.add(new int[]{0, truck_weights[idx]});
            idx++;
        }
        
        
        
        return time;
    }
}