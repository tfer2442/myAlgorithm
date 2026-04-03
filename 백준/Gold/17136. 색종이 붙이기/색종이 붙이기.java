import java.util.*;
import java.io.*;

public class Main {
	public static int[][] board;
	public static int answer = 1000;
	
	public static void dfs(int num, int one, int two, int three, int four, int five) {
		if (num == 100) {
			boolean flag = false;
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (board[i][j] == 1) {
						flag = true;
						return;
					}
				}
			}
			
			int sum = (5-one) + (5-two) + (5-three) + (5-four) + (5-five);
			
			answer = Math.min(answer, sum);
					
			return;
		}
		
		int r = num / 10;
		int c = num % 10;
		
		if (board[r][c] == 0) {
			dfs(num+1, one, two, three, four, five);
			return;
		}
		
		for (int s = 1; s <= 5; s++) {
			if (s == 1 && one == 0) continue;
			if (s == 2 && two == 0) continue;
			if (s == 3 && three == 0) continue;
			if (s == 4 && four == 0) continue;
			if (s == 5 && five == 0) continue;
			
			// r, c에 색종이 크기 i를 놓을 수 있는지 확인
			// 만약 놓지 못한다면, 바로 return (뒤에 있는 사이즈는 반드시 못 놓음)
			for (int i = r; i < r + s; i++) {
				if (i >= 10) return; 
				
				for (int j = c; j < c + s; j++) {
					if (j >= 10) return;
					if (board[i][j] == 0) {
						return;
					}
				}
			}
			
			for (int i = r; i < r + s; i++) {
				for (int j = c; j < c + s; j++) {
					board[i][j] = 0;
				}
			}
			
			if (s == 1) {
				dfs(num+1, one-1, two, three, four, five);
			}
			
			if (s == 2) {
				dfs(num+1, one, two-1, three, four, five);
			}
			
			if (s == 3) {
				dfs(num+1, one, two, three-1, four, five);
			}
			
			if (s == 4) {
				dfs(num+1, one, two, three, four-1, five);
			}
			
			if (s == 5) {
				dfs(num+1, one, two, three, four, five-1);
			}
			
			for (int i = r; i < r + s; i++) {
				for (int j = c; j < c + s; j++) {
					board[i][j] = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) { 
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 5, 5, 5, 5, 5);
		
		if (answer == 1000) {
			System.out.println(-1);
		} else {
			System.out.println(answer);	
		}
	}
}
