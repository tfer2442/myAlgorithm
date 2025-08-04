import java.util.*;
import java.io.*;


/*
 * 행, 열이 등차수열을 이루면서 완전 제곱수를 찾는 문제
 * 행의 등차 -9~9, 열의 등차 -9~9 를 순열 완전탐색
 * 완전 제곱수인지 확인하는 메서드 필요
 * -> 미리 완전 제곱수를 Set에 넣어놓고, 확인하는게 빠를듯
 * 최대 만들어질 수 있는 숫자는 999_999_999
 */
public class Main {
	public static int N, M;
	public static int[][] board;
	public static int[] combi;
	public static HashSet<String> hs;
	public static int answer = -1;
	
	public static void calculate() {
		int dr = combi[0];
		int dc = combi[1];
		

		// 수열의 시작칸 선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 수열의 시작칸으로부터 끝까지 확인
				int r = i;
				int c = j;
				StringBuilder value = new StringBuilder();
				value.append(String.valueOf(board[r][c]));
			
				for (int k = 0; k < 10; k++) {
					
					if (hs.contains(value.toString())) {
						answer = Math.max(answer, Integer.parseInt(value.toString()));						
					}
					
					if (r + dr >= N || r + dr < 0 || c + dc >= M || c + dc < 0) break;
					r += dr;
					c += dc;
					value.append(String.valueOf(board[r][c]));
				}
			}
		}
	}

	public static void combination(int depth) {
		if (depth == 2) {
			calculate();
			return;
		}
		
		for (int i = -9; i < 10; i++) {
			combi[depth] = i;
			combination(depth+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		hs = new HashSet<>();
		
		int maxValue = (int)Math.sqrt(1_000_000_000);
		for (int i = 0; i <= maxValue; i++) {
			hs.add(String.valueOf(i*i));
		}
		
		combi = new int[2];
		combination(0);
		
		System.out.println(answer);
	}
}
