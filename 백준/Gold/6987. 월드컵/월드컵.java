import java.util.*;
import java.io.*;

/*
 * 23분 25초
 * 
 * 가능한 대진표인지 확인하는 문제
 * 총 국가는 6개
 * 모든 경우의 수를 확인 -> 6C2 = 15, 시간복잡도 3**15
 * 
 */
public class Main {
	public static int[][] board;
	public static int[][] games;
	public static int[][] result;
	public static int flag;
	
	// 입력 유효성 검사 - 조기 차단
	public static boolean isValidInput() {
		// 각 팀이 정확히 5경기를 했는지 확인
		for (int i = 0; i < 6; i++) {
			if (board[i][0] + board[i][1] + board[i][2] != 5) {
				return false;
			}
		}
		
		// 전체 승수 = 전체 패수 여야 함
		int totalWins = 0, totalLoses = 0;
		for (int i = 0; i < 6; i++) {
			totalWins += board[i][0];
			totalLoses += board[i][2];
		}
		
		return totalWins == totalLoses;
	}
	
	public static void calculate(int cnt) {
		if (flag == 1) {
			return;
		}
		
	    for (int i = 0; i < 6; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (result[i][j] > board[i][j]) {
	                return; // 이미 목표치를 초과했으면 불가능
	            }
	        }
	    }
		
		if (cnt >= 15) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] != result[i][j]) return;
				}
			}
			
			flag = 1;
			return;
		}
		
		int left = games[cnt][0];
		int right = games[cnt][1];
		
		// 왼쪽 팀이 이겼을 경우
		result[left][0] += 1;
		result[right][2] += 1;
		calculate(cnt+1);
		result[left][0] -= 1;
		result[right][2] -= 1;
		
		// 오른쪽 팀이 이겼을 경우
		result[right][0] += 1;
		result[left][2] += 1;
		calculate(cnt+1);
		result[right][0] -= 1;
		result[left][2] -= 1;
		
		// 비겼을 경우
		result[left][1] += 1;
		result[right][1] += 1;
		calculate(cnt+1);
		result[left][1] -= 1;
		result[right][1] -= 1;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		games = new int[15][2];
		
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = i+1; j < 6; j++) {
				games[cnt][0] = i;
				games[cnt][1] = j;
				cnt++;
			}
		}
				
		for (int i = 0; i < 4; i++) {
			board = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 조기 차단: 입력 유효성 검사
			if (!isValidInput()) {
				sb.append("0 ");
				continue;
			}
			
			result = new int[6][3];
			flag = 0;
			calculate(0);
			sb.append(flag + " ");
		}
		
		System.out.println(sb);
	}
}