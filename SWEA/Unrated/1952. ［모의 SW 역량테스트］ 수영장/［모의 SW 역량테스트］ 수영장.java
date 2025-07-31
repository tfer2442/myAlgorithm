import java.util.*;
import java.io.*;

/*
 * 1일 이용권, 1달 이용권, 3달 이용권, 1년 이용권
 * 각 월의 이용 계획(사용 일 수)이 주어진다. 이 때, 어떻게 구매하는게 가장 효율적인가?
 * 
 * 주의할 점
 * 1. 1일 이용권보다 1달 이용권이 더 쌀 수 있다. (모든 경우에 있어서, 사용일자가 적은 이용권이라고 싼 것은 아님)
 * 
 * 해결방법
 * 1. 1년 이용권을 기준으로 answer를 초기화 해둔다.
 * 2. 각 월을 1일 이용권, 1달 이용권, 3달 이용권 중 어떤 것으로 처리할지 결정한다. 
 * 3. 이를 백트래킹을 이용하여 반복한다.
 * 4. 백트래킹에서 answer 값보다 넘어온 인자의 값이 크다면, 가지치기가 가능하다.
 * 
 * 놓친점
 * 1. calendar[month] == 0 인 경우에는 확인안해도 되므로 가지치기 했어야 한다.
 */
public class Solution {
	public static int T;
	public static int[] costs;
	public static int[] calendar;
	public static int answer;
	
	public static void backtracking(int month, int total) {
		if (answer <= total) {
			return;
		}
		

		if (month >= 12) {
			answer = Math.min(answer, total);
			return;
		}
		
		if (calendar[month] == 0) {
			backtracking(month+1, total);
			return;
		}
		
		// 현재 달을 1일권으로 처리 
		backtracking(month+1, total+calendar[month]*costs[0]);
		
		// 현재 달을 1달권으로 처리
		backtracking(month+1, total+costs[1]);
		
		// 현재 달을 3달권으로 처리		
		backtracking(month+3, total+costs[2]);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			costs = new int[4];
			calendar = new int[12];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				calendar[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = costs[3];
			backtracking(0, 0);
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}
