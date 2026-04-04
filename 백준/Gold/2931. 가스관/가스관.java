import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;

    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean isPipe(char ch) {
        return ch == '|' || ch == '-' || ch == '+' ||
               ch == '1' || ch == '2' || ch == '3' || ch == '4';
    }

    static boolean[] getDirs(char ch) {
        boolean[] dirs = new boolean[4];

        switch (ch) {
            case '|':
                dirs[0] = true;
                dirs[2] = true;
                break;
            case '-':
                dirs[1] = true;
                dirs[3] = true;
                break;
            case '+':
                dirs[0] = dirs[1] = dirs[2] = dirs[3] = true;
                break;
            case '1': // 우, 하
                dirs[1] = true;
                dirs[2] = true;
                break;
            case '2': // 상, 우
                dirs[0] = true;
                dirs[1] = true;
                break;
            case '3': // 상, 좌
                dirs[0] = true;
                dirs[3] = true;
                break;
            case '4': // 하, 좌
                dirs[2] = true;
                dirs[3] = true;
                break;
        }

        return dirs;
    }

    static char decideTwoDir(boolean[] need) {
        if (need[0] && need[2]) return '|';
        if (need[1] && need[3]) return '-';
        if (need[1] && need[2]) return '1';
        if (need[0] && need[1]) return '2';
        if (need[0] && need[3]) return '3';
        if (need[2] && need[3]) return '4';
        return '?';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] != '.') continue;

                boolean[] need = new boolean[4];   // 주변 파이프 기준으로 실제 연결이 필요한 방향
                boolean[] mz = new boolean[4];     // M/Z 인접 방향
                int pipeCnt = 0;
                int mzCnt = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                    char next = board[nr][nc];

                    if (isPipe(next)) {
                        boolean[] dirs = getDirs(next);
                        int opposite = (dir + 2) % 4;

                        // 옆 파이프가 현재 빈칸 쪽으로 열려 있으면 연결 필요
                        if (dirs[opposite]) {
                            need[dir] = true;
                            pipeCnt++;
                        }
                    } else if (next == 'M' || next == 'Z') {
                        mz[dir] = true;
                        mzCnt++;
                    }
                }

                char answer = '?';

                if (pipeCnt == 4) {
                    answer = '+';
                } else if (pipeCnt == 2) {
                    answer = decideTwoDir(need);
                } else if (pipeCnt == 1) {
                    int first = -1;
                    for (int i = 0; i < 4; i++) {
                        if (need[i]) {
                            first = i;
                            break;
                        }
                    }

                    // M/Z가 붙어 있으면 그 방향과 first를 연결
                    int second = -1;
                    for (int i = 0; i < 4; i++) {
                        if (mz[i]) {
                            second = i;
                            break;
                        }
                    }

                    boolean[] temp = new boolean[4];
                    temp[first] = true;

                    if (second != -1) {
                        temp[second] = true;
                        answer = decideTwoDir(temp);
                    } else {
                        // 혹시 M/Z가 안 보이면 직선으로 보정
                        if (first == 0 || first == 2) answer = '|';
                        else answer = '-';
                    }
                }

                if (answer != '?') {
                    System.out.println((r + 1) + " " + (c + 1) + " " + answer);
                    return;
                }
            }
        }
    }
}