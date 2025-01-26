import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static char[][] board;
    public static int[][][] distance;
    public static int[][] d = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int[] start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        M = Integer.parseInt(tmp[0]); // W
        N = Integer.parseInt(tmp[1]); // H
        
        board = new char[N][M];
        start = new int[2];
        end = new int[2];
        start[0] = -1;
        start[1] = -1;
        end[0] = -1;
        end[1] = -1;
        
        for (int i = 0; i < N; i++) {
            String tmp2 = br.readLine();
            
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp2.charAt(j);
                
                if (board[i][j] == 'C') {
                    if (start[0] == -1) {
                        start[0] = i;
                        start[1] = j;
                    } else {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
        }
    
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        distance = new int[4][N][M];
        
        // 모든 방향의 거리 초기화
        for(int dir = 0; dir < 4; dir++) {
            for(int i = 0; i < N; i++) {
                Arrays.fill(distance[dir][i], Integer.MAX_VALUE);
            }
        }
        
        // 초기 위치의 거리 설정
        for(int dir = 0; dir < 4; dir++) {
            distance[dir][start[0]][start[1]] = 0;
            dq.add(new int[] {dir, start[0], start[1]});
        }

        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            int dir = node[0];
            int r = node[1];
            int c = node[2];
            
            for (int i = 0; i < 4; i++) {
                // 반대 방향으로는 이동하지 않음
                if ((dir == 0 && i == 2) || (dir == 1 && i == 3) || 
                    (dir == 2 && i == 0) || (dir == 3 && i == 1)) {
                    continue;
                }
                
                int nextR = r + d[i][0];
                int nextC = c + d[i][1];
                
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
                if (board[nextR][nextC] == '*') continue;
            
                // 방향이 같으면 거울을 설치하지 않음, 다르면 설치
                int val = (i == dir) ? 0 : 1;
                
                if (distance[i][nextR][nextC] > distance[dir][r][c] + val) {
                    distance[i][nextR][nextC] = distance[dir][r][c] + val;
                    if (val == 0) {
                        dq.addFirst(new int[] {i, nextR, nextC});
                    } else {
                        dq.addLast(new int[] {i, nextR, nextC});
                    }
                }
            }
        }
        
        // 최종 지점의 모든 방향 중 최소 거울 개수 찾기
        int minMirrors = Integer.MAX_VALUE;
        for(int dir = 0; dir < 4; dir++) {
            minMirrors = Math.min(minMirrors, distance[dir][end[0]][end[1]]);
        }
        
        System.out.println(minMirrors);
    }
}
