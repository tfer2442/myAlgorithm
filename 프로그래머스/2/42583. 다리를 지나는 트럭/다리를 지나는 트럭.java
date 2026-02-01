import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        // q 원소: [0] = 트럭 무게, [1] = 내려오는 시간(exitTime)

        int time = 1;      // 첫 트럭은 time=1 시점(1초 지난 뒤)에 올라갈 수 있게 맞춤
        int idx = 0;
        int total = 0;

        while (idx < truck_weights.length || !q.isEmpty()) {

            // 현재 time에 내려오는 트럭들 먼저 처리
            while (!q.isEmpty() && q.peek()[1] == time) {
                total -= q.poll()[0];
            }

            // 아직 올릴 트럭이 남아 있고, 지금 올릴 수 있으면 올린다
            if (idx < truck_weights.length && total + truck_weights[idx] <= weight) {
                int w = truck_weights[idx];
                total += w;
                q.add(new int[]{w, time + bridge_length});
                idx++;

                // 규칙상 1초에 1대만 진입 가능 → 다음 시도를 위해 1초 진행
                time++;
            } else {
                // 못 올리는 경우:
                // (1) 다리에 트럭이 있으면 다음 "하차 이벤트" 시점으로 점프
                // (2) 다리가 비었으면 그냥 1초 진행 (이 케이스는 보통 거의 안 나옴)
                if (!q.isEmpty()) time = q.peek()[1];
                else time++;
            }
        }

        return time-1;
    }
}


// import java.util.*;

// class Solution {
//     public int solution(int bridge_length, int weight, int[] truck_weights) {
//         int answer = 0;
        
//         // 다리에 올라간 트럭의 무게를 담는 변수
//         int total = 0;
        
//         // 다리에 올라가 있는 트럭을 담는 Queue, [0] : 올라가있던 시간, [1] : 트럭 무게
//         // 트럭 무게가 있어야 하는 이유는, 다리에서 트럭이 내려왔을 때 total 값을 빼줘야함
//         ArrayDeque<int[]> dq = new ArrayDeque<>();
        
//         int time = 0;
//         int idx = 0; // 올라가야 하는 트럭의 인덱스
//         while (true) {
            
//             // 현재 시간에 해야하는 것.
//             // 1초를 늘린다.
//             // 모든 다리 위의 트럭이 1만큼 더 이동해야 한다. (이 때, 내려오는 트럭도 있음)
//             // 대기 트럭의 맨 앞의 트럭이 다리위에 올라올 수 있으면 올린다.
//             time++;
            
//             int size = dq.size();
            
//             for (int i = 0; i < size; i++) {
//                 int[] node = dq.poll();
                
//                 if (node[0]+1 == bridge_length) {
//                     total -= node[1];
//                 } else {
//                     dq.add(new int[]{node[0]+1, node[1]});
//                 }
//             }
            
//             if (dq.isEmpty() && idx >= truck_weights.length) {
//                 break;
//             }
            
//             if (idx >= truck_weights.length) continue;
//             if (total + truck_weights[idx] > weight) continue;
//             total += truck_weights[idx];
//             dq.add(new int[]{0, truck_weights[idx]});
//             idx++;
//         }
        
        
        
//         return time;
//     }
// }