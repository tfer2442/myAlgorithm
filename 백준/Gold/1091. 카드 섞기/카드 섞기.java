import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 목표 상태 (각 카드가 어떤 플레이어에게 가야 하는지)
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // 섞는 방법
        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        // 현재 카드의 위치를 표현할 배열 (위치 -> 카드)
        int[] current = new int[N];
        for(int i = 0; i < N; i++) {
            current[i] = i; // 초기 상태: 위치 i에는 카드 i가 있음
        }
        
        // 초기 상태가 목표 상태인지 확인
        if(isGoalState(current, P, N)) {
            System.out.println(0);
            return;
        }
        
        // 이미 방문한 상태를 저장할 해시셋
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(current));
        
        // 섞은 횟수
        int shuffleCount = 0;
        
        while(true) {
            // 카드 섞기
            int[] next = new int[N];
            for(int i = 0; i < N; i++) {
                next[S[i]] = current[i];
            }
            current = next;
            shuffleCount++;
            
            // 목표 상태에 도달했는지 확인
            if(isGoalState(current, P, N)) {
                System.out.println(shuffleCount);
                return;
            }
            
            // 현재 상태를 문자열로 변환하여 방문 여부 확인
            String currentState = Arrays.toString(current);
            if(visited.contains(currentState)) {
                // 이미 방문한 상태라면 목표에 도달할 수 없음
                System.out.println(-1);
                return;
            }
            
            // 현재 상태 방문 표시
            visited.add(currentState);
        }
    }
    
    // 현재 상태가 목표 상태인지 확인하는 함수
    private static boolean isGoalState(int[] current, int[] P, int N) {
        for(int i = 0; i < N; i++) {
            // 위치 i에 있는 카드는 current[i]
            // 이 카드는 플레이어 (i % 3)에게 갈 것임
            // 카드 current[i]는 플레이어 P[current[i]]에게 가야 함
            if(i % 3 != P[current[i]]) {
                return false;
            }
        }
        return true;
    }
}