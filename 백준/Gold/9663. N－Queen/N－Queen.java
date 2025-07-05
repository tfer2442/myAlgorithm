import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] chess;
	public static int answer;
	
	public static boolean isAvailable(int cur, int col) {
		for (int i = 0; i < cur; i++) {
			// 기울기가 1이거나 -1이라면 놓을 수 없음
			if (Math.abs(cur-i) == Math.abs(col-chess[i])) {
				return false;
			}
			
			// 같은 열에 둘 수 없음
			if (chess[i] == col) {
				return false;
			}
		}
		return true;
	}
	
	// 현재 줄을 입력으로 받아야 함
	public static void backTracking(int cur) {
		if (cur >= N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 현재 줄에서 i번째 열에 퀸을 두어도 되는지 확인
			if (isAvailable(cur, i)) {
				chess[cur] = i;
				backTracking(cur+1);
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	chess = new int[N];
    	
    	backTracking(0);
    	System.out.println(answer);
    }
}