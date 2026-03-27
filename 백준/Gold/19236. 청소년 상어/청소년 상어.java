//import java.util.*;
//import java.io.*;
//
//public class BOJ19236 {
//	public static int[][] d = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
//	public static int[][][] board; // [0][0][0] -> 물고기번호, [0][0][1] -> 방향
//	public static boolean[] visited;
//	public static int[][] fish;
//	public static int answer = 0;
//	
//	public static void moveFish(int[][][] board) {
//		for (int i = 1; i <= 16; i++) {
//			if (visited[i]) continue;
//			
//			// 방향 변경해주기
//			int curR = fish[i][0];
//			int curC = fish[i][1];
//			int curD = board[curR][curC][1];
//			int nextR = curR;
//			int nextC = curC;
//			
//			boolean flag = false;
//			
//			for (int j = 0; j < 8; j++) {
//				curD = (curD + j) % 8;
//				int nextR = curR + d[curD][0];
//				int nextC = curC + d[curD][1];
//				
//				if (nextR < 0 || nextR >= 4 || nextC < 0 || nextC >= 4) continue;
//				if (board[nextR][nextC] == 17) continue;
//				
//				flag = true;
//				break;
//			}
//			
//			// 물고기의 방향은 curD로 변경해줘야 한다 일단
//			// board와 fish를 수정해줘야 함.
//			
//		}
//	}
//	
//	public static int[][][] copyBoard(int[][][] board) {
//		int[][][] maps = new int[4][4][2];
//		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				for (int k = 0; k < 2; k++) {
//					maps[i][j][k] = board[i][j][k];
//				}
//			}
//		}
//		
//		return maps;
//	}
//	
//	// depth, r, c, dir, value
//	public static void dfs(int[][][] board, int depth, int curR, int curC, int curD, int value) {
//		if (depth >= 16 || curR < 0 || curR >= 4 || curC < 0 || curC >= 4) {
//			answer = Math.max(answer, value);
//			
//			return; 
//		}
//		
//		// 물고기 이동
//		// 새 board 만들기
//		int[][][] maps = copyBoard(board);
//		moveFish(maps);
//		
//		// 상어 이동
//	}
//	
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		board = new int[4][4][2];
//		fish = new int[17][2];
//		
//		for (int i = 0; i < 4; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//			for (int j = 0; j < 4; j++) {
//				// 물고기 번호
//				int a = Integer.parseInt(st.nextToken());
//				// 방향
//				int b = Integer.parseInt(st.nextToken())-1;
//				
//				board[i][j][0] = a;
//				board[i][j][1] = b;
//				
//				fish[a][0] = i;
//				fish[a][1] = j;
//			}
//		}
//		
//		int tmp = board[0][0][0];
//		visited = new boolean[17];
//		visited[tmp] = true;
//		
//		board[0][0][0] = 17; // 상어 넣기
//		
//		// depth, r, c, dir, value
//		dfs(board, 1, 0, 0, board[0][0][1], tmp);
//	}
//
//}

import java.util.*;
import java.io.*;

public class Main {
    public static int[][] d = {
        {-1, 0}, {-1, -1}, {0, -1}, {1, -1},
        {1, 0}, {1, 1}, {0, 1}, {-1, 1}
    };

    public static int[][][] board; // [r][c][0] = 번호, [r][c][1] = 방향
    public static boolean[] visited;
    public static int[][] fish;    // fish[num][0] = r, fish[num][1] = c
    public static int answer = 0;

    public static void moveFish(int[][][] board, int[][] fish) {
        for (int i = 1; i <= 16; i++) {
            if (visited[i]) continue;

            int curR = fish[i][0];
            int curC = fish[i][1];
            int dir = board[curR][curC][1];

            for (int j = 0; j < 8; j++) {
                int curD = (dir + j) % 8;
                int nextR = curR + d[curD][0];
                int nextC = curC + d[curD][1];

                if (nextR < 0 || nextR >= 4 || nextC < 0 || nextC >= 4) continue;
                if (board[nextR][nextC][0] == 17) continue;

                int targetFishNum = board[nextR][nextC][0];
                int targetFishDir = board[nextR][nextC][1];

                // swap
                board[nextR][nextC][0] = i;
                board[nextR][nextC][1] = curD;

                board[curR][curC][0] = targetFishNum;
                board[curR][curC][1] = targetFishDir;

                fish[i][0] = nextR;
                fish[i][1] = nextC;

                if (targetFishNum != 0) {
                    fish[targetFishNum][0] = curR;
                    fish[targetFishNum][1] = curC;
                }

                break;
            }
        }
    }

    public static int[][][] copyBoard(int[][][] board) {
        int[][][] maps = new int[4][4][2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    maps[i][j][k] = board[i][j][k];
                }
            }
        }

        return maps;
    }

    public static int[][] copyFish(int[][] fish) {
        int[][] temp = new int[17][2];

        for (int i = 1; i <= 16; i++) {
            temp[i][0] = fish[i][0];
            temp[i][1] = fish[i][1];
        }

        return temp;
    }

    // depth, r, c, dir, value
    public static void dfs(int[][][] board, int[][] fish, int depth, int curR, int curC, int curD, int value) {
        answer = Math.max(answer, value);

        int[][][] maps = copyBoard(board);
        int[][] fishCopy = copyFish(fish);

        // 현재 visited 상태를 기준으로 물고기 이동
        moveFish(maps, fishCopy);

        // 상어 이동
        for (int step = 1; step <= 3; step++) {
            int nextR = curR + d[curD][0] * step;
            int nextC = curC + d[curD][1] * step;

            if (nextR < 0 || nextR >= 4 || nextC < 0 || nextC >= 4) break;
            if (maps[nextR][nextC][0] == 0) continue;

            int fishNum = maps[nextR][nextC][0];
            int fishDir = maps[nextR][nextC][1];

            if (fishNum == 17) continue;

            int[][][] nextBoard = copyBoard(maps);
            int[][] nextFish = copyFish(fishCopy);

            nextBoard[curR][curC][0] = 0;
            nextBoard[curR][curC][1] = 0;

            nextFish[fishNum][0] = -1;
            nextFish[fishNum][1] = -1;

            nextBoard[nextR][nextC][0] = 17;
            nextBoard[nextR][nextC][1] = fishDir;

            visited[fishNum] = true;
            dfs(nextBoard, nextFish, depth + 1, nextR, nextC, fishDir, value + fishNum);
            visited[fishNum] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[4][4][2];
        fish = new int[17][2];
        visited = new boolean[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;

                board[i][j][0] = a;
                board[i][j][1] = b;

                fish[a][0] = i;
                fish[a][1] = j;
            }
        }

        int firstFish = board[0][0][0];
        int firstDir = board[0][0][1];

        visited[firstFish] = true;
        fish[firstFish][0] = -1;
        fish[firstFish][1] = -1;

        board[0][0][0] = 17;
        board[0][0][1] = firstDir;

        dfs(board, fish, 1, 0, 0, firstDir, firstFish);

        System.out.println(answer);
    }
}