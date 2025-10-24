import java.util.*;

/*
직선 도로: 100원, 코너 도로: 500원
최소 도로 비용을 구하여라
*/

class Solution {
    int N;
    int MAX_VALUE = 1_000_000_000;
    int[][][] distance;
    int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int calculate(int[][] board) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[3] - o2[3];
        });
        
        pq.add(new int[]{0, 0, 0, 0});
        pq.add(new int[]{0, 0, 1, 0});
        pq.add(new int[]{0, 0, 2, 0});
        pq.add(new int[]{0, 0, 3, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int r = node[0];
            int c = node[1];
            int k = node[2];
            int value = node[3];
            
            if (distance[r][c][k] < value) continue;
            
            for (int i = 0; i < 4; i++) {
                int nextR = r + d[i][0];
                int nextC = c + d[i][1];
                
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || board[nextR][nextC] == 1) continue;
                
                int sum = distance[r][c][k];
                
                if (k == i || k == -1) {
                    sum += 100;
                } else {
                    sum += 600;
                }
                
                if (distance[nextR][nextC][i] > sum) {
                    distance[nextR][nextC][i] = sum;
                    pq.add(new int[]{nextR, nextC, i, distance[nextR][nextC][i]});
                }
                
            }
        }
        
        int minValue1 = Math.min(distance[N-1][N-1][0], distance[N-1][N-1][1]);
        int minValue2 = Math.min(distance[N-1][N-1][2], distance[N-1][N-1][3]);
        
        return Math.min(minValue1, minValue2);
    }
    
    public int solution(int[][] board) {
        N = board.length;
        
        distance = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    distance[i][j][k] = MAX_VALUE;    
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            distance[0][0][i] = 0;
        }
        
        int answer = calculate(board);
        
        return answer;
    }
}