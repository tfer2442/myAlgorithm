import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int[] result;
	static int answer;
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	static boolean isConnected() {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[25];
		HashSet<Integer> hs = new HashSet<>();
		
		for (int i = 0; i < 7; i++) {
			hs.add(result[i]);
		}
		
		dq.add(result[0]);
		int count = 1;
		visited[result[0]] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			int r = cur / 5;
			int c = cur % 5;
			
			for (int i = 0; i < 4; i++) {
				int nextR = r + d[i][0];
				int nextC = c + d[i][1];
				
				if (nextR < 0 || nextR >= 5 || nextC < 0 || nextC >= 5) {
					continue;
				}
				
				int next = nextR * 5 + nextC;
				
				if (visited[next] || !hs.contains(next)) continue;
				visited[next] = true;
				dq.add(next);
				count++;
			}
		}
		
		if (count == 7) return true;
		
		return false;
	
	}
	
	static void combination(int depth, int idx, int sumY) {
		if (depth == 7) {
			if (isConnected()) {
				answer++;
			}
			
			return;
		}
		
		for (int i = idx; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			
			// 현재 선택한 학생이 임도연파이면서, 기존에 선택한 임도연파 학생이 3보다 크다면
			// 더 이상 선택하면 안됨.
			if (board[r][c] == 1 && sumY >= 3) continue; 
			
			result[depth] = i;
			combination(depth+1, i+1, sumY+board[r][c]);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		result = new int[7];
		
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < 5; j++) {
				board[i][j] = (line.charAt(j) == 'Y') ? 1 : 0;
			}
		}
		
		combination(0, 0, 0);
		
		System.out.println(answer);
	}
}
