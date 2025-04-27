import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 입력 처리
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            graph[A].add(new int[] {B, C});
            graph[B].add(new int[] {A, C}); // 양방향 그래프
        }
        
        // 최적 경로 (오르막길이 최소인 MST) - C가 1인 도로를 우선적으로 선택
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1]; // 내리막길(C=1)을 우선 선택하기 위해 내림차순 정렬
        });
        
        // 최악 경로 (오르막길이 최대인 MST) - C가 0인 도로를 우선적으로 선택
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1]; // 오르막길(C=0)을 우선 선택하기 위해 오름차순 정렬
        });
        
        boolean[] visited1 = new boolean[N+1];
        boolean[] visited2 = new boolean[N+1];
        
        // 시작은 항상 입구(0)에서 시작
        pq1.add(new int[] {0, 0}); // {현재 노드, 가중치}
        pq2.add(new int[] {0, 0});
        
        int optimalUphill = 0; // 최적 경로의 오르막길 수
        int worstUphill = 0;   // 최악 경로의 오르막길 수
        int selectedEdges1 = 0; // 선택된 간선 수 (최적 경로)
        int selectedEdges2 = 0; // 선택된 간선 수 (최악 경로)
        
        // 최적 경로 찾기
        while (!pq1.isEmpty()) {
            int[] cur = pq1.poll();
            int node = cur[0];
            int weight = cur[1];
            
            if (visited1[node]) continue;
            
            visited1[node] = true;
            if (node != 0) { // 시작점이 아닌 경우만 카운트
                selectedEdges1++;
                if (weight == 0) optimalUphill++; // 오르막길(C=0)인 경우만 피로도 증가
            }
            
            // 모든 정점을 방문했으면 종료
            if (selectedEdges1 == N) break;
            
            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int nextWeight = edge[1];
                
                if (!visited1[nextNode]) {
                    pq1.add(new int[] {nextNode, nextWeight});
                }
            }
        }
        
        // 최악 경로 찾기
        while (!pq2.isEmpty()) {
            int[] cur = pq2.poll();
            int node = cur[0];
            int weight = cur[1];
            
            if (visited2[node]) continue;
            
            visited2[node] = true;
            if (node != 0) { // 시작점이 아닌 경우만 카운트
                selectedEdges2++;
                if (weight == 0) worstUphill++; // 오르막길(C=0)인 경우만 피로도 증가
            }
            
            // 모든 정점을 방문했으면 종료
            if (selectedEdges2 == N) break;
            
            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int nextWeight = edge[1];
                
                if (!visited2[nextNode]) {
                    pq2.add(new int[] {nextNode, nextWeight});
                }
            }
        }
        
        // 피로도 계산: k^2
        int optimalFatigue = optimalUphill * optimalUphill;
        int worstFatigue = worstUphill * worstUphill;
        
        // 최악 경로와 최적 경로의 피로도 차이 출력
        System.out.println(worstFatigue - optimalFatigue);
    }
}