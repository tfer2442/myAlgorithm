import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        distance = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.add(new int[]{0, 0, 0});
        distance[0][0] = 0;

        int res = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int d = cur[0];
            int r = cur[1];
            int c = cur[2];

            if(d > distance[r][c]) continue;

            res = Math.max(res, d);

            if(r == N-1 && c == N-1) break;

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                    int newD = Math.abs(arr[nr][nc] - arr[r][c]);

                    int updatedD = Math.max(d, newD);

                    if(updatedD < distance[nr][nc]){
                        distance[nr][nc] = updatedD;
                        q.add(new int[]{updatedD, nr, nc});
                    }
                }
            }
        }

        return res;
    }
}
