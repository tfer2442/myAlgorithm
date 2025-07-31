import java.util.*;
import java.io.*;

/*
 * 계란의 수 : 1 <= N <= 8
 * 계란 내구도 : 1 <= S <= 300
 * 계란 무게 : 1 <= W <= 300
 * 
 * 계란의 수가 작으므로 모든 경우의 수를 확인
 * 계란을 차례대로 들면서, 깨지지 않은 계란을 친다.
 * 모든 계란을 손에 들고 치는 행위를 마쳤을 때, 최대로 꺨 수 있는 계란의 개수를 출력
 */
public class Main {
	public static int N;
	public static int[][] eggs;
	public static int answer;
	
	public static void backtracking(int cur) {
		if (cur >= N) {
			int total = 0;
			
			for (int i = 0; i < N; i++) {
				if (eggs[i][0] <= 0) {
					total++;
				}
			}
			
			answer = Math.max(answer, total);
			
			return;
		}
		
		if (eggs[cur][0] <= 0) {
			backtracking(cur+1);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i == cur) continue;
			if (eggs[i][0] <= 0) continue;
			
			eggs[i][0] -= eggs[cur][1];
			eggs[cur][0] -= eggs[i][1];
			backtracking(cur+1);
			eggs[i][0] += eggs[cur][1];
			eggs[cur][0] += eggs[i][1];
		}
		
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			if (eggs[i][0] <= 0) {
				total++;
			}
		}
		
		answer = Math.max(answer, total);		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(0);
		
		System.out.println(answer);
	}
}
