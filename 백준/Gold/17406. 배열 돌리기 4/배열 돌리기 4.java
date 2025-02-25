import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, K;
	public static int[][] board;
	public static int[][] orders;
	public static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static int minValue = Integer.MAX_VALUE;
	public static int[] perms;
	public static boolean[] visited;
	
	public static void permutation(int cnt) {
        if (cnt == K) {
            // 깊은 복사: 원본 배열 board를 temp에 복사
            int[][] temp = new int[N][M];
            for (int i = 0; i < N; i++) {
                temp[i] = board[i].clone();
            }
            
            // 저장된 순열(perms)을 기반으로 회전 연산 수행
            for (int i = 0; i < K; i++) {
                int idx = perms[i];
                rotate(temp, orders[idx][0], orders[idx][1], orders[idx][2]);
            }
            
            // 각 행의 합 중 최솟값 갱신
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += temp[i][j];
                }
                minValue = Math.min(minValue, sum);
            }
            return;
        }
		
		for (int i = 0; i < K; i++) {
			if (visited[i]) continue;
			perms[cnt] = i;
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void rotate(int[][] board, int r, int c, int s) {
		int sr = r-s;
		int sc = c-s;
		int er = r+s;
		int ec = c+s;
		
		for (int i = 0; i < s; i++) {
			int[] nums = new int[(s-i)*8 + 1];
			int curR = sr+i;
			int curC = sc+i;
			int index = 0;
			
			for (int j = 0; j < (s-i)*8; j++) {
				
				if (curR + d[index][0] > er-i || curR + d[index][0] < sr+i || curC+d[index][1] > ec-i || curC+d[index][1] < sc+i ) {
					index += 1;
				}
				
				nums[j+1] = board[curR][curC];
				curR += d[index][0];
				curC += d[index][1];
			}
			nums[0] = nums[nums.length-1];
			
			curR = sr+i;
			curC = sc+i;
			index = 0;
			
			for (int j = 0; j < (s-i)*8; j++) {
				if (curR + d[index][0] > er-i || curR + d[index][0] < sr+i || curC+d[index][1] > ec-i || curC+d[index][1] < sc+i ) {
					index += 1;
				}
				
				board[curR][curC] = nums[j];
				curR += d[index][0];
				curC += d[index][1];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		orders = new int[K][3];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			orders[i][0] = Integer.parseInt(st.nextToken()) - 1;
			orders[i][1] = Integer.parseInt(st.nextToken()) - 1;
			orders[i][2] = Integer.parseInt(st.nextToken());
		}
		
		perms = new int[K];
		visited = new boolean[K];
		
		permutation(0);
		

		System.out.println(minValue);
	}
}
