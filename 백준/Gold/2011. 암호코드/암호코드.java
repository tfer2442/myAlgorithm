import java.util.*;
import java.io.*;

public class Main {
	public static String pwd;
	public static int N;
	public static int[] dp;
	
	public static int solve(int curN) {
		if (curN >= N) {
			return 1;
		}
		
		if (curN == N-1) {
			if (pwd.charAt(curN) == '0') {
				dp[curN] = 0;
				return 0;
			}
			else {
				dp[curN] = 1;
				return 1;
			}
		}
		
		if (pwd.charAt(curN) == '0') return dp[curN] % 1000000;
		if (dp[curN] != 0) return dp[curN] % 1000000;
		
		dp[curN] += solve(curN+1);					
		
		if (pwd.charAt(curN) >= '3') return dp[curN] % 1000000;
		if (pwd.charAt(curN) == '2' && pwd.charAt(curN+1) >= '7') return dp[curN] % 1000000;		
		
		dp[curN] += solve(curN+2) % 1000000;
		
		return dp[curN] % 1000000;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pwd = br.readLine();
		N = pwd.length();
		dp = new int[N];
		
		System.out.println(solve(0) % 1000000);
	}

}
