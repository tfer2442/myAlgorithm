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
            if (!q.isEmpty() && q.peek()[1] == time) {
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
                if (!q.isEmpty()) time = q.peek()[1];
            }
        }

        return time;
    }
}

