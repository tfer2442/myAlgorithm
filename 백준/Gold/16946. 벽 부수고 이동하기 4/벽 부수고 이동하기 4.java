import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] board;
    public static int[][] check;
    public static Map<Integer, Integer> areaSize = new HashMap<>();
    public static int[][] d = {{-1 ,0}, {0, -1}, {0, 1}, {1, 0}};
    public static int order = 0;

    public static void bfs(int curR, int curC) {
        order++;
        int result = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{curR, curC});
        check[curR][curC] = order;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dd : d) {
                int nextR = cur[0] + dd[0];
                int nextC = cur[1] + dd[1];

                if (0 > nextR || N <= nextR || 0 > nextC || M <= nextC) continue;
                if (board[nextR][nextC] != 0 || check[nextR][nextC] != 0) continue;

                check[nextR][nextC] = order;
                queue.add(new int[]{nextR, nextC});
                result++;
            }
        }

        areaSize.put(order, result);
    }

    public static void main(String[] args) throws Exception {
        // 입력 부분은 동일
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        check = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        // BFS를 통해 영역 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0 && check[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        // 결과 계산 및 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    sb.append(0);
                } else {
                    HashSet<Integer> hs = new HashSet<>();
                    int sum = 1; // 현재 벽 위치도 포함하므로 1부터 시작

                    for (int[] dd : d) {
                        int nextR = i + dd[0];
                        int nextC = j + dd[1];

                        if (0 > nextR || N <= nextR || 0 > nextC || M <= nextC) continue;
                        if (board[nextR][nextC] == 1) continue;

                        int areaNum = check[nextR][nextC];
                        if (hs.contains(areaNum)) continue;

                        hs.add(areaNum);
                        sum += areaSize.get(areaNum);
                    }

                    sb.append(sum % 10);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
