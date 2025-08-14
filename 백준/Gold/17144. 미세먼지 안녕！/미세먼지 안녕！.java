import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] board, tmp;
    static int top, bottom; // 공기청정기 행(위/아래)
    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};

    static void spread() {
        // tmp를 0으로
        for (int i = 0; i < R; i++) Arrays.fill(tmp[i], 0);

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int val = board[r][c];
                if (val <= 0) continue; // 0 또는 -1(공기청정기)

                int give = val / 5;
                int cnt = 0;

                // 4방향 확산 누적
                if (give > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                        if (board[nr][nc] == -1) continue;
                        tmp[nr][nc] += give;
                        cnt++;
                    }
                }
                // 자기 자리 잔여
                tmp[r][c] += (val - give * cnt);
            }
        }
        // 공기청정기 위치 복원
        tmp[top][0] = -1;
        tmp[bottom][0] = -1;

        // 스왑 (참조만 교체)
        int[][] t = board; board = tmp; tmp = t;
    }

    static void cleanAir() {
        // 상부(반시계) 순환: (top,0)는 청정기
        // 위쪽 경계: 위로, 오른쪽 경계: 오른쪽, 아래: 아래, 왼쪽: 왼쪽 — 반시계 한 바퀴
        // 1) 위로 이동 (top-1..1 -> top..2)
        for (int r = top-1; r > 0; r--) board[r][0] = board[r-1][0];
        // 2) 왼->오 (0..C-2 -> 1..C-1) 맨 윗줄
        for (int c = 0; c < C-1; c++) board[0][c] = board[0][c+1];
        // 3) 아래로 (0..top-1 -> 1..top) 오른쪽 끝
        for (int r = 0; r < top; r++) board[r][C-1] = board[r+1][C-1];
        // 4) 오->왼 (C-1..2 -> C-2..1) top행
        for (int c = C-1; c > 1; c--) board[top][c] = board[top][c-1];
        board[top][1] = 0; // 청정기 옆은 항상 0이 들어옴

        // 하부(시계) 순환
        // 1) 아래로 (bottom+1..R-2 -> bottom..R-3)
        for (int r = bottom+1; r < R-1; r++) board[r][0] = board[r+1][0];
        // 2) 왼->오 (0..C-2 -> 1..C-1) 맨 아랫줄
        for (int c = 0; c < C-1; c++) board[R-1][c] = board[R-1][c+1];
        // 3) 위로 (R-1..bottom+1 -> R-2..bottom) 오른쪽 끝
        for (int r = R-1; r > bottom; r--) board[r][C-1] = board[r-1][C-1];
        // 4) 오->왼 (C-1..2 -> C-2..1) bottom행
        for (int c = C-1; c > 1; c--) board[bottom][c] = board[bottom][c-1];
        board[bottom][1] = 0;

        // 청정기 자리 유지
        board[top][0] = -1;
        board[bottom][0] = -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        tmp = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 공기청정기 위치 탐색
        for (int i = 0; i < R; i++) {
            if (board[i][0] == -1) {
                top = i;
                bottom = i + 1;
                break;
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            cleanAir();
        }

        long ans = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (board[i][j] > 0) ans += board[i][j];

        System.out.println(ans);
    }
}

