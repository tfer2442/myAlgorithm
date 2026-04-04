import java.util.*;
import java.io.*;

public class Main {
    public static char[][] board;
    public static int N, M;
    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static boolean calculate(int r, int c, int k) { 
    	if (board[r][c] == '|') { 
    		if (k == 0 || k == 2) return true; 
    	} 
    	else if (board[r][c] == '-') { 
    		if (k == 1 || k == 3) return true; 
    	} else if (board[r][c] == '+') { 
    		return true; 
    	} else if (board[r][c] == '1') { 
    		if (k == 0 || k == 3) return true; 
    	} else if (board[r][c] == '2') { 
    		if (k == 2 || k == 3) return true; 
    	} else if (board[r][c] == '3') { 
    		if (k == 1 || k == 2) return true; 
    	} else if (board[r][c] == '4') { 
    		if (k == 0 || k == 1) return true; 
    	} return false; 
    }

    public static char decisionTwo(boolean[] opend) {
        if (opend[0] && opend[2]) {
            return '|';
        }

        if (opend[1] && opend[3]) {
            return '-';
        }

        if (opend[1] && opend[2]) {
            return '1';
        }

        if (opend[0] && opend[1]) {
            return '2';
        }

        if (opend[0] && opend[3]) {
            return '3';
        }

        if (opend[2] && opend[3]) {
            return '4';
        }

        return '?';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != '.') continue;

                boolean[] opend = new boolean[4];
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nextR = i + d[k][0];
                    int nextC = j + d[k][1];

                    if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
                    if (board[nextR][nextC] == '.') continue;

                    if (board[nextR][nextC] == 'M' || board[nextR][nextC] == 'Z') {
                        boolean flag = false;

                        for (int m = 0; m < 4; m++) {
                            int nextRR = nextR + d[m][0];
                            int nextCC = nextC + d[m][1];

                            if (nextRR < 0 || nextRR >= N || nextCC < 0 || nextCC >= M) continue;
                            if (nextRR == i && nextCC == j) continue;
                            if (board[nextRR][nextCC] == '.' || board[nextRR][nextCC] == 'M' || board[nextRR][nextCC] == 'Z') continue;

                            flag = true;
                            break;
                        }

                        if (!flag) {
                            cnt++;
                            opend[k] = true;
                        }
                    } else {
                        //int reverseDir = (k + 2) % 4;
                        if (calculate(nextR, nextC, k)) {
                            cnt++;
                            opend[k] = true;
                        }
                    }
                }

                if (cnt == 4) {
                    System.out.println((i + 1) + " " + (j + 1) + " " + "+");
                    return;
                } else if (cnt == 2) {
                    System.out.println((i + 1) + " " + (j + 1) + " " + decisionTwo(opend));
                    return;
                }
            }
        }
    }
}